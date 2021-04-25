package com.android.kuesionerku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.kuesionerku.model.Kuesioner

class BerandaActivity : AppCompatActivity(), IKuesionerView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_beranda)

        KuesionerPresenter(this).getDataFromApi()
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