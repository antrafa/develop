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
		try{
			let [action] = query.match(/[a-z]+/);
			return this[action](query);
		}catch(e){
			console.log("Comando inválido");
		}
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

		let regexp = /^select ([a-zA-Z ,]+) from ([a-zA-Z]+)/;
		let [undefined,columns,tableName] = query.match(regexp);
		columns = columns.split(", ");

		//if(!(tableName in this.tables)) throw `A tabela ${tableName} não existe`;
		if(!this.tables[tableName]) throw `Tabela ${tableName} não encontrada.`;
		for(let column of columns){
			if(!this.tables[tableName].columns[column]) throw `Coluna ${column}, da tabela ${tableName} não encontrada.`;
		}

		let result = [];

		for(let row of this.tables[tableName].data){

			let selectedRow = {};
			for(let column of columns){
				selectedRow[column] = row[column];
			}
			result.push(selectedRow);
		}

		return result;

	}

}

let database = new Database("library");

database.execute('create table author (id number, name string, age string, state string, country string)');
database.execute('create table books (id number, name string, authorId number, isbn number)');

database.execute('insert into author (id, name, age) values (1, Douglas Crockford, 62)');
database.execute('insert into author (id, name, age) values (2, Linus Torvalds, 47)');
database.execute('insert into author (id, name, age) values (3, Martin Fowler, 54)');

database.execute('insert into books (id, name, authorId, isbn) values (1, JavaScript Programming, 1, 8769)');
database.execute('insert into books (id, name, authorId, isbn) values (2, Design patterns, 2, 6565764)');
database.execute('insert into books (id, name, authorId, isbn) values (3, Receitas, 3, 869876)');

try{
	let dados = database.execute('select name, age from author');
	let dados2 = database.execute('select name, authorId, isbn from books');
	console.log("Tabela Author - "+JSON.stringify(dados,undefined,'\t'));
	console.log("Tabela Books - "+JSON.stringify(dados2,undefined,'\t'));
}catch(e){
	console.log(e);
}

//console.log("Tabela Author - "+JSON.stringify(dados,undefined,'\t'));
