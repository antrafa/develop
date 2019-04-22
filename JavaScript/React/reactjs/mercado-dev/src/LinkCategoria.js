import React from 'react'

const LinkCategoria = ({ categoria, icon }) => {
    return (
        <a href={`/anuncios/categoria/`} className="btn btn-secondary h-100 m-2 col-sm">
            <i className={`fa ${categoria.icon} fa-4x`} aria-hidden="true"></i><br />
            {categoria.categoria}
        </a>
    )
}
export default LinkCategoria