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


    // Parsing Notifikasi yang diterima dari admin FCM
    override fun onMessageReceived(remotemessage: RemoteMessage) {
        super.onMessageReceived(remotemessage)
        title = remotemessage.notification!!.title!!
        message = remotemessage.notification!!.body!!

        manager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        sendNotification()
    }

    // Print out token jika diperbarui
    override fun onNewToken(token: String) {
        Log.d("TAG", "the token refreshed: $token")
    }

    // Print out token jika diperbarui
    private fun sendNotification() {
        var intent = Intent(applicationContext, BerandaActivity::class.java)

        intent.putExtra("title", title)
        intent.putExtra("message", message)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        // Membuat channel notifikasi
        // Channel notifikasi diwajibkan Sejak API level 26
        // agar notifikasinya muncul karena alasan keamanan dan keleluasaan fitur
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(
                CHANNEL_ID,
                "pushnotification",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        // Membuat builder notifikasi
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