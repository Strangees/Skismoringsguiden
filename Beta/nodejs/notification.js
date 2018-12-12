//var topic = 'Oppdateringer';
var registrationToken ='fFzNgy-2rlI:APA91bH1Q8cLVZBwKGmBjc7kSwMT8l3PyWQvDgDeHIxFL0dkQgISWRnrpBOk0fPgEFauSCQ40fwbN6GqWys099E_EsXRZLzIR7xyLgTFbOIep4YOze0P4XPwob4SjoyB-rHg4aFZ_bQ2'
// See documentation on defining a message payload.
var message = {
  webpush: {
    notification:{
      title: 'test',
      body: 'test'
    }
  }
  //data: {
    //score: '850',
    //time: '2:45'
  },
  topic: 'Oppdateringer'
};

// Send a message to devices subscribed to the provided topic.
admin.messaging().send(message)
  .then((response) => {
    // Response is a message ID string.
    console.log('Successfully sent message:', response);
  })
  .catch((error) => {
    console.log('Error sending message:', error);
  });
