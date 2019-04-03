app.factory('betaOneService', function ($q) {  

	var _db;

	// We'll need this later.
	var _dados;
	
	return {
		initDB: initDB,

		// We'll add these later.
		getAllDados: getAllDados,
		addDado: addDado,
		updateDado: updateDado,
		deleteDado: deleteDado
	};

	function initDB() {
		// Creates the database or opens if it already exists
		_db = new PouchDB('betaonedb');
	};

	function destroyDb(){
		_db.destroy().then(function() { console.log('ALL YOUR BASE ARE BELONG TO US') });  
	};

	function addDado(dados) { 
		//In PouchDB the object is simply serialized into JSON and stored in the database.
		//There are 2 ways to insert data, the post method and the put method. 
		//The difference is that if you add something with the post method, PouchDB will generate an _id for you, whereas if you use the  put method you're generating the _id yourself.
		return $q.when(_db.post(dados));
	};

	function updateDado(dados) {  
		return $q.when(_db.put(dados));
	};

	function deleteDado(dados) {  
		return $q.when(_db.remove(dados));
	};

	function getAllDados(type) {

		if (!_dados) {

		   return $q.when(_db.allDocs({ include_docs: true}))			
				.then(function(docs) {
					// Each row has a .doc object and we just want to send an 
					// array of birthday objects back to the calling controller,
					// so let's map the array to contain just the .doc objects.
					_dados = docs.rows.map(function(row) {
						// Dates are not automatically converted from a string.
						//row.doc.Date = new Date(row.doc.Date);
						return row.doc;
					});

					// Listen for changes on the database.
					_db.changes({ live: true, since: 'now', include_docs: true})
					   .on('change', onDatabaseChange);

					return _dados;
				});
		} else {
			// Return cached data as a promise
			return $q.when(_dados);
		}
	};

	function onDatabaseChange(change) {  
		var index = findIndex(_dados, change.id);
		var dados = _dados[index];

		if (change.deleted) {
			if (dados) {
				console.log("delete");
				_dados.splice(index, 1); // delete
			}
		} else {
			if (dados && dados._id === change.id) {
				console.log("update");
				_dados[index] = change.doc; // update
			} else {
				console.log("insert");
				_dados.splice(index, 0, change.doc) // insert
			}
		}
	}

	// Binary search, the array is by default sorted by _id.
	function findIndex(array, id) {  
		var low = 0, high = array.length, mid;
		while (low < high) {
			mid = (low + high) >>> 1;
			array[mid]._id < id ? low = mid + 1 : high = mid
		}
		return low;
	}

	return true;

});