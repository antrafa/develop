import React from 'react'

const Comment = ({c}) => {
    let comment = 'vazio'
    let email = ''
    if(c){
        if(c.comment){
            comment = c.comment
        }
        if(c.email){
            email = c.email
        }
    }
    return(
        <div className='card mt-3'>
            <div className='card-body'>
                {comment} <br />
                <span className='text-muted'>{ email && ('Enviado por: ' + email)}</span>
            </div>
        </div>
    )
}

export default Comment