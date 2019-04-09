import React from 'react'
import ReactDOM from 'react-dom'
import App from './App'
import * as serviceWorker from './serviceWorker'

import { database, auth } from './firebase'

ReactDOM.render(<App database={database} auth={auth} />, document.getElementById('root'))
serviceWorker.unregister()