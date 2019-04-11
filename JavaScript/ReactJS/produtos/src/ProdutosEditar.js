import React, { Component } from 'react'
import { Redirect } from 'react-router-dom'

class ProdutosEditar extends Component {
    constructor(props){
        super(props)
        this.state = {
            redirect: false
        }
    }
    componentDidMount() {
        this.props.readProduto(this.props.match.params.id)
            .then(res => {
                console.log(res.data)
                this.refs.produto.value = res.data.produto
                this.refs.categoria.value = res.data.categoria
            })
    }
    handleEditProduto = () => {
        const produto = {
            id: this.props.match.params.id,
            produto: this.refs.produto.value,
            categoria: this.refs.categoria.value
        }
        this.props.editProduto(produto)
            .then( res => this.setState({ redirect: '/produtos/categoria/' + produto.categoria }))
    }
    render() {
        const { categorias } = this.props
        if(this.state.redirect){
            return <Redirect to={this.state.redirect} />
        }
        return (
            <div>
                <h3>Editar produto</h3>
                <select ref='categoria' className='form-control mb-2'>
                    {categorias.map(
                        (c) => <option key={c.id} value={c.id}>{c.categoria}</option>
                    )}
                </select>
                <input className='form-control mb-2' ref='produto' placeholder='Nome do novo produto'></input>
                <button className='btn btn-success' onClick={this.handleEditProduto}>Salvar</button>
            </div>
        )
    }
}

export default ProdutosEditar