console.log('Firebase is installed!');
var admin = require('firebase-admin');
var serviceAccount = require("./ServiceAccountKey.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://snosmoringsappen.firebaseio.com"
});
// This registration token comes from the client FCM SDKs.
// The topic name can be optionally prefixed with "/topics/".
var message = {
  data: {
    title: 'Det er meldt snø!',
    message: 'Har du husket å preppe dine ski?',
    img_url: 'https://images.unsplash.com/photo-1542351567-cd7b06dc08d7?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5590142a09415e959b3e67f90d352e0b&auto=format&fit=crop&w=1349&q=80'
  }
};

var topic = "test";

admin.messaging().sendToTopic(topic, message)
  .then(function(response) {
    console.log("Successfully sent message:", response);
  })
  .catch(function(error) {
    console.log("Error sending message:", error);
  });
