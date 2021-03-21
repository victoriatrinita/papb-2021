package com.android.kuesionerku.ui.beranda

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.R
import android.util.Log


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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("BerandaFragment", "onAttach invoked")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("BerandaFragment", "onCreate invoked")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("BerandaFragment", "onViewCreated invoked")
    }

    override fun onStart() {
        super.onStart()
        Log.i("BerandaFragment", "onStart invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.i("BerandaFragment", "onResume invoked")
    }

    override fun onPause() {
        super.onPause()
        Log.i("BerandaFragment", "onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.i("BerandaFragment", "onStop invoked")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("BerandaFragment", "onDestroyView invoked")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("BerandaFragment", "onDetach invoked")
    }

}
