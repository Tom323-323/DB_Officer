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
import androidx.core.view.isGone
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
    private lateinit var officerList: List<OfficerModel>

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
                val searchOfficerName = binding.etSearch.text.toString()
                if(searchOfficerName.isNotEmpty()){
                    officerList = searchData(searchOfficerName)
                    adapterManager(officerList)

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
                officerList = getDataFireBase()
                adapterManager(officerList)

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
    private fun searchData(searchOfficerName: String):List<OfficerModel> {
                return mainViewModel.searchOfficer(searchOfficerName)
                binding.etSearch.text.clear()
    }
    private fun adapterManager(list: List<OfficerModel>){
        adapterRV = AdapterOfficer(list)
        adapterRV.notifyDataSetChanged()
        recyclerView.adapter = adapterRV
        adapterRV.notifyDataSetChanged()
    }
}





