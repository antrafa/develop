app.config(function($stateProvider,$urlRouterProvider){

	//INICIAL, CASO NENHUMA TENHA SIDO PASSADA
	$urlRouterProvider.otherwise('/menu/home');

	$stateProvider
	.state("menu",{
		url: '/menu',
		templateUrl: 'template/menu.html',
		abstract: true,
		controller: 'ctrlInit'
	})
	.state("login",{//aparece dentro do menu
		url: "/login",
		templateUrl: "template/login.html",
		controller: 'ctrlLogin'
	})
	.state("menu.login.cadastro",{
		url: "/cadastro",
		templateUrl: "template/cadastro.html"
	})
	.state("menu.home",{//aparece dentro do menu
		url: "/home",
		views:{
			'menuContent':{
				templateUrl: "template/home.html",
				controller: 'ctrlHome'
			}
		}
	})
	.state("menu.perfil",{//aparece dentro do menu
		url: "/perfil",
		views:{
			'menuContent':{
				templateUrl: "template/perfil.html"
			}
		}
	})
	.state("menu.detalhes",{//aparece dentro do menu
		url: "/detalhes",
		views:{
			'menuContent':{
				templateUrl: "template/detalhes.html"
			}
		}
	})
	.state("menu.configuracoes",{//aparece dentro do menu
		url: "/configuracoes",
		views:{
			'menuContent':{
				templateUrl: "template/configuracoes.html"
			}
		}
	})
	.state("menu.editardados",{//aparece dentro do menu
		url: "/editardados",
		views:{
			'menuContent':{
				templateUrl: "template/editardados.html"
			}
		}
	})
	.state("menu.home.adicionarContato",{//aparece dentro do menu
		url: "/adicionarContato",
		templateUrl: "template/adicionarContato.html"
	});

});