import React, { Component } from 'react'
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom'

import Home from './Home'
import Sobre from './Sobre'
import Produtos from './Produtos'

class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      categorias: [],
      produtos: [],
      categoria: null
    }
  }
  loadCategorias = () => {
    this.props.api.loadCategorias()
    .then(res => {
      this.setState({
        categorias: res.data
      });
    });
  }
  loadCategoria = (categoria) => {
    this.props.api.loadCategoria(categoria)
      .then(res => {
        this.setState({
          categoria: res.data
        });
      });
  }
  removeCategoria = (categoria) => {
    this.props.api.deleteCategoria(categoria.id)
      .then(res => { this.loadCategorias() })
  }
  createCategoria = (categoria) => {
    this.props.api.createCategoria(categoria)
      .then(res => { this.loadCategorias() })
  }
  editCategoria = (categoria) => {
    this.props.api.editCategoria(categoria)
      .then(res => { this.loadCategorias() })
  }
  createProduto = (produto) => {
    return this.props.api.createProduto(produto)
  }
  loadProdutos = (categoria) => {
    this.props.api.loadProdutos(categoria)
      .then(res => {
        this.setState({
          produtos: res.data
        });
      });
  }
  removeProduto = (produto) => {
    return this.props.api.deleteProduto(produto.id)
  }
  readProduto = (id) => {
    return this.props.api.loadProduto(id)
  }
  editProduto = (produto) => {
    return this.props.api.editProduto(produto)
  }
  render() {
    return (
      <Router>
        <div>
          <nav className='navbar navbar-expand-lg navbar-dark bg-dark mb-4'>
            <section className='container'>
              <Link to='/' className='navbar-brand'>Gerenciador de produtos</Link>
              <div className='collapse navbar-collapse' id='navbarNav'>
                <ul className='navbar-nav'>
                  <li className='nav-item'><Link to='/' className='nav-link'>Home</Link></li>
                  <li className='nav-item'><Link to='/produtos' className='nav-link'>Produtos</Link></li>
                  <li className='nav-item'><Link to='/sobre' className='nav-link'>Sobre</Link></li>
                </ul>
              </div>
            </section>
          </nav>
          <section className='container'>
            <Route exact path='/' component={Home} />
            <Route exact path='/sobre' component={Sobre} />
            <Route path='/produtos' render={(props) => {
              return (
                <Produtos
                  {...props}

                  loadCategorias={this.loadCategorias}
                  removeCategoria={this.removeCategoria}
                  createCategoria={this.createCategoria}
                  editCategoria={this.editCategoria}
                  loadCategoria={this.loadCategoria}
                  categorias={this.state.categorias}
                  categoria={this.state.categoria}

                  createProduto={this.createProduto}
                  editProduto={this.editProduto}
                  loadProdutos={this.loadProdutos}
                  removeProduto={this.removeProduto}
                  produtos={this.state.produtos}
                  readProduto={this.readProduto}

                />
              )
            }
            } />
          </section>
        </div>
      </Router>
    );
  }
}

export default App;