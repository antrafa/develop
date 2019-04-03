app.controller("ctrlLogin",function($scope,Data,$ionicModal,$ionicPopup,$location,$ionicHistory,$ionicLoading,betaOneDB){

	$scope.titulo = "Login";
	$scope.token = 'a39229fb239a0d376d0c95a10de5b5d8';

	//MODAL CADASTRO
	$ionicModal.fromTemplateUrl('template/cadastro.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modal = modal;
	});
	$scope.openModalCadastro = function() {
		$scope.modal.show();
	};
	$scope.closeModalCadastro = function() {
		$scope.modal.hide();
	};

	//LOGAR USUÁRIO
	$scope.loginUsuario = function(login){
		login.token = $scope.token;
		$ionicLoading.show({
			template: 'Aguarde...',
		});
		Data.getLogin(login).success(function(data){
			if(data.length == 0){//Usuário não encontrado
				$ionicLoading.hide();
				$scope.showAlert();
			}else{
				var usuario = {
					id_user: data.id_user,
					name: data.user_name,
					email: data.user_email,
					id_facebook: data.id_facebook,
					id_google: data.id_google,
					id_linkedin: data.id_linkedin,
					saw_tutorial: data.user_saw_tutorial
				};
				$scope.cadastrarUsuarioLocal(usuario);
			}
		}).error(function(data){
			$ionicLoading.hide();
			$scope.showAlert();
			console.log("Error");
		});

		// An alert dialog
		$scope.showAlert = function() {
			var alertPopup = $ionicPopup.alert({
				title: 'Erro ao efetuar login!',
				template: 'Dados não encontrados.\nTente novamente.'
			});

			alertPopup.then(function(res) {
				console.log('');
			});
		};

	};

	//CADASTRAR USUÁRIO
	$scope.cadastrarUsuario = function(cadastro){
		cadastro.token = $scope.token;
		//CADASTRANDO DADOS NO SERVIDOR
		Data.setUser(cadastro).success(function(data){
			if(data.erro) alert(data.erro);
			else if(data.name && data.email){
				$scope.cadastrarUsuarioLocal(data);
				$scope.modal.hide();
			}
		}).error(function(data){
			alert("Erro ao cadastrar\nVerifique sua conexão e tente novamente.");
			$scope.modal.hide();
		});

	};

	//CADASTRANDO USUÁRIO LOCALMENTE, SÓ DEPOIS DE CADASTRAR ONLINE
	$scope.cadastrarUsuarioLocal = function(cadastro){
		betaOneDB.delUser();
		betaOneDB.addUser(cadastro);
		$ionicHistory.nextViewOptions({
			disableBack: true,
			historyRoot: true
		});
		$ionicLoading.hide();
		$location.path("/menu/home");
		//window.location = "#/menu/home";
	}

});

