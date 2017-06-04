import { StyleSheet } from 'react-native'
import { Metrics, ApplicationStyles, Colors } from '../../Themes/'

export default StyleSheet.create({
    ...ApplicationStyles.screen,
    container: {
        paddingBottom: Metrics.baseMargin
    },
    logo: {
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
        marginTop: 25,
        marginBottom: 20,
        paddingBottom: 10,
        paddingRight: 10,
        paddingLeft: 10,
        backgroundColor: Colors.snow,
        borderColor: 'black',
        borderWidth: 2,
        borderRadius: 5
    },
    sectionText: {

    }
})
