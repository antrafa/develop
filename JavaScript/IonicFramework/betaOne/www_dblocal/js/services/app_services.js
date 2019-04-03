(function(){

	"use stric";

	angular.module("betaone").value('Config',{
		getUrl:'API_URL'
	});

	angular.module("betaone").service("Data",function($http,Config){
		
		//RECUPERANDO CARTÃO		
		this.getContacts = function(params){
			return $http({
				method: 'POST',
				url: Config.getUrl + "recuperacontatos.php",
				data: params,
				headers: {
					'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				}

			});
		}

		this.getLogin = function(params){
			return $http({
				method: 'POST',
				url: Config.getUrl + "login.php",
				data: params,
				headers: {
					'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				}

			});
		}

		//CADASTRANDO USUÁRIO
		this.setUser = function(user){
			return $http({
				method: 'POST',
				url: Config.getUrl + "cadastrousuario.php",
				data: user,
				headers: {
					'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				}

			});
		}

		//CADASTRANDO CONTATO
		this.setContact = function(contact){
			return $http({
				method: 'POST',
				url: Config.getUrl + "cadastrocontato.php",
				data: contact,
				headers: {
					'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				}

			});
		}

		//DELETANDO CARTÃO
		this.delContact = function(id){
			return $http({
				method: 'POST',
				url: Config.getUrl + "deletacontato.php",
				data: id,
				headers: {
					'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
				}

			});
		}
	})

})();