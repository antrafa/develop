import reducer from './reducer'

test('Reducer decrement',() => {
    const initialState = {
        count: 10
    }
    const action = {
        type: 'DECREMENT',
        value: 10
    }
    const state = reducer(initialState, action)
    expect(state).toEqual({ count: 0 })
})

test('Reducer increment',() => {
    const initialState = {
        count: 0
    }
    const action = {
        type: 'INCREMENT',
        value: 10
    }
    const state = reducer(initialState, action)
    expect(state).toEqual({ count: 10 })
})

test('Reducer initial state null',() => {
    const initialState = undefined
    const action = {
        type: 'INCREMENT',
        value: 10
    }
    const state = reducer(initialState, action)
    expect(state).toEqual({ count: 10 })
})