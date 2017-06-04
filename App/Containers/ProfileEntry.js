import React from 'react'
import { ScrollView, Text, Image, View } from 'react-native'

import { Images } from '../Themes'

// Styles
import styles from './Styles/ProfileEntryStyles'

export default class ProfileEntry extends React.Component {
    render () {
        return (
                <View style={styles.mainContainer}>
                <ScrollView style={styles.container}>
                
                <View style={styles.section} >
                <Text style={styles.sectionText}>
                Welcome to Garden to Garden!
                Whether you garden yourself, want fresh veggies,
                or any other reason, we are glad you are here.
                
                This application is based off locale - why drive
                to swap veggies when your neighbor down the street
                has exactly what you want?
                
                On your profile, you upload a personal picture
                which ideally includes your face.  Once that's
                completed, you put in your zip code and start
                listed the vegetables, spices, fruits, herbs,
                and flowers you are growing.  Immediately next
                to your column of items you are growing is a
                "ready by" section.  This lets everyone know
                when the item you are growing is ready to swap.
                
                Some other aspects include the quantity, quality,
                and image uploading section.
                
                In the future we hope to add a section of what
                you are searching for.  That way instead of 
                just swiping on the people within a certain 
                circumference, you can filter based off a 
                specific gardened item.  Or you can just 
                see what your neighbors are offering.  
                Either way, we appreciate you and your 
                patience and hope to grow into the perfect
                tool for you.  

                </Text>
                </View>

                </ScrollView>
                </View>
                )
    }
}
