import React from 'react';
import { StyleSheet, Text, View, Button, Image } from 'react-native';

import logo from './assets/logo.png'

export default class App extends React.Component {
  constructor(props) {
    super(props)
    this.findMyIp = this.findMyIp.bind(this)
    this.state = {
      data: ''
    }
  }
  async findMyIp() {
    this.setState({ data: 'Descobrindo IP....' })
    const ip = await fetch('http://httpbin.org/ip')
    const data = await ip.json();
    this.setState({
      data: data.origin
    })
  }
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.body}>
          <Image source={logo} />
          <Text style={styles.titleIp}>{this.state.data}</Text>
          <Button title='Descobrir ip' onPress={this.findMyIp} />
        </View>
        <View style={styles.footer}>
          <Text style={styles.copyright}>by Antonio Rafael Ortega</Text>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'steelblue',
    alignItems: 'stretch',
    justifyContent: 'center',
  },
  body: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },
  titleIp: {
    color: 'white',
    fontSize: 14,
    paddingTop: 20,
    paddingBottom: 20
  },
  footer: {
    paddingTop: 10,
    paddingBottom: 10
  },
  copyright: {
    color: '#fff',
    textAlign: 'center'
  },
});
