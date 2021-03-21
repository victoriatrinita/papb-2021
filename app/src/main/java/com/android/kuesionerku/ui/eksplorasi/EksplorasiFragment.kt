package com.android.kuesionerku.ui.eksplorasi

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("EksplorasiFragment", "onAttach invoked")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("EksplorasiFragment", "onCreate invoked")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("EksplorasiFragment", "onViewCreated invoked")
    }

    override fun onStart() {
        super.onStart()
        Log.i("EksplorasiFragment", "onStart invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.i("EksplorasiFragment", "onResume invoked")
    }

    override fun onPause() {
        super.onPause()
        Log.i("EksplorasiFragment", "onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.i("EksplorasiFragment", "onStop invoked")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("EksplorasiFragment", "onDestroyView invoked")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("EksplorasiFragment", "onDetach invoked")
    }

}