import React from 'react'
import { View, Modal } from 'react-native'
import RoundedButton from './RoundedButton'

export default class SignUpButton extends React.Component {
    constructor (props) {
        super(props)

    }
    
    
    render () {
            
            return (
                    <View>
                    <RoundedButton onPress={this.props.onPress}>
                    Sign Up
                    </RoundedButton>
                    </View>
                    )

    }
}
