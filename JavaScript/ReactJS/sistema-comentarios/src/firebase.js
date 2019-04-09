import firebase from 'firebase/app'
import 'firebase/database'
import 'firebase/auth'

// Initialize Firebase
var config = {
      apiKey: "AIzaSyDOd-wpVytRibQle7uSy8KPn7afqtWyEOw",
      authDomain: "comments-antrafa.firebaseapp.com",
      databaseURL: "https://comments-antrafa.firebaseio.com",
      projectId: "comments-antrafa",
      storageBucket: "comments-antrafa.appspot.com",
      messagingSenderId: "907673694296"
};
firebase.initializeApp(config);
export const database = firebase.database()
export const auth = firebase.auth()