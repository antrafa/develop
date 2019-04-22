import React, { Component } from 'react'
import { 
    Keyboard, 
    Platform, 
    View, 
    ScrollView, 
    Text, 
    StyleSheet, 
    Image, 
    TextInput, 
    KeyboardAvoidingView, 
    TouchableOpacity 
} from 'react-native'
import Sound from 'react-native-sound'
import KeepAwake from 'react-native-keep-awake'

import Select from '../components/Select'
import Title from '../components/Title'
import Time from '../components/Time'
import ProgressBar from '../components/ProgressBar'
import BackgroundProgress from '../components/BackgroundProgress'

const alert = require('../../assets/sounds/alert.wav')

class EMOMScreen extends Component {
    state = {
        keyboardIsVisible: false,
        isRunning: false,
        paused: false,

        alerts: [0, 15],
        countDown: 1,//SIM NAO
        countDownValue: 0,//COMECA EM QUANTO O COUNTDOWN
        count: 0,//INICIO DA CONTAGEM DE TEMPO
        time: '2',//QUANTO TEMPO
    }
    componentDidMount() {
        Sound.setCategory('Playback', true)
        this.alert = new Sound(alert)

        this.keyboardShow = Keyboard.addListener('keyboardDidShow', () => {
            this.setState({ keyboardIsVisible: true })
        })
        this.keyboardHide = Keyboard.addListener('keyboardDidHide', () => {
            this.setState({ keyboardIsVisible: false })
        })
        // this.play()
    }
    componentWillUnmount() {
        this.keyboardShow.remove()
        this.keyboardHide.remove()
    }
    playAlert = () => {
        const resto = this.state.count % 60
        if(this.state.alerts.indexOf(resto) >= 0){
            this.alert.play()
        }
        if(this.state.countDown === 1){
            if(resto >= 55 && resto < 60){
                this.alert.play()
            }
        }
    }
    back = () => {
        if(this.state.paused || !this.state.isRunning){
            this.clear()
            this.props.navigation.goBack()
        }
    }
    restart = () => {
        if(this.state.paused){
            this.clear()
            this.play()
        }
    }
    stop = () => {
        this.setState({
            paused: !this.state.paused
        })
    }
    clear = () => {
        clearInterval(this.countDownTimer)
        clearInterval(this.countTimer)
    }
    play = () => {
        this.setState({
            paused: false,
            count: 0,
            countDownValue: this.state.countDown === 1 ? 5 : 0,
            isRunning: true
        })
        const count = () => {
            if(this.state.paused) return
            this.setState({ count: this.state.count + 1 }, () => {
                this.playAlert()
                if(this.state.count === parseInt(this.state.time) * 60){
                    clearInterval(this.countTimer)
                }
            })
        }
        if(this.state.countDown === 1){
            this.alert.play()
            this.countDownTimer = setInterval( () => {
                if(this.state.paused) return
                this.alert.play()
                this.setState({ countDownValue: this.state.countDownValue - 1 }, () => {
                    if(this.state.countDownValue === 0){
                        clearInterval(this.countDownTimer)
                        this.countTimer = setInterval(count, 1000)
                    }
                })
            }, 1000)
        }else{
            this.countTimer = setInterval(count, 1000)
        }
    }
    render() {
        if(this.state.isRunning){
            //Quantos porcento do minuto já foi
            const percMinute = parseInt(((this.state.count % 60) / 60 )*100)

            //Quantos porcento do tempo já foi
            const percTime = parseInt(((this.state.count / 60) / parseInt(this.state.time)) * 100)

            const opacity = !this.state.paused ? 0.1 : 1

            return(
                <BackgroundProgress percentage={percMinute}>
                    <View style={styles.containerContagem}>
                        <KeepAwake />
                        <View style={{flex: 1}}>
                            <Title title={'EMOM'} subtitle={'Every Minute On The Minute'}></Title>
                        </View>
                        <View style={{flex: 1, justifyContent: 'center'}}>
                            <Time time={this.state.count}></Time>
                            <ProgressBar percentage={percTime} />
                            <Time time={parseInt(this.state.time) * 60 - this.state.count} type='text2' appendedText=' restantes'></Time>
                        </View>
                        <View style={{flex: 1, justifyContent: 'flex-end'}}>
                            {
                                this.state.countDownValue > 0 ? 
                                <Text style={styles.countdown}>{this.state.countDownValue}</Text>
                                : null
                            }
                            <View style={{ flexDirection: 'row', justifyContent: 'space-evenly'}}>
                                <TouchableOpacity style={styles.btnPlayStop} onPress={this.back}>
                                    <Image style={{opacity}} source={require('../../assets/left-arrow.png')} />
                                </TouchableOpacity>
                                <TouchableOpacity style={styles.btnPlayStop} onPress={this.stop}>
                                    { this.state.paused ? <Image source={require('../../assets/btn-play.png')} /> : <Image source={require('../../assets/btn-stop.png')} /> }
                                </TouchableOpacity>
                                <TouchableOpacity style={styles.btnPlayStop} onPress={this.restart}>
                                    <Image style={{opacity}} source={require('../../assets/restart.png')} />
                                </TouchableOpacity>
                            </View>
                        </View>
                    </View>
                </BackgroundProgress>
            )
        }
        const behavior = Platform.OS !== 'ios' ? 'height' : 'padding'
        return (
            <KeyboardAvoidingView style={{ flex: 1 }} behavior={behavior}>
                <ScrollView style={styles.container}>
                    <View style={{flex: 1 }}>
                        <Title title={'EMOM'} subtitle={'Every Minute On The Minute'}></Title>
                        <Image style={styles.btnSettings} source={require('../../assets/settings-cog.png')} />
                    </View>
                    <View style={{flex: 1, justifyContent: 'center' }}>
                        <Select
                            label='Alertas'
                            current={this.state.alerts}
                            options={[{
                                id: 0,
                                label: '0s'
                            }, {
                                id: 15,
                                label: '15s'
                            }, {
                                id: 30,
                                label: '30s'
                            }, {
                                id: 45,
                                label: '45s'
                            }]}
                            onSelect={
                                opt => this.setState({ alerts: opt })
                            } />
                    </View>
                    <View style={{flex: 1, justifyContent: 'center' }}>
                        <Select
                            label='Contagem regressiva'
                            current={this.state.countDown}
                            options={[{
                                id: 1,
                                label: 'sim'
                            }, {
                                id: 0,
                                label: 'não'
                            }]}
                            onSelect={
                                opt => this.setState({ countDown: opt })
                            } />
                    </View>
                    <View style={{flex: 1, justifyContent: 'flex-end' }}>
                        <Text style={[styles.label, styles.labelTitle]}>Quantos minutos:</Text>
                        <TextInput
                            style={styles.input}
                            keyboardType='numeric'
                            value={this.state.time}
                            onChangeText={
                                text => this.setState({ time: text })
                            } />
                        <Text style={[styles.label, styles.labelTitle]}>Minutos</Text>
                    </View>
                    <View style={{flex: 1, justifyContent: 'flex-end' }}>
                        <View style={{ flexDirection: 'row', justifyContent: 'space-evenly'}}>
                            <TouchableOpacity style={styles.btnPlayStop} onPress={this.back}>
                                <Image source={require('../../assets/left-arrow.png')} />
                            </TouchableOpacity>
                            <TouchableOpacity style={styles.btnPlayStop} onPress={this.play}>
                                <Image source={require('../../assets/btn-play.png')} />
                            </TouchableOpacity>
                        </View>
                    </View>
                </ScrollView>
            </KeyboardAvoidingView>
        )
    }
}

EMOMScreen.navigationOptions = {
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
    btnSettings: {
        alignSelf: 'center',
        marginBottom: 10
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
    input: {
        textAlign: 'center',
        color: 'black',
        fontFamily: 'Ubuntu-Regular',
        fontSize: 48,
        color: 'white'
    },
    countdown: {
        fontFamily: 'Ubuntu-Bold',
        fontSize: 144,
        color: 'white',
        textAlign: 'center'
    }
})

export default EMOMScreen