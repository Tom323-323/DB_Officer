package com.example.dbofficer.presenter.screens.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dbofficer.databinding.FragmentAuthBinding
import kotlinx.android.synthetic.main.fragment_auth.btn_enter
import kotlinx.android.synthetic.main.fragment_auth.et_id_number
import kotlinx.android.synthetic.main.fragment_auth.et_password


class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id_number = et_id_number.text.toString()
        val password = et_password.text.toString()

        btn_enter.setOnClickListener {

        }
    }



}