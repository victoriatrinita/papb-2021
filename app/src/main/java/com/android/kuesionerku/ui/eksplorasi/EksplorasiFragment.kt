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
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.kuesionerku.R
import com.android.kuesionerku.data.UserViewModel
import com.android.kuesionerku.fragments.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_eksplorasi.view.*

class EksplorasiFragment : Fragment() {

    private lateinit var eksplorasiViewModel: UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_eksplorasi, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        val adapter = ListAdapter()
        val recyclerview = root.rveksplorasi
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        eksplorasiViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)
        eksplorasiViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

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