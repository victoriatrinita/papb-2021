package com.android.kuesionerku.ui.profil

import android.content.Context
import android.os.Bundle
import android.util.Log
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

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("ProfilFragment", "onAttach invoked")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ProfilFragment", "onCreate invoked")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("ProfilFragment", "onViewCreated invoked")
    }

    override fun onStart() {
        super.onStart()
        Log.i("ProfilFragment", "onStart invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ProfilFragment", "onResume invoked")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ProfilFragment", "onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ProfilFragment", "onStop invoked")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("ProfilFragment", "onDestroyView invoked")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ProfilFragment", "onDetach invoked")
    }

}