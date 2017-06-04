import React from 'react'
import { ScrollView, Text, Image, View } from 'react-native'

import { Images } from '../Themes'

// Styles
import styles from './Styles/AboutScreenStyles'

export default class AboutScreen extends React.Component {
    render () {
        return (
                <View style={styles.mainContainer}>
                <Image source={Images.background} style={styles.backgroundImage} resizeMode='repeat' />
                <ScrollView style={styles.container}>
                <View style={styles.section} >
                <View style={styles.centered}>
                <Image source={Images.logo} style={styles.logo} />
                </View>
                <Text style={styles.sectionText}>
                Garden to Garden is an app that allows you to share vegetables, fruits, or herbs grown in your garden with other neighborhood gardeners. You can also donate your produce to nearby food banks who are in need of fresh produce.
                {"\n"}
                {"\n"}
                How does it work?
                {"\n"}
                {"\n"}
                Garden to Garden is based off location. The app uses your phone’s GPS to find other avid gardeners nearby.
                {"\n"}
                {"\n"}
                1. Create a profile by entering your name and email address, a username, then upload your profile pic.
                {"\n"}
                {"\n"}
                2. Next, type in the vegetables, fruits, and herbs you are growing. Then enter the "Ready By" date. This lets everyone know when the item you are growing is ready to swap. You’ll also be able to upload a photo of your produce.
                {"\n"}
                {"\n"}
                3. After you’ve entered your information, you can search for nearby produce in your neighborhood. If you see produce you like, swipe right. If you do not want that item, swipe left.
                </Text>
                </View>
                
                </ScrollView>
                </View>
                )
    }
}
