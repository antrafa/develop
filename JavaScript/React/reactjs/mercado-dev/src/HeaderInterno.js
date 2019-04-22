import React from 'react'
import { Link } from 'react-router-dom'
import logo2 from './logo2.png'

const HeaderInterno = props => {
    return (
        <nav className="navbar navbar-dark fixed-top bg-dark">
            <div className="container">
                <Link className="navbar-brand" to="/"><img alt="MercadoDev" src={logo2} height={80} /></Link>
                <div className="collapse navbar-collapse" id="navbarsExampleDefault">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to="#">Home <span className="sr-only">(current)</span></Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="#">Link</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    )
}
export default HeaderInterno