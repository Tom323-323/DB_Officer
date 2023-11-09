package com.example.dbofficer.presenter.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbofficer.R
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.room.OfficerDB
import com.example.dbofficer.databinding.FragmentMainBinding
import com.example.dbofficer.domain.adapter.AdapterOfficer
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var realTimeDB: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvMain
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val db = OfficerDB.getDB(context = requireContext())

        mainViewModel.data.observe(requireActivity()) {
                //here update data from ViewModel
        }

        binding.btnSearch.setOnClickListener {
            val searchOfficerName = binding.etSearch.text
            if(searchOfficerName.isNotEmpty()){
                readData(searchOfficerName)
            }else{
                Toast.makeText(requireContext(),"Need enter Name Officer!!!",Toast.LENGTH_LONG).show()
            }

//            db.getDao().searchOfficer().asLiveData().observe(viewLifecycleOwner){
//                recyclerView.adapter = AdapterOfficer(it)
//            }// !!!!!!!!!!!!!! This is search in Room data base!!!!!!!!!!!!
        }

        binding.btnAddNewOfficer.setOnClickListener {
            findNavController().navigate(R.id.newOfficerFragment)
        }


    }

    private fun readData(searchOfficerName: String) {
        realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")
        realTimeDB.child(searchOfficerName).get().addOnSuccessListener {
            if(it.exists()){
                val nameOfficer = it.child("name").value
                val major = it.child("major")
                val rank = it.child("rank")
                val birthDate = it.child("birthDate")
                Toast.makeText(requireContext(),"Done!",Toast.LENGTH_LONG).show()
                binding.etSearch.text.clear()
            }else{
                Toast.makeText(requireContext(),"User doest not exist",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(),"Error!!!",Toast.LENGTH_LONG).show()
        }
    }
}



