import React, { Component } from 'react';
import { StyleSheet, Text, View, TouchableOpacity } from 'react-native';

export default class App extends Component {
	constructor(props) {
		super(props)
		this.state = {
			display: '',
			result: ''
		}
	}
	handleOp(op){
		if(op === 'C'){
			this.setState({
				display: '',
				result: ''
			})
		}else if(op === '='){
			this.setState({
				display: this.state.result,
				result: ''
			})
		}else{
			const display = this.state.display + op
			let result = this.state.result

			try{
				let fixedOperation = display.split('x').join('*')
				fixedOperation = fixedOperation.split('÷').join('/')
				fixedOperation = fixedOperation.split(',').join('.')
				result = new String(eval(fixedOperation)).toString()

			} catch(e) {}

			this.setState({
				display,
				result
			})
		}
	}
	render() {
		const col1Buttons = [
			['7', '8', '9'],
			['4', '5', '6'],
			['1', '2', '3'],
			[',', '0', '=']
		]
		const col2Buttons = ['C', '÷', 'x', '+', '-']
		return (
			<View style={styles.container}>
				
				<Text style={styles.display}>{this.state.display}</Text>
				<Text style={styles.result}>{this.state.result}</Text>

				<View style={styles.buttons}>
					<View style={styles.numbers}>
						{col1Buttons.map((line, index) =>
							<View key={index} style={styles.line}>
								{line.map(op =>
									<TouchableOpacity key={op} style={styles.btn} onPress={() => this.handleOp(op)}>
										<Text style={styles.btnText}>{op}</Text>
									</TouchableOpacity>
								)}
							</View>
						)}
					</View>
					<View style={styles.operations}>
						{col2Buttons.map(op =>
							<TouchableOpacity key={op} style={styles.btn} onPress={() => this.handleOp(op)}>
								<Text style={styles.btnText}>{op}</Text>
							</TouchableOpacity>
						)}
					</View>
				</View>
			</View>
		);
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		backgroundColor: '#fff',
		alignItems: 'stretch',
		justifyContent: 'center',
	},
	display: {
		flex: 1,
		backgroundColor: '#efefef',
		fontSize: 80,
		textAlign: 'right',
		paddingRight: 10,
		paddingTop: 30
	},
	result: {
		flex: 0.4,
		backgroundColor: '#efefef',
		fontSize: 40,
		textAlign: 'right',
		paddingRight: 10,
		paddingBottom: 10
	},
	buttons: {
		flex: 5,
		flexDirection: 'row'
	},
	numbers: {
		flex: 3,
		backgroundColor: '#0d0d0d'
	},
	line: {
		flex: 1,
		flexDirection: 'row'
	},
	btn: {
		flex: 1,
		justifyContent: 'center'
	},
	btnText: {
		textAlign: 'center',
		fontSize: 50,
		color: '#fff'
	},
	operations: {
		flex: 1,
		backgroundColor: '#0b0b0b'
	}
});
