package com.example.dbofficer.presenter.screens.infoofficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentInfoOfficerBinding

class InfoOfficerFragment : Fragment() {

    private lateinit var binding:FragmentInfoOfficerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoOfficerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToMain.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}