import Table from './Table';
import Database from './Database';

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




