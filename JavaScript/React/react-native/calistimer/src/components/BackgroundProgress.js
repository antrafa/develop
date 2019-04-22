import React, { Component } from 'react'
import { View, StyleSheet, Animated } from 'react-native'

class BackgroundProgress extends Component{
    constructor(props){
        super(props)
        this.height = new Animated.Value(0)
    }
    componentDidUpdate(prevProps){
        if(prevProps.percentage !== this.props.percentage){
            Animated.timing(this.height, {
                toValue: this.props.percentage > 100 ? 100 : this.props.percentage,
                duration: 500
            }).start()
        }
    }
    render(){
        const { children } = this.props
        const h = this.height.interpolate({
            inputRange: [0, 100],
            outputRange: ['0%', '100%']
        })
        const h2 = this.height.interpolate({
            inputRange: [0, 100],
            outputRange: ['100%', '0%']
        })
        return (
            <View style={styles.containerFlex}>
                <View style={styles.containerFlex}>
                    <Animated.View style={{ height: h2, backgroundColor: '#1377b5'}} />
                    <Animated.View style={{ height: h, backgroundColor: '#222222'}} />
                </View>
                <View style={styles.containerContent}>
                    {children}
                </View>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    containerFlex: {
        flex: 1
    },
    containerContent: {
        position: 'absolute',
        top: 0,
        bottom: 0,
        left: 0,
        right: 0
    },
    background1: {
        
    }
})

export default BackgroundProgress