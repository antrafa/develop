import React, { Component } from 'react'
import Comments from './Comments'
import NewComment from './NewComment'

class App extends Component {
  state = {
    comments: [],
    isLoading: false
  }

  sendComment = comment => {
    const { database } = this.props
    const id = database.ref().child('comments').push().key
    const comments = {}
    comments['comments/' + id] = {
      comment
    }
    database.ref().update(comments)
  }

  componentDidMount() {
    const { database } = this.props
    this.setState({ isLoading: true })
    this.comments = database.ref('comments')
    this.comments.on('value', snapshot => {
      this.setState({
        comments: snapshot.val(),
        isLoading: false
      })
    })
  }

  render() {
    return (
      <div>
        <NewComment sendComment={this.sendComment} />
        {this.state.isLoading && <p>Carregando, aguarde....</p>}
        <Comments comments={this.state.comments} />
      </div>
    );
  }
}

export default App