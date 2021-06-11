package com.android.kuesionerku

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.kuesionerku.Model.Kuesioner
import com.google.firebase.messaging.FirebaseMessagingService
import kotlinx.android.synthetic.main.fragment_beranda.*


class BerandaActivity : AppCompatActivity(), IKuesionerView {

    var title = ""
    var message = ""

    // Print out token jika diperbarui
    class PushNotificationManager : FirebaseMessagingService() {
        var MT: String? = null
        override fun onNewToken(token: String) {
            super.onNewToken(token)
            MT = token
            println("Refreshed token: $token")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_beranda)

        KuesionerPresenter(this).getDataFromApi()

        if (intent.extras != null) {
            for (key in intent.extras!!.keySet()) {
                if (key == "title") {
                    title = intent.extras!!.getString("title", "")
                }
                if (key == "message") {
                    message = intent.extras!!.getString("message", "")
                }
            }
        }
        tag_one.text = title
        tag_two.text = message
    }

    override fun onDataCompleteFromApi(kuesioner: Kuesioner) {
        val judul: TextView = findViewById(R.id.tvberandakuesionerjudul)
        val akses: TextView = findViewById(R.id.tvberandakuesionerakses)
        val kategori: TextView = findViewById(R.id.tvberandakuesionerkategori)
        val tanggal: TextView = findViewById(R.id.tvberandakuesionertanggal)
        val saldo: TextView = findViewById(R.id.tvberandakuesionersaldo)

        judul.text = kuesioner.judul
        akses.text = kuesioner.akses
        kategori.text = kuesioner.kategori
        tanggal.text = kuesioner.tanggal
        saldo.text = kuesioner.saldo
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error --> ${throwable.localizedMessage}")
    }
}