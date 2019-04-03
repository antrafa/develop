"use strict";

app.controller('ctrlInit',function($scope,Data,$ionicPlatform,$ionicPopup,betaOneDB,$location,$ionicLoading,$ionicHistory){

	$scope.contatos = [];
	$scope.contatoDetalhes = [];
	$scope.usuario = {};
	$scope.mostrarmsg = false;
	$scope.token = 'a39229fb239a0d376d0c95a10de5b5d8';

	//DADOS PARA A PAGINA DE DETALHES DOS CONTATOS
	$scope.detalhesContato = function(contatos,id){
		$scope.contatoDetalhes = contatos.filter(function(element){
			return element.id == id;
		});
		$location.path("/menu/detalhes");
	}

	//FUNCAO CHAMADA PELO MODAL PARA CADASTRAR
	$scope.syncServer = function(){

		$ionicLoading.show({
			template: 'Sincronizando...',
		});

		betaOneDB.getUsers(function(usuario){

			if(usuario.rows.length > 0){//ACHOU USUÁRIO

				var idUsuario = usuario.rows[0].id_user;
				var params = {token: $scope.token,id_user: idUsuario};

				//CONECTAR COM O SERVIDOR E PEGAR OS CONTATOS
				Data.getContacts(params).success(function(data){

					var tempContatos = data;
					betaOneDB.getContacts(idUsuario,function(conts){

						if(tempContatos.length > 0){//VEIO CONTATOS DO SERVIDOR

							if(conts.rows.length == 0){//NÃO TEM CONTATOS LOCAIS
								alert("Identificamos que você possui contatos no servidor, mas não local.\nSinconizando dados.");
								
								//PEGA CONTATOS DO SERVIDOR E CADASTRA CONTATOS LOCALMENTE
								for(var c of tempContatos){
									betaOneDB.addContact(c);
								}

							}else{//TEM CONTATOS LOCAIS E ONLINE
								
								//PERCORRER O ONLINE PARA VER SE TEM LOCAL
								for(var contatoServidor of tempContatos){
									//FILTRAR LOCAL PELO EMAIL
									var achou = false;
									for(var contatoLocal of conts.rows){

										if(contatoLocal.email && contatoLocal.email == contatoServidor.email){//ACHOU O CONTATO. ATUALIZA?

											achou = true;

											var dateCompare = $scope.compareDate(contatoServidor.sync_date,contatoLocal.sync_date);

											if(dateCompare == 0){
												//verificar se tem alguma coisa diferente
												console.log("Datas iguais");
												$scope.compareContacts(contatoLocal,contatoServidor);


											}else if(dateCompare < 0){// SERVIDOR É MAIS ANTIGO
												console.log("Servidor desatualizado");
												$scope.compareContacts(contatoLocal,contatoServidor);

											}else{// LOCAL É MAIS ANTIGO
												console.log("Local desatualizado");
												$scope.compareContacts(contatoLocal,contatoServidor);

											}

											break;//já achou
										}

									}

									//NÃO ACHOU O CONTATO LOCALMENTE
									if(!achou) betaOneDB.addContact(c);
								}

							}

						}else{//NÃO TEM CONTATOS NO SERVIDOR

							if(conts.rows.length > 0){//TEM CONTATOS LOCAIS

								//PEGA OS CONTATOS LOCAIS E CADASTRA NO SERVIDOR
								params.contacts = conts.rows;
								Data.setContactLote(params).success(function(data){
									alert(data?data:"Você ainda não possuia contatos no servidor. Sincronizado.");
								}).error(function(data){
									alert("Não foi possível enviar contatos ao servidor.\nTente novamente mais tarde.");
								});
							}

						}

						$scope.$apply();
						$scope.redirectSync("/menu/home");

					});

					//COMPARAR DATAS DE SYNC
					//ATUALIZAR DIFERENTES
					//TRAZER FALTANTES (CASO NÃO EXISTA NO LOCAL MAS EXISTE NO SERVER)

					//SE DEU CERTO, APAGAR TABELA DE CONTATO
					//CRIAR TABELA DE CONTATO NOVAMENTE

					$scope.redirectSync("/menu/home");
				}).error(function(data){
					alert("Não foi possível conectar com o servidor.\nTente novamente mais tarde.");
					$scope.redirectSync("/menu/home");
				});


			}else{
				alert("Não foi possível identificar seu usuário.");
				$scope.redirectSync("/login");
			}

		});
   		
	};

	$scope.redirectSync = function(caminho){
		$ionicHistory.nextViewOptions({
			disableBack: true,
			historyRoot: true
		});
		$ionicLoading.hide();
		$location.path(caminho);
	}

	//FUNCTION DE LOGOUT
	$scope.logoutUser = function(){
		betaOneDB.delUser();
		$location.path("/login");
	}

	$scope.compareDate = function(data1,data2){
		var d1 = new Date(data1);
		var d2 = new Date(data2);
		if(isNaN(d1) || isNaN(d2)){//não tem data no servidor
			return (-1);
		}
		return (d1 - d2);
	}

	$scope.compareContacts = function(cLocal,cServer){//CLocal tem a primazia.
		var contatoTemp = {};
		for(var t in cLocal){

			contatoTemp[t] = cLocal[t];
			if(t == 'id_card' && cLocal[t] != cServer[t]){
				if(cLocal[t] == 'undefined') contatoTemp[t] = cServer[t];
				
			}
			console.log(cLocal[t] +"|||"+ cServer[t]);
			if(cLocal[t] != cServer[t]) console.log(t+" - Diferente");
			else console.log(t+" - igual");

			console.log("-------");
		}

		console.log(contatoTemp);

	}

});