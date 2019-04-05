import React from 'react'
import { shallow } from 'enzyme'
import NewComment from './NewComment'

describe('<NewComment />', () => {
    it('should handle changes in textarea', () => {
        const wrapper = shallow(<NewComment />)
        const event = {
            target: { value: 'test' }
        };
        wrapper.find('textarea').simulate('change', event)
        expect(wrapper.state().newComment).toBe('test')
    })
})