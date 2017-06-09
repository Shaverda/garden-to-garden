import React from 'react'
import { ScrollView, Text, Image, View, TouchableHighlight, StyleSheet } from 'react-native'
import form from 'tcomb-form-native'
import { Images } from '../Themes'

var Form = form.form.Form;
// Styles
import styles from './Styles/ProfileEntryStyles'


var User = form.struct({
  email_address: form.String,              
  username: form.String,
  password: form.String      
});
var options = {};

var ProfileEntry = React.createClass({
    getInitialState() {
    return {
            email_address: "",              
            username: "",
            password: "",
            position: ""
    };
    },


    componentDidMount() {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        this.setState({
          position: position
        });
      },
      (error) => this.setState({ error: error.message }),
      { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 },
    );
    },

    onPress: function () {
        // call getValue() to get the values of the form
        var value = this.refs.form.getValue();
        if (value) { // if validation fails, value will be null
          console.log(value); // value here is an instance of Person
        }
        console.log(this.state.position);
        
        fetch('http://localhost:8080/accounts/create', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            accountName: value.username,
            email: value.email_address,
            password: value.password, 
            location: 'austin'
          })
        }).then((response) => {
          console.log(response);
        })
  },



    render: function () { 
        return (
                <View style={form_styles.container}>
                <Image source={Images.background} style={styles.backgroundImage} resizeMode='repeat' />
                     <Form
                      ref="form"
                      type={User}
                        options={options}
                        />
                    <TouchableHighlight  style={form_styles.button} onPress={this.onPress} underlayColor='#99d9f4'>
                        <Text style={form_styles.buttonText}>Submit</Text>
                    </TouchableHighlight>
                    
                </View>
                )
    }
});

var form_styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    marginTop: 50,
    padding: 20,
    backgroundColor: '#ffffff',
  },
  title: {
    fontSize: 30,
    alignSelf: 'center',
    marginBottom: 30
  },
  buttonText: {
    fontSize: 18,
    color: 'white',
    alignSelf: 'center'
  },
  button: {
    height: 36,
    backgroundColor: '#48BBEC',
    borderColor: '#48BBEC',
    borderWidth: 1,
    borderRadius: 8,
    marginBottom: 10,
    alignSelf: 'stretch',
    justifyContent: 'center'
  }
});

export default ProfileEntry;
