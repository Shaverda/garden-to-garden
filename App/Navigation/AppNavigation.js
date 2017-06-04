import { StackNavigator } from 'react-navigation'
import LaunchScreen from '../Containers/LaunchScreen'
import LoginScreen from '../Containers/LoginScreen'
import ProfileEntry from '../Containers/ProfileEntry'
import AboutScreen from '../Containers/AboutScreen'
import ProfileDisplay from '../Containers/ProfileDisplay'

import styles from './Styles/NavigationStyles'

// Manifest of possible screens
const PrimaryNav = StackNavigator({
  LaunchScreen: { screen: LaunchScreen },
  LoginScreen: {
    screen: LoginScreen,
    navigationOptions: { title: 'Login' },
  },
  ProfileEntry: {
    screen: ProfileEntry,
    navigationOptions: { title: 'ProfileEntry'}
  },
  AboutScreen: {
    screen: AboutScreen,
    navigationOptions: { title: 'About'}
  },
  ProfileDisplay: {
    screen: ProfileDisplay,
    navigationOptions: { title: 'Profile'}
  }
}, {
  // Default config for all screens
  headerMode: 'none',
  initialRouteName: 'LaunchScreen',
  navigationOptions: {
    headerStyle: styles.header
  }
})

export default PrimaryNav
