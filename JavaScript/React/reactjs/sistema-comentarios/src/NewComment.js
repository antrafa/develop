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
                <h5>Comentar</h5>
                <form className='mt-3'>
                    <div className='form-group'>
                        <textarea className="form-control" rows='3' value={this.state.newComment} onChange={this.handleChange}></textarea>
                    </div>
                    <button type='button' className='btn btn-sm btn-success mr-2' onClick={this.sendComment}>Enviar comentário</button>
                </form>
            </div>
        )
    }
}

export default NewComment