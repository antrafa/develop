import React from 'react'
import { StyleSheet, View, Text } from 'react-native'

import Button from '../components/Button'

const HomeScreen = props => {
    return (
        <View style={styles.container}>
            <View style={{ flex: 1 }}>
                <Text style={styles.logo}>CalisTimer</Text>
            </View>
            <View style={{ flex: 1, marginBottom: 20 }}>
                <Button style={styles.btn} styleText={styles.text} onPress={() => props.navigation.navigate('EMOM')}>EMOM</Button>
                <Button style={styles.btn} styleText={styles.text} onPress={() => props.navigation.navigate('AMRAP')}>AMRAP</Button>
                <Button style={styles.btn} styleText={styles.text} onPress={() => props.navigation.navigate('Isometria')}>Isometria</Button>
                <Button style={styles.btn} styleText={styles.text} onPress={() => props.navigation.navigate('Sobre')}>Sobre</Button>
            </View>
        </View>
    )
}

HomeScreen.navigationOptions = {
    header: null
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#1377b5'
    },
    logo: {
        flex: 1,
        fontSize: 48,
        textAlign: 'center',
        fontFamily: 'Ubuntu-Bold',
        color: '#FFFFFF',
        marginTop: 110
    },
    btn: {
        padding: 15,
        marginBottom: 15
    },
    text: {
        color: '#FFFFFF',
        fontSize: 30,
        textAlign:'center'
    }
})

export default HomeScreen