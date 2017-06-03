import React, { PropTypes } from 'react'
import { View, Text } from 'react-native'
import styles from './Styles/BottomNavStyles.js'
import RoundedButton from './RoundedButton.js'
import NavButton from './NavButton.js'

export default class BottomNav extends React.Component {
    static propTypes = {
    onPress: PropTypes.func,
    text: PropTypes.string,
    children: PropTypes.string,
    navigator: PropTypes.object
    }
    
    getText () {
        const buttonText = this.props.text || this.props.children || ''
        return buttonText.toUpperCase()
    }
    
    render () {
        return (
                <View style={styles.button} onPress={this.props.onPress}>
                  <NavButton>Profile</NavButton >
                  <NavButton>Swipe</NavButton >
                  <NavButton>Matches</NavButton >
                </View>
                )
    }
}
