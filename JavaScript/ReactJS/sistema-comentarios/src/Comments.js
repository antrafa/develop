import React, { Component } from 'react'
import Comment from './Comment'

class Comments extends Component {
    render(){
        return (
            <ul>
                {/* Comment */}
                {this.props.comments.map( c => {
                    return <Comment c={c} />
                })}
            </ul>
        )
    }
}

export default Comments