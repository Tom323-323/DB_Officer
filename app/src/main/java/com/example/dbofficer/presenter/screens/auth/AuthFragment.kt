package com.example.dbofficer.presenter.screens.auth

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.dbofficer.R
import com.example.dbofficer.databinding.FragmentAuthBinding
import com.example.dbofficer.domain.model.AuthModel
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
            vm.signIn(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))

            vm.accountCreationResult.observe(viewLifecycleOwner){
                if(it){
                    createAlertDialog("Account login performed!",it)
                    Log.d("AAA","true - $it")
                } else {
                    createAlertDialog("Account login failed!",it)
                    Log.d("AAA","false - $it")
                }
            }
        }
        binding.btnRegistr.setOnClickListener {
            vm.creteNewUser(AuthModel(binding.etIdNumber.text.toString(), binding.etPassword.text.toString()))
            createAlertDialog("Registration completed successfully!",true)
        }
    }
    private fun createAlertDialog(text: String, result:Boolean){
        if(result){
            val view = View.inflate(requireActivity(),R.layout.dialog_aler_is_done,null)
            val builder = AlertDialog.Builder(requireActivity()).apply { setView(view) }
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val textView = dialog.findViewById<TextView>(R.id.dialog_text)
            val btn_ok = dialog.findViewById<Button>(R.id.btn_ok)
            textView.text = text
            btn_ok.setOnClickListener {
                dialog.dismiss()
                findNavController().navigate(R.id.mainFragment)
                dialog.dismiss()
            }
            Log.d("AAA","true")
        }else{
            val view = View.inflate(requireActivity(),R.layout.dialog_alert_error,null)
            val builder = AlertDialog.Builder(requireActivity()).apply { setView(view) }
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val textView = dialog.findViewById<TextView>(R.id.dialog_text)
            val btn_ok = dialog.findViewById<Button>(R.id.btn_ok)
            textView.text = text
            btn_ok.setOnClickListener {
                dialog.dismiss()
            }
            Log.d("AAA","false")
        }
    }
}


