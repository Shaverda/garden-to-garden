import { StyleSheet } from 'react-native'
import { Fonts, Colors, Metrics } from '../../Themes/'

export default StyleSheet.create({
    button: {
         flex: 1,
         flexDirection: 'row',
        borderRadius: 0,
        marginHorizontal: Metrics.nav,
        marginVertical: 0,
        backgroundColor: 'snow',
        justifyContent: 'center',
        position: 'absolute',
        bottom: 0,
        height: 70,
        width: 375
    },
    buttonText: {
       color: Colors.snow,
       textAlign: 'center',
       fontWeight: 'bold',
       fontSize: Fonts.size.medium,
       marginVertical: Metrics.baseMargin
    }
})
