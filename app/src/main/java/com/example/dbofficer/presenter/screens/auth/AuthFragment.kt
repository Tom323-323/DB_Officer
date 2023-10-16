package com.example.dbofficer.presenter.screens.auth
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.data.db.repository.AuthRepositoryImplements
import com.example.dbofficer.data.db.storage.Firebase
import com.example.dbofficer.databinding.FragmentAuthBinding
import com.example.dbofficer.domain.firebase.CreateOfficerFirebaseUseCase
import com.example.dbofficer.domain.firebase.SignInFirebaseUseCase
import com.example.dbofficer.domain.model.AuthModel

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    val authRepository by lazy { AuthRepositoryImplements(Firebase())}
    val signIn by lazy { SignInFirebaseUseCase(authRepository) }
    val createOfficer by lazy { CreateOfficerFirebaseUseCase(authRepository) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnEnter.setOnClickListener {
            signIn.signIn(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()),
                                    requireActivity())
        }

        binding.btnRegistr.setOnClickListener {
            createOfficer.createOfficerFireBase(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()),
                                                requireActivity())
        }
    }
}