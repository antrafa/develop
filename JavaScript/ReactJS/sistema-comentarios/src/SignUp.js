import React, { Component } from 'react'

class SignUp extends Component {
    state = {
        email: '',
        passwd: ''
    }
    handleChange = field => event => {
        this.setState({
            [field]: event.target.value
        })
    }
    createAccount = () =>{
        this.props.createAccount(this.state.email, this.state.passwd)
    }
    render() {
        const errorMessages = {
            'auth/email-already-in-use':'E-mail já foi utilizado',
            'auth/weak-password':'Senha muito fraca',
            'auth/invalid-email':'E-mail e/ou senha inválidos'
        }
        return (
            <div>
                <h5>Criar conta</h5>
                <form className='mt-3'>
                    <div className='form-group'>
                        <input type='email' className='form-control' onChange={this.handleChange('email')} />
                    </div>
                    <div className='form-group'>
                        <input type='password' className='form-control' onChange={this.handleChange('passwd')} />
                    </div>
                    <button type='button' className='btn btn-sm btn-success mr-2' onClick={this.createAccount}>Criar conta</button>
                    <button type='button' className='btn btn-sm btn-primary' onClick={() => this.props.changeScreen('login') }>Efetuar Login</button>
                </form>
                { 
                    this.props.isSignUpError && 
                    <div class='alert alert-danger mt-3'>{errorMessages[this.props.signUpError]}</div> 
                }
            </div>
        )
    }
}
export default SignUp