import React, { Component } from 'react'
import { Link } from 'react-router-dom'

class Categoria extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: null
        }
    }
    loadData = (catId) => {
        this.setState({ id: catId })
        this.props.loadProdutos(catId)
        this.props.loadCategoria(catId)
    }
    componentDidMount() {
        this.loadData(this.props.match.params.catId)
    }
    componentWillReceiveProps(newProps) {
        if (newProps.match.params.catId !== this.state.id) {
            this.loadData(newProps.match.params.catId)
        }
    }
    renderProduto = (produto) => {
        return (
            <div className='card card-body bg-light mt-2' key={produto.id}>
                <h5 class="card-title">{produto.produto}</h5>
                <div className='card-text row'>
                    <button className='btn btn-secondary col-md-6' onClick={
                        () => {
                                this.props.removeProduto(produto)
                                    .then( res => this.loadData(this.props.match.params.catId))
                            }
                        }>Excluir</button>
                    <Link to={'/produtos/editar/'+produto.id} className='btn btn-info col-md-6'>Editar</Link>
                </div>
            </div>
        )
    }
    render() {
        return (
            <div>
                <h4>{
                    this.props.categoria &&
                    this.props.categoria.categoria &&
                    this.props.categoria.categoria
                }</h4>
                {   
                    this.props.produtos.length === 0 && 
                    <div className='alert alert-info'>Nenhum produto</div>
                }
                {this.props.produtos.map(this.renderProduto)}
            </div>
        )
    }
}
export default Categoria