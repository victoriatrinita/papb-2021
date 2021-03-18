package com.android.kuesionerku.ui.beranda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.R

class BerandaFragment : Fragment() {

    private lateinit var berandaViewModel: BerandaViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        berandaViewModel =
                ViewModelProvider(this).get(BerandaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_beranda, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}