import React from 'react'
import { connect } from 'react-redux'

import { increment, decrement } from './actions'

export const Counter = ({count, increment, decrement}) => {
    return(
        <div>
            <p className='counter'>Contador: {count}</p>
            <button className='increment' onClick={() => increment(10)}>+</button> &nbsp;
            <button className='decrement' onClick={() => decrement(20)}>-</button>
        </div>
    )
}

//RECEBE O STORE DO REDUX, MAS UTILIZA SÓ O COUNT
const mapStateToProps = (state) => {
    return {
        count: state.count
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        increment: (value) => dispatch(increment(value)),
        decrement: (value) => dispatch(decrement(value)),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Counter)