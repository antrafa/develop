/*
let email = "antonioiae@gmail.com";
let regexp = /^[a-z\d\.]+@[a-z\d]+(\.[a-z]{2,3})+$/;
let result = regexp.exec(email);

console.log(result[0]);
console.log(result.input);
console.log(result.index);

*/

// let email = 'antonioiae@gmail.com';
// let regexp = /([a-z\d\.]+)@([a-z\d\.]+)/;// o () cria grupo de captura
// let result = email.match(regexp);

// console.log(result);

var frutas = ['morango','banana','laranja','abacaxi','manga'];

var saladaDeFrutas = {};

//PROBLEMA
for(var i = 0; i < (frutas.length - 1); i++){
	saladaDeFrutas[frutas[i]] = function(){
		console.log("Meu nome é "+frutas[i]);
	};
}

//RESOLVENDO COM CLOSURE
// for(var i = 0; i < (frutas.length - 1); i++){
// 	saladaDeFrutas[frutas[i]] = (function(fruta){
// 		return function(){
// 			console.log("Meu nome é "+fruta);
// 		}
// 	})(frutas[i]);
// }

console.log(i);

saladaDeFrutas.morango();
saladaDeFrutas.banana();
saladaDeFrutas.laranja();
saladaDeFrutas.abacaxi();

