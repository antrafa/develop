import React from 'react'

import { shallow } from 'enzyme'
import { DisplayCounter } from './DisplayCounter'

describe('<DisplayCounter />', () => {
    it('mount', () => {
        const wrapper = shallow(<DisplayCounter count={10} />)
        expect(wrapper.contains(<p>O contador está em 10</p>)).toBe(true)
    })
})