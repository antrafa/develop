app.controller("ctrlSair",function($scope,Data,DBLocal,$location){

	$scope.deslogarUsuario = function(){
		DBLocal.db.transaction(function(res){
		 	res.executeSql("DELETE FROM app_users;");
		});
		//$location.url("/menu/home");
		window.location = "/#/menu/login";
	}

	$scope.deslogarUsuario();

});

