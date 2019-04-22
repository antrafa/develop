import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

export const Title = props => {
    return (<View style={[stylesTitle.container, props.style]}>
        <Text style={stylesTitle.title}>{props.title}</Text>
        <Text style={stylesTitle.subtitle}>{props.subtitle}</Text>
    </View>);
};

const stylesTitle = StyleSheet.create({
    container: {
        paddingTop: 40,
        paddingBottom: 20
    },
    title: {
        fontSize: 48,
        textAlign: 'center',
        fontFamily: 'Ubuntu-Bold',
        color: '#FFFFFF'
    },
    subtitle: {
        fontSize: 14,
        textAlign: 'center',
        fontFamily: 'Ubuntu-Regular',
        color: '#FFFFFF'
    }
})

export default Title