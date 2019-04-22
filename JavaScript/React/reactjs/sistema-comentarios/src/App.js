import React, { Component } from 'react'
import Comments from './Comments'
import NewComment from './NewComment'
import SignUp from './SignUp';
import Login from './Login'
import User from './User'
import 'bootstrap-css-only'

class App extends Component {
	state = {
		comments: [],
		isLoading: false,
		isAuth: false,
		isAuthError: false,
		authError: '',
		signUpError: '',
		isSignUpError: false,
		user: {},
		userScreen: 'login' // signup
	}

	sendComment = comment => {
		const { database } = this.props
		const id = database.ref().child('comments').push().key
		const comments = {}
		comments['comments/' + id] = {
			comment, 
			email: this.state.user.email,
			id: this.state.user.uid
		}
		database.ref().update(comments)
	}

	login = async (email, passwd) => {
		const { auth } = this.props
		this.setState({
			authError: '',
			isAuthError: false
		})
		try {
			await auth.signInWithEmailAndPassword(email, passwd)
		} catch (err) {
			this.setState({
				authError: err.code,
				isAuthError: true
			})
		}
	}

	createAccount = async (email, passwd) => {
		const { auth } = this.props
		this.setState({
			signUpError: '',
			isSignUpError: false
		})
		try {
			await auth.createUserWithEmailAndPassword(email, passwd)
		} catch (err) {
			this.setState({
				signUpError: err.code,
				isSignUpError: true
			})
		}
	}

	logout = () => {
		const { auth } = this.props
		auth.signOut()
	}

	changeScreen = (screen) => {
		this.setState({
			userScreen: screen
		})
	}

	componentDidMount() {
		const { database, auth } = this.props
		this.setState({ isLoading: true })
		this.comments = database.ref('comments')
		this.comments.on('value', snapshot => {
			this.setState({
				comments: snapshot.val(),
				isLoading: false
			})
			console.log(this.state.comments)
		})

		auth.onAuthStateChanged(user => {
			if(user){
				this.setState({
					isAuth: true,
					user
				})
			}else{
				this.setState({
					isAuth: false,
					user: {}
				})
			}
		})
	}

	render() {
		return (
			<div className='container card mt-4 mb-4'>
  				<div className='card-body'>
					{ this.state.isAuth && <User email={this.state.user.email} logout={this.logout} />}
					{ 
						!this.state.isAuth && this.state.userScreen === 'login' && 
						<Login login={this.login} isAuthError={this.state.isAuthError} authError={this.state.authError} changeScreen={this.changeScreen} /> 
					}
					{ 
						!this.state.isAuth && this.state.userScreen === 'signup' && 
						<SignUp createAccount={this.createAccount} isSignUpError={this.state.isSignUpError} signUpError={this.state.signUpError} changeScreen={this.changeScreen} /> 
					}
					{ this.state.isAuth && <NewComment sendComment={this.sendComment} /> }
					<Comments comments={this.state.comments} />
					{ 
						this.state.isLoading && 
						<div className='card text-center mt-3'>
							<div className='card-body'>
								<div className="spinner-border spinner-border-sm text-primary">
									<span className="sr-only">Loading...</span>
								</div>
							</div>
						</div>
					}
				</div>
			</div>
		);
	}
}

export default App