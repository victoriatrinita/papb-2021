package com.android.kuesionerku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.ui.eksplorasi.EksplorasiViewModel

class BuatKuesionerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buat_kuesioner, container, false)
    }
//    setupActionBarWithNavController(findNavController(R.id.fragment))
}