app.factory('betaOneDB', function ($q) {  

	var _db = null;

	return {
		initDB: initDB,
		
		//USUÁRIOS
		getUsers: getUsers,
		addUser: addUser,
		delUser: delUser,

		//CONTATOS
		getContacts: getContacts,
		addContact: addContact,
		delContact: delContact,
		dropContact: dropContact
	};

	function initDB() {
		_db = window.openDatabase("betaone.db", "1.0", "BetaOne DB", -1);
		createTable();
	};

	function createTable() {
		_db.transaction(function(res){
			res.executeSql("CREATE TABLE IF NOT EXISTS app_users(id_user INT, name TEXT,email TEXT,id_facebook TEXT, id_google TEXT, id_linkedin TEXT, saw_tutorial VC)",[]);
			res.executeSql("CREATE TABLE IF NOT EXISTS contacts(id INTEGER PRIMARY KEY, id_contact INT, id_user INT, name TEXT, email TEXT, location TEXT, id_card INT, created_date TIMESTAMP, update_date TIMESTAMP, sync_date TIMESTAMP)",[]);
		});
	};

	function getUsers(callback) {

		return $q.when(_db.transaction(function(res) {
			var q = "SELECT * FROM app_users";
			res.executeSql(q, null, function(i, data) {
				callback(data);
			});
		}));
		
	}

	function addUser(user){
		_db.transaction(function(res) {
		 	res.executeSql("INSERT INTO app_users(id_user,name,email,id_facebook,id_google,id_linkedin,saw_tutorial) VALUES(?,?,?,?,?,?,?);", [user.id_user,user.name,user.email,user.id_facebook,user.id_google,user.id_linkedin,user.saw_tutorial]);
		});
	}

	function delUser(){
		_db.transaction(function(res) {
		 	res.executeSql("DELETE FROM app_users;");
		});
	}

	function getContacts(id_user,callback) {
		_db.transaction(function(res) {
			var q = "SELECT * FROM contacts WHERE id_user = "+id_user;
			res.executeSql(q, null, function(i, data) {
				callback(data);
			});
		});
		
	}

	function addContact(contato){
		_db.transaction(function(res) {
		 	res.executeSql("INSERT INTO contacts(id_contact,id_user,name,email,location,id_card,created_date,update_date,sync_date) VALUES(?,?,?,?,?,?,?,?,?);", [contato.id_contact,contato.id_user,contato.name,contato.email,contato.location,contato.id_card,contato.created_date,contato.update_date,contato.sync_date]);
		});
	}

	function delContact(contato,callback){
		console.log("Deletando local");
		_db.transaction(function(res) {
		 	var q = "DELETE FROM contacts WHERE id = "+contato.id;
			res.executeSql(q, null, function(i, data) {
				callback();
			});
		});
	}

	function dropContact(callback){
		_db.transaction(function(res) {
			var q = "DROP TABLE contacts";
			res.executeSql(q, null, function(i, data) {
				callback();
			});
		});
	}

	return true;

});