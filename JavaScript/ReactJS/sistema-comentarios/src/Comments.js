import React from 'react'
import Comment from './Comment'

const Comments = ({comments}) => {
    const keys = Object.keys(comments)
    return (
        <ul>
            {keys.map( key => {
                return <Comment c={comments[key]} key={key} />
            })}
        </ul>
    )
}

export default Comments