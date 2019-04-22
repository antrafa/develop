import React, { Component } from 'react'
import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'

class Select extends Component {
    state = {
        current: ''
    }
    componentDidMount(){
        this.setState({
            current: this.props.current
        })
    }
    handlePress = opt => () => {
        const { current } = this.state
        if(Array.isArray(current)){
            let newCurrent = current
            const i = current.indexOf(opt)
            if(i >= 0){
                newCurrent = [...current]
                newCurrent.splice(i, 1)
            }else{
                newCurrent = [...current, opt]
            }
            this.setState({
                current: newCurrent
            })
            if (this.props.onSelect) {
                this.props.onSelect(newCurrent)
            }
        }else{
            this.setState({
                current: opt
            })
            if (this.props.onSelect) {
                this.props.onSelect(opt)
            }
        }
    }
    checkItem = item => {
        const { current } = this.state
        if(Array.isArray(current)){
            return current.indexOf(item) >= 0
        }
        return current === item
    }
    render() {
        const { options, label } = this.props
        return (
            <View style={stylesSelect.containerSelect}>
                <Text style={[stylesSelect.label, stylesSelect.labelTitle]}>{label}</Text>
                <View style={stylesSelect.select}>
                    {options.map(opt => {
                        let id = ''
                        let label = ''
                        if(typeof opt === 'string'){
                            id = opt
                            label = opt
                        }else if(typeof opt === 'object'){
                            id = opt.id
                            label = opt.label
                        }
                        return (
                            <TouchableOpacity
                                key={id}
                                onPress={this.handlePress(id)}
                                style={[stylesSelect.opt, this.checkItem(id) ? stylesSelect.optSelected : null]}>
                                <Text style={stylesSelect.label}>{label}</Text>
                            </TouchableOpacity>
                        )
                    })}
                </View>
            </View>
        )
    }
}

const stylesSelect = StyleSheet.create({
    containerSelect: {
        paddingTop: 20,
        paddingBottom: 20
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
    select: {
        flexDirection: 'row',
        justifyContent: 'space-around'
    },
    opt: {
        padding: 10
    },
    optSelected: {
        backgroundColor: 'rgba(255,255,255,0.6)',
        color: '#000000'
    }
})


export default Select