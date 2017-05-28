export default class Table{

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