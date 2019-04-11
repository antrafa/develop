import React, { Component } from 'react'
import { Route, Link } from 'react-router-dom'

import ProdutosHome from './ProdutosHome'
import Categoria from './Categoria'
import ProdutosNovo from './ProdutosNovo'
import ProdutosEditar from './ProdutosEditar'

class Produtos extends Component {
    constructor(props) {
        super(props)
        this.state = {
            editingCategoria: ''
        }
    }
    componentDidMount() {
        this.props.loadCategorias();
    }
    handleNewCategoria = (key) => {
        if (key.keyCode === 13) {//ENTER
            this.props.createCategoria({
                categoria: this.refs.categoria.value
            })
            this.refs.categoria.value = ''
        }
    }
    handleEditCategoria = (key) => {
        if (key.keyCode === 13) {//ENTER
            this.props.editCategoria({
                id: this.state.editingCategoria,
                categoria: this.refs['cat-' + this.state.editingCategoria].value
            })
            this.setState({ editingCategoria: '' })
        }
    }
    editarCategoria = (categoria) => {
        this.setState({ editingCategoria: categoria.id })
    }
    cancelEditing = () => {
        this.setState({ editingCategoria: '' })
    }

    renderCategoria = (cat) => {
        return (
            <li className='nav-item' key={cat.id}>
                {
                    this.state.editingCategoria === cat.id &&
                    <div className='input-group mb-3'>
                        <input type='text' ref={'cat-' + cat.id} className='form-control' onKeyUp={this.handleEditCategoria} defaultValue={cat.categoria} />
                        <div className='input-group-append'>
                            <button className='btn btn-outline-secondary' onClick={this.cancelEditing} type="button">x</button>
                        </div>
                    </div>
                }
                {
                    this.state.editingCategoria !== cat.id &&

                    <div className='btn-group mb-1'>
                        <Link to={`/produtos/categoria/${cat.id}`} className='btn btn-sm btn-secondary'>{cat.categoria}</Link>
                        <button type='button' className='btn btn-sm btn-secondary dropdown-toggle dropdown-toggle-split' data-toggle='dropdown'>
                            <span className='sr-only'>Toggle Dropdown</span>
                        </button>
                        <div className='dropdown-menu'>
                            <button className='dropdown-item' onClick={() => this.editarCategoria(cat)}>Editar</button>
                            <button className='dropdown-item' onClick={() => this.props.removeCategoria(cat)}>Excluir</button>
                        </div>

                    </div>
                }
            </li>
        )
    }
    render() {
        const { match, categorias } = this.props
        return (
            <div className='row'>
                <div className='col-md-3'>
                    <h4>Categorias</h4>
                    <ul className='nav flex-column mb-3 mt-3'>
                        {categorias.map(this.renderCategoria)}
                    </ul>
                    <div className='card card-body bg-light'>
                        <input type='text' onKeyUp={this.handleNewCategoria} ref='categoria' placeholder='Nova categoria' className='form-control' />
                    </div>
                    <Link to='/produtos/novo' className='btn btn-primary mt-3'>Novo produto</Link>
                </div>
                <div className='col-md-9'>
                    <Route exact path={match.url} component={ProdutosHome} />
                    <Route path={match.url + '/editar/:id'} render={(props) => {
                        return (
                            <ProdutosEditar
                                {...props}
                                categorias={categorias}
                                readProduto={this.props.readProduto}
                                editProduto={this.props.editProduto}
                            />
                        )
                    }} />
                    <Route exact path={match.url + '/novo'} render={(props) => {
                        return (
                            <ProdutosNovo
                                {...props}
                                categorias={categorias}
                                createProduto={this.props.createProduto} />
                        )
                    }} />
                    <Route exact path={match.url + '/categoria/:catId'} render={(props) => {
                        return (
                            <Categoria
                                {...props}
                                loadProdutos={this.props.loadProdutos}
                                removeProduto={this.props.removeProduto}
                                produtos={this.props.produtos}

                                loadCategoria={this.props.loadCategoria}
                                categoria={this.props.categoria}
                            />
                        )
                    }} />
                </div>
            </div>
        )
    }
}
export default Produtos