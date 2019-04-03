import React, { Component } from 'react'
import api from './Api';
import { Redirect } from 'react-router-dom'

const statuses = {
    'watched': 'Assistido',
    'watching': 'Assistindo',
    'toWatch': 'Assistir'
}

class EditSeries extends Component {

    constructor(props){
        super(props)
        this.state = {
            genres:[],
            isLoading: false,
            redirect: false,
            serie: {}
        }
        this.updateSerie = this.updateSerie.bind(this)
    }
    componentDidMount(){
        this.setState({ isLoading: true })
        api.loadSeriesById(this.props.match.params.id)
            .then( (res) => {
                this.setState({ serie: res.data })
                this.refs.name.value = this.state.serie.name
                this.refs.status.value = this.state.serie.status
                this.refs.genre.value = this.state.serie.genre
                this.refs.comments.value = this.state.serie.comments
                this.refs.image.value = this.state.serie.image
            })
        api.loadGenres()
            .then((res) => {
                this.setState({
                    isLoading: false,
                    genres: res.data
                })
            })
    }
    updateSerie(){
        const serie = {
            id: this.props.match.params.id,
            name: this.refs.name.value,
            status: this.refs.status.value,
            genre: this.refs.genre.value,
            comments: this.refs.comments.value,
            image: this.refs.image.value
        }
        api.updateSerie(serie)
            .then( (res) => {
                this.setState({
                    redirect: '/series/'+serie.genre
                })
            })
    }
    render(){
        return (
            <section className="intro-section">
                { 
                    this.state.redirect && 
                    <Redirect to={this.state.redirect} />
                }
                <h1>Editar Série</h1>
                <div className="col-md-6 col-md-offset-3">
                    <form>
                    <div className="form-group text-left">
                            <label htmlFor="name">Nome</label>
                            <input type="text" ref="name" id="name" className="form-control" />
                        </div>
                        <div className="form-group text-left">
                            <label htmlFor="image">Imagem</label>
                            <input type="text" ref="image" id="image" className="form-control" />
                        </div>
                        <div className="form-group text-left">
                            <label htmlFor="status">Status</label>
                            <select ref="status" id="status" className="form-control">
                                { 
                                    Object
                                    .keys(statuses)
                                    .map( key => <option key={key} value={key}>{statuses[key]}</option> ) 
                                }
                            </select>
                        </div>
                        <div className="form-group text-left">
                            <label htmlFor="genre">Gênero</label>
                            <select ref="genre" id="genre" className="form-control">
                                { 
                                    (this.state.genres)
                                    .map( key => <option key={key} value={key}>{key}</option> ) 
                                }
                            </select>
                        </div>
                        <div className="form-group text-left">
                            <label htmlFor="comments">Comentários</label>
                            <textarea ref="comments" id="comments" className="form-control" rows="3"></textarea>
                        </div>
                        <div className="form-group">
                            <button type="button" onClick={this.updateSerie} className="btn btn-success">Salvar</button>
                        </div>
                    </form>
                </div>
            </section>
        )
    }

}

export default EditSeries