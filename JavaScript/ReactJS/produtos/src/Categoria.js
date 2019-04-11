import React, { Component } from 'react'
import Axios from 'axios';

class Categoria extends Component {
    constructor(props){
        super(props)
        this.state = {
            produtos: [],
            categoria: {}
        }
        this.loadData = this.loadData.bind(this)
    }
    loadData(catId) {
        Axios
            .get('http://localhost:3001/produtos?categoria=' + catId)
            .then(res => {
                this.setState({
                    produtos: res.data
                });
            });
        Axios
            .get('http://localhost:3001/categorias/' + catId)
            .then(res => {
                this.setState({
                    categoria: res.data
                });
            });
    }
    componentDidMount(){
        this.loadData(this.props.match.params.catId)
    }
    componentWillReceiveProps(newProps){
        this.loadData(newProps.match.params.catId)
    }
    renderProduto(produto){
        return(
            <div className='card card-body bg-light mt-2' key={produto.id}>
                    {produto.produto}
            </div>
        )
    }
    render() {
        return (
            <div>
                <h4>{this.state.categoria.categoria}</h4>
                {this.state.produtos.map(this.renderProduto)}
            </div>
        )
    }
}
export default Categoria