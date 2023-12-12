package com.example.dbofficer.presenter.screens.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.data.db.storage.firebase.FirebaseUser
import com.example.dbofficer.databinding.FragmentAuthBinding
import com.example.dbofficer.domain.model.AuthModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    private val vm by viewModel<AuthViewModel>()


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

            Log.d("AAA",
                CoroutineScope(Dispatchers.IO).launch { vm.signIn(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))+"_fragment" }
                    .toString()
            )
        }

        binding.btnRegistr.setOnClickListener {
            vm.creteNewUser(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))
            Log.d("AAA","")
        }
    }

}


