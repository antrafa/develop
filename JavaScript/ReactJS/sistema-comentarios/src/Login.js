import React, { Component } from 'react'

class Login extends Component {
    state = {
        email: '',
        passwd: ''
    }
    handleChange = field => event => {
        this.setState({
            [field]: event.target.value
        })
    }
    login = () =>{
        this.props.login(this.state.email, this.state.passwd)
    }
    render() {
        const errorMessages = {
            'auth/wrong-password':'E-mail e/ou senha inválidos',
            'auth/user-not-found':'Usuário não encontrado',
            'auth/invalid-email':'E-mail e/ou senha inválidos'
        }
        return (
            <div>
                <h5>Entre para comentar</h5>
                <form className='mt-3'>
                    <div className='form-group'>
                        <input type='email' className='form-control' onChange={this.handleChange('email')} />
                    </div>
                    <div className='form-group'>
                        <input type='password' className='form-control' onChange={this.handleChange('passwd')} />
                    </div>
                    <button type='button' className='btn btn-sm btn-success mr-2' onClick={this.login}>Entrar</button>
                    <button type='button' className='btn btn-sm btn-primary' onClick={() => this.props.changeScreen('signup') }>Criar conta</button>
                </form>
                { 
                    this.props.isAuthError && 
                    <div class='alert alert-danger mt-3'>{errorMessages[this.props.authError]}</div> 
                }
            </div>
        )
    }
}
export default Login