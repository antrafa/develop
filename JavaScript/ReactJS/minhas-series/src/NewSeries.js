import React, { Component } from 'react'
import api from './Api';
import { Redirect } from 'react-router-dom'

const statuses = {
    'watched': 'Assistido',
    'watching': 'Assistindo',
    'toWatch': 'Assistir'
}

class NewSeries extends Component {
    constructor(props){
        super(props)
        this.state = {
            genres:[],
            isLoading: false,
            redirect: false
        }
        this.saveSeries = this.saveSeries.bind(this)
    }
    componentDidMount(){
        this.setState({ isLoading: true })
        api.loadGenres()
            .then((res) => {
                this.setState({
                    isLoading: false,
                    genres: res.data
                })
            })
    }
    saveSeries(){
        const newSeries = {
            name: this.refs.name.value,
            status: this.refs.status.value,
            genre: this.refs.genre.value,
            comments: this.refs.comments.value
        }
        api.saveSeries(newSeries)
            .then( (res) => {
                this.setState({
                    redirect: '/series/'+newSeries.genre
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
                <h1>Nova Série</h1>
                <div className="col-md-6 col-md-offset-3">
                    <form>
                        <div className="form-group text-left">
                            <label htmlFor="name">Nome</label>
                            <input type="text" ref="name" id="nome" className="form-control" />
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
                            <button type="button" onClick={this.saveSeries} className="btn btn-success">Salvar</button>
                        </div>
                    </form>
                </div>
            </section>
        )
    }

}

export default NewSeries