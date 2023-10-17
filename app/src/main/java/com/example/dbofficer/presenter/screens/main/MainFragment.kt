package com.example.dbofficer.presenter.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbofficer.data.db.storage.room.OfficerDB
import com.example.dbofficer.databinding.FragmentMainBinding
import com.example.dbofficer.domain.adapter.AdapterOfficer


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by viewModels()

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
            db.getDao().searchOfficer().asLiveData().observe(viewLifecycleOwner){
                recyclerView.adapter = AdapterOfficer(it)
            }
        }
    }

}



