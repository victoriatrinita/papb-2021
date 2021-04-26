package com.android.kuesionerku.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.kuesionerku.R
import com.android.kuesionerku.data.User
import com.android.kuesionerku.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

      view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase(){
        val judul = addJudul_et.text.toString()
        val akses = addAkses_et.text.toString()
        val kategori = addKategori_et.text.toString()
        val tanggal = addTanggal_et.text.toString()
        val reward = addReward_et.text.toString()

        if(inputCheck(judul, akses, kategori, tanggal, reward)){
            // Create User Object
            val user = User(0, judul, akses, kategori, tanggal, reward)
            // Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(judul: String, akses: String, kategori: String, tanggal: String, reward: String): Boolean {
        return !(TextUtils.isEmpty(judul) && TextUtils.isEmpty(akses) && TextUtils.isEmpty(kategori)
                && TextUtils.isEmpty(tanggal) && TextUtils.isEmpty(reward))
    }
}