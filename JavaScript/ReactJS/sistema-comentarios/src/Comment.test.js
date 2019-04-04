import React from 'react'
import Comment from './Comment'
import { render } from 'enzyme'

it('should render text', () => {
      const c = {
            comment: 'Teste'
      }
      const wrapper = render(<Comment c={c} />)
      expect(wrapper.text()).toBe('Teste')
})

it('should render empty', () => {
      const wrapper = render(<Comment />)
      expect(wrapper.text()).toBe('vazio')
})