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
import BackgroundProgress from '../components/BackgroundProgress'

const alert = require('../../assets/sounds/alert.wav')

class IsometriaScreen extends Component {
    state = {
        keyboardIsVisible: false,
        isRunning: false,

        goal: 1,
        time: '5',//QUANTO TEMPO
        countDown: 1,//SIM NAO
        countDownValue: 0,//COMECA EM QUANTO O COUNTDOWN
        count: 0,//INICIO DA CONTAGEM DE TEMPO

        paused: false
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
        const { count, time } = this.state
        if(count >= parseInt(time) - 5 && count <= parseInt(time)){
            this.alert.play()
        }
    }
    clear = () => {
        clearInterval(this.countTimer)
        clearInterval(this.countDownTimer)
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
    play = () => {
        const time = this.state.goal === 0 ? '0' : this.state.time
        this.setState({
            count: 0,
            countDownValue: 5,
            isRunning: true,
            paused: false,
            time: time
        })
        const count = () => {
            if(this.state.paused) return
            this.setState({ count: this.state.count + 1 }, () => {
                this.playAlert()
            })
        }
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
    }
    render() {
        if(this.state.isRunning){
            //Quantos porcento do minuto já foi
            const { count, time, countDownValue, goal } = this.state
            const percMinute = time === '0' ? 0 : parseInt(((count) / parseInt(time) )*100)
            const restante = parseInt(time) >= count ? parseInt(time) - count : 0
            const opacity = !this.state.paused ? 0.1 : 1
            return(
                <BackgroundProgress percentage={percMinute}>
                    <View style={styles.containerContagem}>
                        <View style={{flex: 1}}>
                            <Title title={'Isometria'} subtitle={''}></Title>
                        </View>
                        <View style={{flex: 1, justifyContent: 'center'}}>
                            <Time time={count}></Time>
                            { 
                                goal === 1 ?
                                    <Time time={restante} type='text2' appendedText=' restantes'></Time>
                                : null 
                            }
                        </View>
                        <View style={{flex: 1, justifyContent: 'flex-end'}}>
                            { countDownValue > 0 ? <Text style={styles.countdown}>{countDownValue}</Text> : null }
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
                    <KeepAwake />
                    <View style={{flex: 1 }}>
                        <Title title={'Isometria'} subtitle={''}></Title>
                        <Image style={styles.btnSettings} source={require('../../assets/settings-cog.png')} />
                    </View>
                    <View style={{flex: 1, justifyContent: 'center' }}>
                        <Select
                            label='Alertas'
                            current={this.state.goal}
                            options={[{
                                id: 0,
                                label: 'Livre'
                            }, {
                                id: 1,
                                label: 'Bater tempo'
                            }]}
                            onSelect={
                                opt => this.setState({ goal: opt })
                            } />
                    </View>
                    <View style={{flex: 1, justifyContent: 'flex-end' }}>
                        { 
                            this.state.goal !== 0 ?
                                <React.Fragment>
                                    <Text style={[styles.label, styles.labelTitle]}>Quantos segundos:</Text>
                                    <TextInput
                                        style={styles.input}
                                        keyboardType='numeric'
                                        value={this.state.time}
                                        onChangeText={
                                            text => this.setState({ time: text })} />
                                </React.Fragment> 
                            : null 
                        }
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

IsometriaScreen.navigationOptions = {
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

export default IsometriaScreen