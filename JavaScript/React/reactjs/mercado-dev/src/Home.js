import React, { Component } from 'react'
import AnuncioHome from './AnuncioHome'
import HeaderHome from './HeaderHome'
import LinkCategoria from './LinkCategoria'
import base from './base'

class Home extends Component {
    constructor(props){
		super(props)
		this.state = {
			categorias: [],
			anuncios: []
		}
		base.bindToState('anuncios', {
			context: this,
			state: 'anuncios',
			queries: {
				limitToLast: 3
			}
		})
	}
    render(){
        let index = 0
        const { anuncios } = this.state
        const { categorias } = this.props
        return(
            <div>
                <HeaderHome />
                <div className='container'>
                    <h3>Últimos anúncios</h3>
                    <div className='row'>
                        { 
                            Object.keys(anuncios).map( (key) => {
                                const anuncio = anuncios[key]
                                return ([
                                    <AnuncioHome key={key} anuncio={anuncio} />
                                ])
                            })
                        }
                    </div>
                    <h3>Categorias</h3>
                    <div className='row'>
                        {
                            categorias.map( (cat, indice) => {
                                return ([
                                    <LinkCategoria key={indice} categoria={cat} />,
                                    ++index % 4 === 0 && <div key={'c'+index} className='w-100'></div> 
                                ])
                            })
                        }
                    </div>
                    
                </div>
            </div>
        )
    }
}

export default Home