import React from 'react'
import { View, Modal } from 'react-native'
import RoundedButton from './RoundedButton'
import { StackNavigator } from 'react-navigation'


export default class SignUpButton extends React.Component {
    constructor (props) {
        super(props)

    }
    
    openProfileEntry = () => {
//        this.props.navigation.navigate('ProfileEntry')
    }
    
    render () {

            return (
                    <View>
                    <RoundedButton onPress={this.openProfileEntry()}>
                    Sign Up
                    </RoundedButton>
                    </View>
                    )

    }
}
