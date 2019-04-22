import React, { Component } from 'react'
import PropTypes from 'prop-types'

class Ola extends Component {
    render(){
        return(
            <span>Ola {this.props.nome}</span>
        )
    }
}

Ola.propTypes = {
    nome: PropTypes.string.isRequired
}

Ola.defaultProps = {
    nome: 'Rafael'
}

export default Ola