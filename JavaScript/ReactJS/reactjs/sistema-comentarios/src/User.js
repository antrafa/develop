import React from 'react'

const User = props => {
    return(
        <div>
            <div className="alert-light text-right" role="alert">
                Logado como {props.email}. <button type="button" href='void(0)' onClick={props.logout} className="alert-link ml-2">Sair</button>
            </div>
            <hr />
        </div>
    )
}
export default User