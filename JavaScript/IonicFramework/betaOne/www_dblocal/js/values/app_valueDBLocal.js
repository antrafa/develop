(function(){
	"use stric";
	angular.module("betaone").value("DBLocal",{
		db:null,
		localdb: function(){
			this.db = window.openDatabase("dbbetaone","1.0","Banco Beta One",500);//2000 é 2 MB de tamanho
			this.db.transaction(function(res){
				res.executeSql("CREATE TABLE IF NOT EXISTS app_users(id_user INT, name TEXT,email TEXT,id_facebook TEXT, id_google TEXT, id_linkedin TEXT, saw_tutorial VC)",[]);
			});
		}
	});

})();