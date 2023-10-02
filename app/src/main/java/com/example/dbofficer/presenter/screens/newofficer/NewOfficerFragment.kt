package com.example.dbofficer.presenter.screens.newofficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.data.db.OfficerDB
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel
import kotlinx.coroutines.DelicateCoroutinesApi


class NewOfficerFragment : Fragment() {

    private lateinit var binding: FragmentNewOfficerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewOfficerBinding.inflate(inflater,container,false)
        return binding.root
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = OfficerDB.getDB(context = requireContext())

        binding.btnSave.setOnClickListener {
            val newOfficer = OfficerModel(
                id = null,
                binding.etName.text.toString(),
                binding.etRank.text.toString(),
                binding.etYearsInSystem.text.toString(),
                binding.etRank.text.toString()
            )

           Thread{
               db.getDao().addOfficer(officerModel = newOfficer)
           }.start()



        }
    }
}