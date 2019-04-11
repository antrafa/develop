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
      categorias: []
    }
  }
  loadCategorias = () => {
    console.log(this.props)
    this.props.api.loadCategorias()
      .then(res => {
        this.setState({
          categorias: res.data
        });
      });
  }
  removeCategoria = (categoria) => {
    this.props.api.deleteCategoria(categoria.id)
      .then(res => { this.loadCategorias() })
  }
  createCategoria = (categoria) => {
    this.props.api.createCategoria(categoria)
      .then( res => { this.loadCategorias() })
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
                  categorias={this.state.categorias} />
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