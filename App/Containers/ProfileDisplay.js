import React from 'react'
import { ScrollView, Text, Image, View } from 'react-native'
import BottomNav from '../Components/BottomNav.js'

import { Images } from '../Themes'

// Styles
import styles from './Styles/ProfileDisplayStyles'

export default class ProfileDisplay extends React.Component {
    render () {
        return (
                <View style={styles.mainContainer}>
                <Image source={Images.background} style={styles.backgroundImage} resizeMode='repeat' />
                <ScrollView style={styles.container}>
                
                <View style={styles.section} >
                <View style={styles.profilePic}>
                </View>
                <Text style={styles.sectionText}>
                Your Profile!
                </Text>
                </View>
                
                </ScrollView>
                <BottomNav />
                </View>
                )
    }
}
