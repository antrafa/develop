import React from 'react'
import ReactDOM from 'react-dom'
import App from './App'
import Api from './Api'
import * as serviceWorker from './serviceWorker'

ReactDOM.render(<App api={Api} />, document.getElementById('root'))
serviceWorker.unregister()