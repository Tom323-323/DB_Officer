package com.example.dbofficer.presenter.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbofficer.R
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.data.db.storage.room.OfficerDB
import com.example.dbofficer.databinding.FragmentMainBinding
import com.example.dbofficer.domain.adapter.AdapterOfficer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private  val mainViewModel by viewModel<MainViewModel>()


    private lateinit var officerList: ArrayList<OfficerDataModel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvMain
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        officerList = arrayListOf<OfficerDataModel>()
        getDataFireBase()


//        mainViewModel.data.observe(requireActivity()) {
//                //here update data from ViewModel
//        }

        binding.btnSearch.setOnClickListener {
            val searchOfficerName = binding.etSearch.text.toString()
            if(searchOfficerName.isNotEmpty()){
                searchData(searchOfficerName)
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

    private fun getDataFireBase() {

        mainViewModel.getAllOfficerFromFireBase()


    }

    fun searchData(searchOfficerName: String) {
                mainViewModel.searchOfficer(searchOfficerName)
                binding.etSearch.text.clear()
    }
}



