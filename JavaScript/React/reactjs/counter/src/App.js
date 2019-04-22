import React, { Component } from 'react'
import logo from './logo.svg'
import './App.css'

class App extends Component {
  constructor(props){
    super(props)
    this.clear = this.clear.bind(this)
  }
  state = {
    counter: 0
  }
  increase = () => {
    this.setState({
      counter: this.state.counter+1
    })
  }
  decrease = () => {
    this.setState({
      counter: this.state.counter-1
    })
  }
  clear(){
    this.setState({
      counter: 0
    })
  }
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>Counter <span>{this.state.counter}</span></p>
          <ul>
            <li><button onClick={this.increase}>+</button></li>
            <li><button onClick={this.decrease}>-</button></li>
            <li><button onClick={this.clear}>Clear</button></li>
          </ul>
        </header>
      </div>
    )
  }
}

export default App