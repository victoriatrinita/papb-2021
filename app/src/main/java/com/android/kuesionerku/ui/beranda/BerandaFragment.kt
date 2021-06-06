package com.android.kuesionerku.ui.beranda

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.kuesionerku.R
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.kuesionerku.data.User
import com.android.kuesionerku.data.UserViewModel
import com.android.kuesionerku.fragments.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_beranda.view.*


class BerandaFragment : Fragment(), ListAdapter.OnItemClickListener {
    private lateinit var berandaViewModel: UserViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_beranda, container, false)

        //recyclerview
        val adapter = ListAdapter(this)
        val recyclerview = root.rvberanda
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        berandaViewModel =
            ViewModelProvider(this).get(UserViewModel::class.java)
        berandaViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })


        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onItemClick(position: Int, judul: CharSequence) {
        Toast.makeText(requireActivity(), "Item $judul clicked", Toast.LENGTH_SHORT).show()
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

        val image = ImageView(context)
        image.setImageResource(R.drawable.ic_promo)
        val builderPromo: AlertDialog.Builder = AlertDialog.Builder(context)
        builderPromo.setView(image)
        builderPromo.setMessage("\uD83C\uDF8A PROMO SPESIAL \uD83C\uDF8A")
        builderPromo.setCancelable(true)
        builderPromo.setPositiveButton(
                "OK",
                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() })
        val alertPromo: AlertDialog = builderPromo.create()
        alertPromo.show()
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
