package com.example.dbofficer.presenter.screens.auth
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dbofficer.data.db.repository.firebase.AuthRepositoryImplements
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.databinding.FragmentAuthBinding
import com.example.dbofficer.domain.usecase.CreateUserFirebaseUseCase
import com.example.dbofficer.domain.usecase.SignInFirebaseUseCase
import com.example.dbofficer.domain.model.AuthModel

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    private lateinit var vm:AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(requireActivity(),AuthViewModelFactory(requireActivity()))
            .get(AuthViewModel::class.java)

        binding.btnEnter.setOnClickListener {
            vm.signIn(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))
        }

        binding.btnRegistr.setOnClickListener {
            vm.creteNewUser(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))
        }
    }
}