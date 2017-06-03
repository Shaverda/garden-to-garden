import { StyleSheet } from 'react-native'
import { Fonts, Colors, Metrics } from '../../Themes/'

export default StyleSheet.create({
    button: {
                                 flex: 1,
                                 flexDirection: 'row',
        borderRadius: 0,
        marginHorizontal: Metrics.nav,
        marginVertical: 0,
        backgroundColor: Colors.background,
        justifyContent: 'center'
    },
    buttonText: {
       color: Colors.snow,
       textAlign: 'center',
       fontWeight: 'bold',
       fontSize: Fonts.size.medium,
       marginVertical: Metrics.baseMargin
    }
})
