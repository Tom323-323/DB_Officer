package com.example.dbofficer.presenter.screens.newoficcer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel


class NewOfficerFragment : Fragment() {

    private lateinit var binding: FragmentNewOfficerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentNewOfficerBinding.inflate(inflater,container,false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val newOfficer = OfficerModel(
                id = null,
                binding.etName.text.toString(),
                binding.etRank.text.toString(),
                binding.etYearsInSystem.text.toString(),
                binding.etRank.text.toString()
            )
        }


    }
}