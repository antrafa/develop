let query = 'create table author (id number, name string, city string, state string, country string)';

let regexp = /^create table ([a-z]+) \(([a-z ,]+)\)/;
let result = query.match(regexp);

let tableName = result[1];
let columns = result[2].split(", ");

let database = {//Crie um objeto chamado "database"
	tables: {//Dentro do objeto "database", crie um objeto chamado "tables"
		[tableName]:{}//Dentro do objeto "tables", crie um objeto com o nome da tabela
	}
};

//Altere as configurações da propriedade "tables" para {writable: false, configurable: false, enumerable: true}
Object.defineProperty(database,"tables",{
	writable: false, configurable: false, enumerable: true
});

database.tables[tableName] = {
	columns:{},//Dentro do objeto criado com o nome da tabela, crie um objeto chamado "columns"
	data:[]//Dentro do objeto criado com nome da tabela, crie um array chamado "data"
};

//No objeto columns, as chaves são representadas pelo nome da coluna e o valor pelo tipo
for(let column of columns){
	let [columnName,columnValue] = column.split(" ");//usando descructuring
	database.tables[tableName].columns[columnName] = columnValue;
}

//Resultado
console.log(JSON.stringify(database,undefined,'\t'));



//console.log(database);

// console.log(tableName);
// console.log(columns);

