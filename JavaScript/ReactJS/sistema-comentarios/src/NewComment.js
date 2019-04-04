import React, { Component} from 'react'

class NewComment extends Component {
    state = {
        newComment:''
    }
    handleChange = event => {
      this.setState({
        newComment: event.target.value
      })
    }
    sendComment = () => {
        this.props.sendComment(this.state.newComment);
        this.setState({newComment:''})
    }
    render(){
        return (
            <div>
                <p><textarea value={this.state.newComment} onChange={this.handleChange}></textarea></p>
                <p><button onClick={this.sendComment}>Enviar</button></p>
            </div>
        )
    }
}

export default NewComment