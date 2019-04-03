"use strict";

app.controller('ctrlInit',function($scope,$ionicPlatform,$ionicPopup,betaOneService,$location){

	$scope.contatos = [];
	$scope.contatoDetalhes = [];

	// INITIALIZE THE DATABASE.
    $ionicPlatform.ready(function() {
        betaOneService.initDB();
    });


	//FUNCAO CHAMADA PELO MODAL PARA CADASTRAR
	$scope.cadastrarContato = function(contato){

		$ionicLoading.show({
			template: 'Aguarde...',
		});

		contato.type = 'contato';
		
		betaOneService.addDado(contato);
		
		$ionicLoading.hide();
		$scope.closeModal();

	};

	//DELETANDO DADOS
	$scope.apagarContato = function(contato){

		// POPUP DE CONFIRMAÇÃO
		var confirmPopup = $ionicPopup.confirm({
			title: 'Apagando contato',
			template: 'Você tem certeza que deseja apagar?'
		});
		confirmPopup.then(function(res) {
			if(res) {
				 betaOneService.deleteDado(contato);
			} else {
				console.log('Desistiu');
			}
		});

	}

	//DADOS PARA O PERFIL
	$scope.detalhesUsuario = function(contatos,id){
		$scope.contatoDetalhes = contatos.filter(function(element){
			return element._id == id;
		});
		$location.path("/menu/detalhes");
	}

});