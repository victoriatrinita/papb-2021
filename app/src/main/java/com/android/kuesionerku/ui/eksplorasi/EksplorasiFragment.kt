package com.android.kuesionerku.ui.eksplorasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.R

class EksplorasiFragment : Fragment() {

    private lateinit var eksplorasiViewModel: EksplorasiViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        eksplorasiViewModel =
                ViewModelProvider(this).get(EksplorasiViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_eksplorasi, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }
}