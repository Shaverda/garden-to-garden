import { StyleSheet } from 'react-native'
import { Metrics, ApplicationStyles } from '../../Themes/'

export default StyleSheet.create({
     ...ApplicationStyles.screen,
     container: {
         paddingBottom: Metrics.baseMargin
     },
     logo: {
         marginTop: 20,
         marginBottom: 0,
         height: Metrics.images.logo,
         width: Metrics.images.logo,
         resizeMode: 'contain'
     },
     centered: {
         alignItems: 'center'
     },
     section: {
         marginHorizontal: Metrics.section,
         marginBottom: 20,
         padding: 10
     },
     sectionText: {
     
     },
     profilePic: {
         width: 100,
         height: 100,
         marginVertical: 10
     }
})
