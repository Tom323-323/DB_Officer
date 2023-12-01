package com.example.dbofficer.presenter.screens.infoofficer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentInfoOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel

class InfoOfficerFragment : Fragment() {

    private lateinit var binding:FragmentInfoOfficerBinding
    private val args by navArgs<InfoOfficerFragmentArgs>()
    private lateinit var officerData: OfficerModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoOfficerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        officerData = args.data
        Log.d("AAA", "${officerData.name.toString()} + officerInfo")

        binding.btnBackToMain.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
}