import React, { PropTypes } from 'react'
import { TouchableOpacity, Text } from 'react-native'
import styles from './Styles/NavButtonStyles.js'


export default class NavButton extends React.Component {
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
                <TouchableOpacity style={styles.button} onPress={this.props.onPress}>
                <Text style={styles.buttonText}>{this.getText()}</Text>
                </TouchableOpacity>
                )
    }
}
