import React, { Component } from 'react'
import {
    View,
    Text,
    StyleSheet,
    Image,
    TouchableOpacity,
    Linking
} from 'react-native'

import Title from '../components/Title'

const SobreScreen = props => {
    const back = () => {
        props.navigation.goBack()
    }
    const openURL = url => () => {
        Linking.openURL(url)
    }
    return (
        <View style={{ flex: 1 }}>
            <View style={styles.container}>
                <View style={{ flex: 1 }}>
                    <Title title={'Sobre'} subtitle={''}></Title>
                </View>

                <View style={{ flex: 1, justifyContent: 'center' }}>
                    <Text style={styles.textoSobre}>Este aplicativo foi desenvolvido por Antonio Rafael Ortega (@antonioiae) durante as aulas do devReactJS nos módulos de react-native.</Text>
                    <TouchableOpacity onPress={openURL('https://devpleno.com/devreactjs')}>
                        <Image style={{ alignSelf: 'center' }} source={require('../../assets/devreactjs.png')} />
                    </TouchableOpacity>
                </View>

                <View style={{ flex: 1, justifyContent: 'flex-end' }}>
                    <View style={{ flexDirection: 'row', justifyContent: 'space-evenly' }}>
                        <TouchableOpacity style={styles.btnPlayStop} onPress={back}>
                            <Image source={require('../../assets/left-arrow.png')} />
                        </TouchableOpacity>
                    </View>
                </View>
            </View>
        </View>
    )
}

SobreScreen.navigationOptions = {
    header: null
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#1377b5'
    },
    containerContagem: {
        flex: 1,
        justifyContent: 'center'
    },
    btnPlayStop: {
        alignSelf: 'center',
        marginBottom: 40
    },
    label: {
        textAlign: 'center',
        color: 'white',
        fontFamily: 'Ubuntu-Regular',
        fontSize: 24
    },
    labelTitle: {
        fontSize: 30,
        marginBottom: 10
    },
    textoSobre: {
        color: 'white',
        padding: 20,
        fontFamily: 'Ubuntu-Regular',
        fontSize: 16,
        textAlign: 'center',
        lineHeight: 20
    }
})

export default SobreScreen