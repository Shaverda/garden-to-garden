import React from 'react'
import { View, TouchableOpacity, Text } from 'react-native'
import RoundedButton from './RoundedButton'
import styles from './Styles/LoginButtonStyles'

export default class LoginButton extends React.Component {
    constructor (props) {
        super(props)
        
    }
    
    
    render () {
        
        return (
                <View>
                <TouchableOpacity style={styles.button} onPress={this.props.onPress}>
                <Text style={styles.buttonText}>
                Sign In
                </Text>
                </TouchableOpacity>
                </View>
                )
        
    }
}
