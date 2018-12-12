package one.swc.skismringsguiden;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;


import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "data" + remoteMessage.getData());
        Log.d(TAG, "messeage type " + remoteMessage.getMessageType());
            String title,message,img_url;

            title = remoteMessage.getData().get("title");

            Log.d(TAG, "onMessageReceived: "+remoteMessage.getData().get("title"));
            message = remoteMessage.getData().get("message");
            Log.d(TAG, "onMessageReceived: "+remoteMessage.getData().get("message"));
            img_url = remoteMessage.getData().get("img_url");
            Log.d(TAG, "onMessageReceived: "+remoteMessage.getData().get("img_url"));

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT);
            String kanalid = getString(R.string.default_notification_channel_id);
            Log.d(TAG, "default_notification_channel_id "+kanalid);
            //load img
        Bitmap bmp = null;
        try {
            InputStream in = new URL(img_url).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,kanalid)
                .setSmallIcon(R.drawable.ic_stat_ac_unit)
                .setContentTitle(title)
                .setContentText(message).setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(bmp))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, mBuilder.build());
        Log.d(TAG, "Notification builded ");

        }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }
}