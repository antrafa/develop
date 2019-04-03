(function(){

	"use strict";

	angular.module("betaone",['ionic','ion-google-autocomplete']).controller('ctrlHome',function($scope,Data,$ionicModal,$location,DBLocal,$ionicPopup,$ionicLoading){

		DBLocal.localdb();

		$scope.usuarios = "Cartões";
		$scope.myswipe = true;
		$scope.usuario = {};
		$scope.cards = [];

		//usuario está logado??
		DBLocal.db.transaction(function(res){
			var q = "SELECT * FROM app_users";
			res.executeSql(q,null,function(i,data){
				if(data.rows.length == 0) window.location = "/#/menu/login";
				else $scope.renderHome(data.rows[0]);
			});
		},function(){//erro
			window.location = "/#/menu/login";
		});


		//só chama se estiver logado, passando o usuário
		$scope.renderHome = function(usuario){

			var getContacts = function(){

				var params = {
					counter: $scope.cards.length,
					token: "a39229fb239a0d376d0c95a10de5b5d8",
					id_user: usuario.id_user
				};

				Data.getContacts(params).success(function(data){
					if(data.length == 0){
						$scope.mostrarMsgNenhum = 'Nenhum contato encontrado.';
					}
					$scope.cards = data;
				}).error(function(data){
					console.log("Não foi possivel recuperar seus contatos.\nVerifique sua conexão.");
				});

			}

			$scope.atualizarListaView = function(){
				getContacts();
			}

			$ionicModal.fromTemplateUrl('template/adicionarCard.html', {
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

			getContacts();

			

			//DADOS PARA O PERFIL
			$scope.detalhesUsuario = function(id){
				$scope.usuarioPerfil = $scope.cards.filter(function(element){
					return element.id == id;
				});
				$location.path("/menu/detalhes");
			}

			//DELETANDO DADOS
			$scope.apagarDados = function(contato){

				// POPUP DE CONFIRMAÇÃO
				var confirmPopup = $ionicPopup.confirm({
					title: 'Apagando contato',
					template: 'Você tem certeza que deseja apagar?'
				});
				confirmPopup.then(function(res) {
					if(res) {
						Data.delContact(contato.id).success(function(data){
							getContacts();
						}).error(function(data){
							alert("Não foi possível deletar");
						});
					} else {
						console.log('Desistiu');
					}
				});

			}


			$scope.cadastrarContato = function(contato){

				$ionicLoading.show({
					template: 'Aguarde...',
				});

				contato.token = "a39229fb239a0d376d0c95a10de5b5d8";
				var loc = JSON.stringify(contato.location.address_components);
				contato.location = loc;
				contato.id_user = usuario.id_user;

				//CADASTRANDO DADOS NO SERVIDOR
				Data.setContact(contato).success(function(data){
					if(data.erro) alert(data.erro);
					else if(data.name && data.email){
						//INSERINDO DADOS LOCALMENTE
						//$scope.cadastrarUsuarioLocal(data);
						$ionicLoading.hide();
						$scope.modal.hide();
					}
				}).error(function(data){
					alert("Erro ao cadastrar");
					$ionicLoading.hide();
					$scope.modal.hide();
				});

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

		};

	});

})();