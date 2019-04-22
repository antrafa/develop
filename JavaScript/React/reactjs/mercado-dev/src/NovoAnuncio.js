import React, { Component } from 'react'
import HeaderInterno from './HeaderInterno'
import base, { storage } from './base'
import { Redirect } from 'react-router-dom'

class NovoAnuncio extends Component {
    constructor(props) {
        super(props)
        this.state = {
            success: false
        }
    }
    handleSubmit = (e) => {
        const file = this.foto.files[0]
        const { name } = file

        const ref = storage.ref(name)
        var uploadTask = ref.put(file)
        let novoAnuncio = {
            nome: this.nome.value,
            descricao: this.descricao.value,
            preco: this.preco.value,
            telefone: this.telefone.value,
            categoria: this.categoria.value,
            vendedor: this.vendedor.value
        }

        uploadTask.on('state_changed', snapshot => {
            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100
            console.log(progress)
        }, err => {
            console.log('Erro de upload')
        }, () => {

            uploadTask.snapshot.ref.getDownloadURL().then( downloadURL => {

                const novoAnuncioFoto = {
                    ...novoAnuncio,
                    foto: downloadURL
                }
                base.push('anuncios', {
                    data: novoAnuncioFoto
                }, (err) => {
                    if (err) {
    
                    } else {
                        this.setState({ success: true })
                    }
                })

            })
        })
        e.preventDefault()
    }
    render() {
        return (
            <div>
                {this.state.success && <Redirect to='/' />}
                <HeaderInterno />
                <div className='container' style={{ paddingTop: 120 }}>
                    <h2>Novo Anuncio Success: {this.state.success === false?'0':'1'}</h2>
                    <form onSubmit={this.handleSubmit}>
                        <div className='form-group'>
                            <label htmlFor='nome'>Nome</label>
                            <input type='text' ref={(ref) => this.nome = ref} className='form-control' id='nome' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='descricao'>Descrição</label>
                            <input type='text' ref={(ref) => this.descricao = ref} className='form-control' id='descricao' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='categoria'>Categoria</label>
                            <select ref={(ref) => this.categoria = ref} className='form-control' id='categoria'>
                                {
                                    this.props.categorias.map((cat, indice) => {
                                        return <option key={indice} value={cat.url}>{cat.categoria}</option>
                                    })
                                }
                            </select>
                        </div>
                        <div className='form-group'>
                            <label htmlFor='preco'>Preço</label>
                            <input type='text' ref={(ref) => this.preco = ref} className='form-control' id='preco' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='foto'>Foto</label>
                            <input type='file' ref={(ref) => this.foto = ref} className='form-control' id='foto' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='telefone'>Telefone</label>
                            <input type='text' ref={(ref) => this.telefone = ref} className='form-control' id='telefone' />
                        </div>
                        <div className='form-group'>
                            <label htmlFor='vendedor'>Vendedor</label>
                            <input type='text' ref={(ref) => this.vendedor = ref} className='form-control' id='vendedor' />
                        </div>
                        <div className='form-group'>
                            <button type='submit' className='btn btn-primary'>Salvar Anúncio</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}

export default NovoAnuncio