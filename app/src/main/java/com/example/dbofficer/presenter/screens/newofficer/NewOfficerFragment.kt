package com.example.dbofficer.presenter.screens.newofficer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.data.db.repository.room.CreateUserRepositoryImplements
import com.example.dbofficer.data.db.storage.room.RoomOfficer
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.domain.usecase.CreateNewOfficerRoom

class NewOfficerFragment : Fragment() {

    private val createNewOfficerRepository by lazy {CreateUserRepositoryImplements(RoomOfficer(requireActivity()))}
    private val createNewOfficerRoom by lazy { CreateNewOfficerRoom(createNewOfficerRepository) }
    private lateinit var binding: FragmentNewOfficerBinding

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
            createNewOfficerRoom.createNewOfficer(OfficerModel(
                id = null,
                binding.etName.text.toString(),
                binding.etRank.text.toString(),
                binding.etYearsInSystem.text.toString(),
                binding.etRank.text.toString())

            )
        }
    }
}