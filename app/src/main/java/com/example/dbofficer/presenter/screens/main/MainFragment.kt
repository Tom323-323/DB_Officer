package com.example.dbofficer.presenter.screens.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbofficer.R
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.databinding.FragmentMainBinding
import com.example.dbofficer.domain.adapter.AdapterOfficer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel by viewModel<MainViewModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterRV: AdapterOfficer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfficer = getDataFireBase()// THIS FUN GET ALL OFFICER FROM FIRE BASE
        recyclerView = binding.rvMain
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.btnSearch.setOnClickListener {
            adapterRV = AdapterOfficer(listOfficer)
            recyclerView.adapter = adapterRV
            Log.d("aaa", listOfficer[0].rank.toString())

//            val searchOfficerName = binding.etSearch.text.toString()
//            if(searchOfficerName.isNotEmpty()){
//                val officerList = searchData(searchOfficerName)
//                adapterRV = AdapterOfficer(officerList)
//            }else{
//                Toast.makeText(requireContext(),"Need enter Name Officer!!!",Toast.LENGTH_LONG).show()
//            }

            adapterRV.onItemClick ={
                Log.d("AAA", it.name.toString())
                findNavController().navigate(R.id.infoOficcerFragment)
            }
        }

        binding.btnAddNewOfficer.setOnClickListener {
            findNavController().navigate(R.id.newOfficerFragment)
        }


    }

    private fun getDataFireBase():List<OfficerDataModel> {
        return mainViewModel.getAllOfficerFromFireBase()
    }

    private fun searchData(searchOfficerName: String):List<OfficerDataModel> {
                return mainViewModel.searchOfficer(searchOfficerName)
                binding.etSearch.text.clear()
    }
}



