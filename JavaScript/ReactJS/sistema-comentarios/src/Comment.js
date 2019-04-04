import React from 'react'

const Comment = ({c}) => {
    let comment = 'vazio'
    if(c && c.comment){
        comment = c.comment
    }
    return(
        <li>{comment}</li>
    )
}

export default Comment