import firebase from 'firebase/app'
import 'firebase/database'
import 'firebase/auth'

// Initialize Firebase
var config = {
      
};
firebase.initializeApp(config);
export const database = firebase.database()
export const auth = firebase.auth()