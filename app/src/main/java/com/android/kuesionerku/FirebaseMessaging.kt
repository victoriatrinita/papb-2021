package com.android.kuesionerku

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_ONE_SHOT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES.O
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessaging : FirebaseMessagingService() {
    lateinit var title: String
    lateinit var message: String
    lateinit var manager: NotificationManager
    var CHANNEL_ID = "CHANNEL"

    override fun onMessageReceived(remotemessage: RemoteMessage) {
        super.onMessageReceived(remotemessage)
        title = remotemessage.notification!!.title!!
        message = remotemessage.notification!!.body!!

/* if you have any custom data from backend
 data=remotemessage.data.get("yourkeyvalue")*/

//        if (message == null) {
//            message = Objects.requireNonNull(remotemessage.notification!!.body)!!
//
//        }
        manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        sendNotification()
    }

    override fun onNewToken(token: String) {
//        super.onNewToken(p0)
        Log.d("TAG", "the token refreshed: $token")
    }

    private fun sendNotification() {
        var intent = Intent(applicationContext, BerandaActivity::class.java)

        intent.putExtra("title", title)
        intent.putExtra("message", message)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                CHANNEL_ID,
                "pushnotification",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_logo)
            .setAutoCancel(true)
            .setContentText(message)

        var pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, FLAG_ONE_SHOT)

        builder.setContentIntent(pendingIntent)
        manager.notify(O, builder.build())
    }

}