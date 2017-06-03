import React from 'react'
import { ScrollView, Text, Image, View } from 'react-native'
import DevscreensButton from '../../ignite/DevScreens/DevscreensButton.js'
import SignUpButton from '../Components/SignUpButton.js'

import { Images } from '../Themes'

// Styles
import styles from './Styles/LaunchScreenStyles'

export default class LaunchScreen extends React.Component {
  render () {
    return (
      <View style={styles.mainContainer}>
        <ScrollView style={styles.container}>
          <View style={styles.centered}>
            <Image source={Images.launch} style={styles.logo} />
          </View>

          <View style={styles.section} >
            <Text style={styles.sectionText}>
            Welcome to the site.
            Whether you garden yourself, want fresh veggies,
            or any other reason, we are glad you are here.
            {"\n"}
            {"\n"}
            On your profile, you upload a personal picture
            which ideally includes your face.  Once that's
            completed, you put in your zip code and start
            listed the vegetables, spices, fruits, herbs,
            and flowers you are growing.  Immediately next
            to your column of items you are growing is a
            "ready by" section.  This lets everyone know
            when the item you are growing is ready to swap.
            </Text>
          </View>
          <SignUpButton />
          <DevscreensButton />
        </ScrollView>
      </View>
    )
  }
}
