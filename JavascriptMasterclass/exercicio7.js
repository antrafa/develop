class Table{

	constructor(name = 'new_table'){
		this.name = name;
		this.columns = {};
		this.data = [];
	}

	addColumn(name,type){
		if(!name || !type) throw "Nome e tipo da coluna são obrigatórios";
		this.columns[name] = type;
	}

	insertValues(columns,values){
		let row = {};
		for(let posicao in columns){
			row[columns[posicao]] = values[posicao];
		}
		this.data.push(row);
	}

}

class Database{

	constructor(name = 'New database'){
		this.name = name;
		this.tables = {};
	}

	execute(query){
		return new Promise((resolve,reject) => {

			let tempo = Math.floor(Math.random() * 1000);

			setTimeout(() => {
				try{
					let [action] = query.match(/[a-z]+/);
					resolve(this[action](query));
				}catch(e){
					reject("Comando inválido");
				}
			},tempo);

		});
		
	}

	create(query){
		let regexp = /^create table ([a-z]+) \(([a-zA-Z ,]+)\)/;
		let [undefined,tableName,columns] = query.match(regexp);
		columns = columns.split(", ");

		this.tables[tableName] = new Table(tableName);

		for(let column of columns){
			let [columnName,columnValue] = column.split(" ");
			this.tables[tableName].addColumn(columnName,columnValue);
		}
	}

	insert(query){
		let regexp = /^insert into ([a-zA-Z]+) \(([a-zA-Z ,]+)\) values \(([a-zA-Z0-9 ,]+)\)/;
		let [undefined,table,columns,values] = query.match(regexp);
		columns = columns.split(", ");
		values = values.split(", ");
		this.tables[table].insertValues(columns,values);
	}

	select(query){

		let regexp = /^select ([a-zA-Z ,]+) from ([a-zA-Z]+) where (.+)/;
		let [undefined,columns,tableName,where] = query.match(regexp);
		columns = columns.split(", ");
		let [columnWhere,valueWhere] = where.split(" = ");

		//if(!(tableName in this.tables)) throw `A tabela ${tableName} não existe`;
		if(!this.tables[tableName]) throw `Tabela ${tableName} não encontrada.`;
		for(let column of columns){
			if(!this.tables[tableName].columns[column]) throw `Coluna ${column}, da tabela ${tableName} não encontrada.`;
		}

		let result = [];

		//let whereResults = this.tables[tableName].data.filter(elem => elem[columnWhere] === valueWhere );

		for(let row of this.tables[tableName].data){
			if(row[columnWhere] != valueWhere) continue;
			let selectedRow = {};
			for(let column of columns){
				selectedRow[column] = row[column];
			}
			result.push(selectedRow);
		}

		return result;

	}

	delete(query){
		let regexp = /^delete from ([a-zA-Z]+) where (.+)/;
		let [undefined,tableName,where] = query.match(regexp);
		let [columnWhere,valueWhere] = where.split(" = ");

		this.tables[tableName].data = this.tables[tableName].data.filter(function (row){
			return row[columnWhere] != valueWhere;
		});
	}

}

//let database = new Database("library");
// database.execute('create table author (id number, name string, age string, state string, country string)').then(function(result){
// 	database.execute('insert into author (id, name, age) values (2, Martin Fowler, 54)').then(function(result){
// 		database.execute('select id, name, age from author where id = 2').then(function(result){
// 			console.log("Tabela Author - "+JSON.stringify(result,undefined,'\t'));
// 		}).catch(function(e){
// 			console.log(e);
// 		});
		
// 	}).catch(function(e){
// 		console.log(e);
// 	});

// }).catch(function(e){
// 	console.log(e);
// });


(async function(){
	var database = new Database("library");
	await database.execute('create table author (id number, name string, age string, state string, country string)');
	await database.execute('insert into author (id, name, age) values (2, Martin Fowler, 54)');
	let result = await database.execute('select id, name, age from author where id = 2');
	console.log("Tabela Author - "+JSON.stringify(result,undefined,'\t'));
})();




