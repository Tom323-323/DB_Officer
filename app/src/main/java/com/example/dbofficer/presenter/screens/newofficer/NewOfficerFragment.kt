package com.example.dbofficer.presenter.screens.newofficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel

class NewOfficerFragment : Fragment() {

    private lateinit var binding: FragmentNewOfficerBinding
    private lateinit var vm: NewOfficerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewOfficerBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(requireActivity(),NewOfficerViewModelFactory(requireActivity())).get(NewOfficerViewModel::class.java)
        binding.btnSave.setOnClickListener {
            vm.createNewOfficer(OfficerModel(
                id = null,
                name = binding.etName.text.toString(),
                major = binding.etRank.text.toString(),
                birthDate = binding.etYearsInSystem.text.toString(),
                rank = binding.etRank.text.toString()
                )
            )
        }

        binding.btnSaveFireBase.setOnClickListener {
            vm.createNewOfficerFB(OfficerModel(
                id = null,
                name = binding.etName.text.toString(),
                major = binding.etRank.text.toString(),
                birthDate = binding.etYearsInSystem.text.toString(),
                rank = binding.etRank.text.toString()
                )
            )
        }

        binding.btnBackFromNewOfficerFragment.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}