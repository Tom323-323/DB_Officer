package com.example.dbofficer.presenter.screens.main

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentMainBinding
import com.example.dbofficer.domain.adapter.AdapterOfficer
import com.example.dbofficer.domain.model.OfficerModel
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

        recyclerView = binding.rvMain
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.apply {
            btnSearch.setOnClickListener {

                val searchOfficerName = etSearch.text.toString()
                if(searchOfficerName.isNotEmpty()){
                    val officerList = searchData(searchOfficerName)
                    adapterRV = AdapterOfficer(officerList)
                    recyclerView.adapter = adapterRV

                    etSearch.text.clear()

                    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?//hide keyboard
                    imm?.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)//hide keyboard

                    adapterRV.onItemClick ={
                        Log.d("AAA", it.name.toString())
                        val direction = MainFragmentDirections.actionMainFragmentToInfoOficcerFragment(it)
                        findNavController().navigate(direction)
                    }
                }else{
                    Toast.makeText(requireContext(),"Need enter Name Officer!!!",Toast.LENGTH_LONG).show()
                }
            }

            btnAddNewOfficer.setOnClickListener {
                findNavController().navigate(R.id.newOfficerFragment)
            }

            btnGetAllOfficer.setOnClickListener {
                val listOfficer = getDataFireBase()
                adapterManager(listOfficer)

                adapterRV.onItemClick ={
                    val direction = MainFragmentDirections.actionMainFragmentToInfoOficcerFragment(it)
                    findNavController().navigate(direction)
                }
            }
        }
    }
    private fun getDataFireBase():List<OfficerModel> {
        return mainViewModel.getAllOfficerFromFireBase()
    }
    private fun searchData(searchOfficerName: String):MutableList<OfficerModel> {
                return mainViewModel.searchOfficer(searchOfficerName)

    }
    private fun adapterManager(list: List<OfficerModel>){
        adapterRV = AdapterOfficer(list)
        recyclerView.adapter = adapterRV
    }
}





