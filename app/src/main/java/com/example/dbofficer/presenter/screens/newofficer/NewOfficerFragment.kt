package com.example.dbofficer.presenter.screens.newofficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewOfficerFragment : Fragment() {

    private lateinit var binding: FragmentNewOfficerBinding
    private val vm: NewOfficerViewModel by viewModel<NewOfficerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewOfficerBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val context = requireContext()
            vm.createNewOfficer(OfficerModel(
                id = null,
                name = binding.etName.text.toString(),
                major = binding.etRank.text.toString(),
                birthDate = binding.etYearsInSystem.text.toString(),
                rank = binding.etRank.text.toString()
                ),
                context
            )
            clearEditText()
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
            clearEditText()
        }

        binding.btnBackFromNewOfficerFragment.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
    fun clearEditText(){
        binding.etName.text.clear()
        binding.etRank.text.clear()
        binding.etYearsInSystem.text.clear()
        binding.etRank.text.clear()
    }
}