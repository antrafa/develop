import React, { Component } from 'react'

class Comment extends Component {
    render(){
        return(
            <li>{this.props.c}</li>
        )
    }
}

export default Comment