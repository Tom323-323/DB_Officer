package com.example.dbofficer.presenter.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbofficer.R
import com.example.dbofficer.data.db.storage.room.OfficerDB
import com.example.dbofficer.databinding.FragmentMainBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private  val mainViewModel by viewModel<MainViewModel>()

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
    fun searchData(searchOfficerName: String) {
                mainViewModel.searchOfficer(searchOfficerName)
                binding.etSearch.text.clear()
    }
}



