package com.android.kuesionerku.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.R

class ProfilFragment : Fragment() {

    private lateinit var profilViewModel: ProfilViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        profilViewModel =
                ViewModelProvider(this).get(ProfilViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profil, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}