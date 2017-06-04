import React from 'react'
import { View, TouchableOpacity, Text } from 'react-native'
import RoundedButton from './RoundedButton'
import styles from './Styles/SignUpButtonStyles'

export default class SignUpButton extends React.Component {
    constructor (props) {
        super(props)

    }
    
    
    render () {
            
            return (
                    <View>
                    <TouchableOpacity style={styles.button} onPress={this.props.onPress}>
                    <Text style={styles.buttonText}>
                    Sign Up
                    </Text>
                    </TouchableOpacity>
                    </View>
                    )

    }
}
