
let database = {
	tables: {},
	create(query){
		let regexp = /^create table ([a-z]+) \(([a-z ,]+)\)/;
		let [undefined,tableName,columns] = query.match(regexp);
		columns = columns.split(", ");

		this.tables[tableName] = {
			columns:{},
			data:[]
		};

		for(let column of columns){
			let [columnName,columnValue] = column.split(" ");
			this.tables[tableName].columns[columnName] = columnValue;
		}
	},
	insert(query){
		let regexp = /^insert into ([a-z]+) \(([a-z ,]+)\) values \(([a-zA-Z0-9 ,]+)\)/;
		let [undefined,table,columns,values] = query.match(regexp);
		columns = columns.split(", ");
		values = values.split(", ");
		let row = {};

		for(let posicao in columns){
			row[columns[posicao]] = values[posicao];
		}

		this.tables[table].data.push(row);
	},
	execute(query){
		
		let [action] = query.match(/[a-z]+/);
		return this[action](query);

		//if(query.startsWith('create')) this.create(query);
		//else this.insert(query);
	}

};

database.execute('create table author (id number, name string, city string, state string, country string)');
database.execute('insert into author (id, name, age) values (1, Douglas Crockford, 62)');
database.execute('insert into author (id, name, age) values (2, Linus Torvalds, 47)');
database.execute('insert into author (id, name, age) values (3, Martin Fowler, 54)');
console.log(JSON.stringify(database,undefined,'\t'));

