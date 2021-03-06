package com.android.kuesionerku.ui.list

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.kuesionerku.R
import com.android.kuesionerku.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment(), ListAdapter.OnItemClickListener {

    // Deklarasi channel notifikasi dan ID notifikasi
    private val CHANNEL_ID = "channel_id_example_01"
    private val notificationId = 101

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.applicationContext;

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Recyclerview
        val adapter = ListAdapter(this)
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModels
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        activity?.applicationContext
        createNotificationChannel();

        view.btn_notification.setOnClickListener {
            sendNotification()
        }

        return view

    }

    override fun onItemClick(position: Int, judul: CharSequence) {
        Toast.makeText(requireActivity(), "Item $judul clicked", Toast.LENGTH_SHORT).show()
    }

    // Membuat channel notifikasi
    // Channel notifikasi diwajibkan Sejak API level 26
    // agar notifikasinya muncul karena alasan keamanan dan keleluasaan fitur
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Title"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Mengambil android.app.NotificationManager untuk
            // memberi tahu pengguna event yang terjadi di background
            val notificationManager
                    : NotificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Mengirimkan notifikasi
    private fun sendNotification() {
        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Gabut? Isi kuesioner, dapat duit \uD83E\uDD11 ")
            .setContentText("Ada 3 kuesioner menunggu untuk diisi olehmu!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(requireContext())) {
            notify(notificationId, builder.build())
        }
    }

}