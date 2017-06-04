import React from 'react'
import { ScrollView, Text, Image, View, Button } from 'react-native'
import DevscreensButton from '../../ignite/DevScreens/DevscreensButton.js'
import SignUpButton from '../Components/SignUpButton.js'
import LoginButton from '../Components/LoginButton.js'
import { Images } from '../Themes'

// Styles
import styles from './Styles/LaunchScreenStyles'

export default class LaunchScreen extends React.Component {
  render () {
    const { navigate } = this.props.navigation;
    return (
      <View style={styles.mainContainer}>
        <Image source={Images.background} style={styles.backgroundImage} resizeMode='repeat' />
        <ScrollView style={styles.container}>
          <View style={styles.centered}>
            <Image source={Images.launch} style={styles.logo} />
            <View style={styles.section} >
                <Image source={Images.catchphrase} style={styles.catchphrase}/>
            </View>
          </View>
          <View style={styles.buttons}>
          </View>
          <Button title="Learn More" onPress={()=>navigate('AboutScreen')}/>
          <SignUpButton onPress={()=>navigate('ProfileEntry')}/>
          <LoginButton onPress={()=>navigate('ProfileDisplay')}/>
        </ScrollView>
      </View>
    )
  }
}
