"use strict";

app.controller('ctrlHome',function($scope,$ionicModal,$ionicPlatform,Data,betaOneDB,$ionicLoading,$ionicHistory,$location,$ionicPopup){

	$scope.titulo = "Cartões";
	$scope.contatocadastro = {};

	// Initialize the database.
    $ionicPlatform.ready(function() {

		betaOneDB.getUsers(function(usuario){

			if(usuario.rows.length == 0){//sem usuário
				$ionicHistory.nextViewOptions({
					disableBack: true,
					historyRoot: true
				});
				$location.path("/login");
			}else{
				$scope.usuario = usuario.rows[0];
				$scope.renderHome();
			}

		});

		//CHAMA SE ESTIVER LOGADO, PASSANDO O USUÁRIO, TAMBÉM DEPOIS DE CADASTRAR E DELETAR CONTATO
		$scope.renderHome = function(){
			$ionicLoading.show({
				template: 'Carregando informações...',
			});

			//PEGANDO CONTATOS. PASSA ID DO USUÁRIO E CALLBACK
			betaOneDB.getContacts($scope.usuario.id_user,$scope.getContacts);

			//ATUALIZANDO A VIEW
			if ($scope.$root.$$phase != '$apply' && $scope.$root.$$phase != '$digest') {
				$scope.$apply();
			}

		};

	});

    //CALBACK DO getConctacts do betaOneDB
	$scope.getContacts = function(contatos){
		$scope.contatos = [];
		if(contatos.rows.length > 0){
			for (var i = 0; i < contatos.rows.length; i++) {
				$scope.contatos.push(contatos.rows[i]);
			}
		}else{
			$scope.mostrarmsg = true;
			$scope.mostrarMsgNenhum = "Nenhum contato encontrado.";
			console.log("Sem nenhum");
		}

		$ionicLoading.hide();
	}

	//FUNCAO CHAMADA PELO MODAL PARA CADASTRAR
	$scope.cadastrarContatoLocal = function(contato){

		$ionicLoading.show({
			template: 'Aguarde...',
		});

		//PREPARANDO CAMPO DE LOCALIZAÇÃO
		if(contato.location){
			var loc = JSON.stringify(contato.location.address_components);
			contato.location = loc;
		}

		var today = $scope.getDateNow();

		contato.created_date = today;
		contato.update_date = today;

		contato.id_user = $scope.usuario.id_user;

		//CADASTRANDO CONTATO
		betaOneDB.addContact(contato);
		$scope.cadastrarContatoOnline(contato);
		$scope.contatocadastro = {};
		$scope.mostrarmsg = false;

	};

	$scope.cadastrarContatoOnline = function(contato){

		contato.token = $scope.token;

		//CADASTRANDO DADOS NO SERVIDOR
		Data.setContact(contato).success(function(data){
			if(data.erro) {
				alert(data.erro);
			}
		}).error(function(data){
			alert("Não conseguimos cadastrar seu contato no servidor.\nO mesmo está cadastrado localmente de depois será sincronizado.");
		});

		$ionicLoading.hide();
		$scope.closeModal();
		$scope.renderHome();

	};

	//DELETANDO DADOS
	$scope.apagarContato = function(contato){

		// POPUP DE CONFIRMAÇÃO
		var confirmPopup = $ionicPopup.confirm({
			title: 'Apagando contato',
			template: 'Você tem certeza que deseja apagar?'
		});
		confirmPopup.then(function(res) {
			contato.token = $scope.token;
			if(res) {
				Data.delContact(contato).success(function(data){
					//alert(data?data:"Apagando contato do servidor.");
					betaOneDB.delContact(contato,function(){
						$scope.renderHome();
					});
				}).error(function(data){
					alert("Não foi possível deletar.\nVerifique sua conexão e tente novamente.");
				});
			} else {
				console.log('Desistiu');
			}
		});

	}

	//MODAL PARA ADICIONAR CONTATO
	$ionicModal.fromTemplateUrl('template/adicionarContato.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modal = modal;
	});
	$scope.openModal = function() {
		$scope.modal.show();
	};
	$scope.closeModal = function() {
		$scope.modal.hide();
	};


	//LOCATION DO CADASTRO
	$scope.data = {};
	//Optional
	$scope.countryCode = 'BR';
	//Optional
	$scope.onAddressSelection = function (location) {
		//Do something
		var a = location.address_components;
		//console.log(a);
	};

	$scope.getDateNow = function(){
		var now = new Date();
		var day = ("0" + now.getDate()).slice(-2);
		var month = ("0" + (now.getMonth() + 1)).slice(-2);
		var hours = ("0" + now.getHours()).slice(-2);
		var mins = ("0" + now.getMinutes()).slice(-2);
		var secs = ("0" + now.getSeconds()).slice(-2);

		return now.getFullYear() + "-" + (month) + "-" + (day) + " " + (hours) + ":" + (mins) + ":" + (secs);
	}




});











