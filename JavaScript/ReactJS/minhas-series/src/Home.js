import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import api from './Api'

class Home extends Component {
    constructor(props){
        super(props);
        this.state = {
            genres: [],
            isLoading: false
        }
    }

    componentDidMount(){
        this.setState({ isLoading: true })
        api
          .loadGenres()
          .then((res) => {
            this.setState({
              isLoading: false,
              genres: res.data
            })
          })
      }
      renderGenreLink(genre){
        return (
            <li key={genre}><Link to={`/series/${genre}`}>{genre}</Link></li>
        )
      }

    render(){
        return (
            <div>
                <section id="intro" className="intro-section">

                    <div className="container">
                        {
                            this.state.isLoading && 
                            <div className="row"><span>Aguarde, carregando....</span></div>
                        }
                        {
                            !this.state.isLoading && 
                            <ul class="nav nav-pills text-center">
                                { 
                                    this.state.genres.map(this.renderGenreLink)
                                }
                            </ul>
                        }
                        <div className="row">
                            <div className="col-lg-12">
                            <h1><img src="images/logo.png" /></h1>
                            <p>Nunca mais esqueça uma série que você assistiu ou que alguém lhe indicou.</p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        )
    }

}

export default Home