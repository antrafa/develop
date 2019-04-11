import React, { Component } from 'react'
import { Route, Link } from 'react-router-dom'

import ProdutosHome from './ProdutosHome'
import Categoria from './Categoria'

class Produtos extends Component {
    componentDidMount() {
        this.props.loadCategorias();
    }
    handleNewCategoria = (key) => {
        if(key.keyCode === 13){//ENTER
            this.props.createCategoria({
                categoria: this.refs.categoria.value
            })
            this.refs.categoria.value = ''
        }
    } 
    renderCategoria = (cat) => {
        return(
            <li className='nav-item' key={cat.id}>
                <span className='nav-link'>
                    <button className='btn btn-sm btn-secondary' onClick={() => this.props.removeCategoria(cat)}>x</button> &nbsp;
                    <Link to={`/produtos/categoria/${cat.id}`}>{cat.categoria}</Link>
                </span>
            </li>
        )
    }
    render() {
        const { match, categorias } = this.props
        return (
            <div className='row'>
                <div className='col-md-3'>
                    <h3>Categorias</h3>
                    <ul className='nav flex-column mb-3 mt-3'>
                        {categorias.map(this.renderCategoria)}
                    </ul>
                    <div className='card card-body bg-light'>
                        <input type='text' onKeyUp={this.handleNewCategoria} ref='categoria' placeholder='Nova categoria' className='form-control' />
                    </div>
                </div>
                <div className='col-md-9'>
                    <h1>Produtos</h1>
                    <Route exact path={match.url} component={ProdutosHome} />
                    <Route exact path={match.url + '/categoria/:catId'} component={Categoria} />
                </div>
            </div>
        )
    }
}
export default Produtos