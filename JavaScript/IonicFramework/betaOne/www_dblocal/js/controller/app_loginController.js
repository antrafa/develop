(function(){

	"use strict";

	angular.module("betaone").controller("ctrlLogin",function($scope,Data,$ionicModal,DBLocal,$ionicPopup,$location,$ionicHistory,$ionicLoading){

		DBLocal.localdb();

		$scope.loginPg = "Login";

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

		$scope.loginUsuario = function(login){

			login.token = "a39229fb239a0d376d0c95a10de5b5d8";
			$ionicLoading.show({
				template: 'Aguarde...',
			});
			Data.getLogin(login).success(function(data){
				if(data.length == 0){//Usuário não encontrado
					$scope.showAlert();
				}else{
					var usuario = {};
					usuario.id_user = data.id_user;
					usuario.name = data.user_name;
					usuario.email = data.user_email;
					usuario.id_facebook = data.id_facebook;
					usuario.id_google = data.id_google;
					usuario.id_linkedin = data.id_linkedin;
					usuario.saw_tutorial = data.user_saw_tutorial;
					$scope.cadastrarUsuarioLocal(usuario);
				}
			}).error(function(data){
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

		$scope.cadastrarUsuario = function(cadastro){

			cadastro.token = "a39229fb239a0d376d0c95a10de5b5d8";

			//CADASTRANDO DADOS NO SERVIDOR
			Data.setUser(cadastro).success(function(data){
				if(data.erro) alert(data.erro);
				else if(data.name && data.email){
					//INSERINDO DADOS LOCALMENTE
					$scope.cadastrarUsuarioLocal(data);
					$scope.modal.hide();
				}
			}).error(function(data){
				alert("Erro ao cadastrar");
				$scope.modal.hide();
			});

		};

		$scope.cadastrarUsuarioLocal = function(cadastro){
			DBLocal.db.transaction(function(res){
			 	res.executeSql("DELETE FROM app_users;");
			 	res.executeSql("INSERT INTO app_users(id_user,name,email,id_facebook,id_google,id_linkedin,saw_tutorial) VALUES(?,?,?,?,?,?,?);",[cadastro.id_user,cadastro.name,cadastro.email,cadastro.id_facebook,cadastro.id_google,cadastro.id_linkedin,cadastro.saw_tutorial]);
			});
			//$location.url("/menu/home");

			$ionicHistory.nextViewOptions({
				disableBack: true,
				historyRoot: true
			});
			$ionicLoading.hide();
			window.location = "/#/menu/home";
		}

	});


})();