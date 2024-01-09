package com.example.dbofficer.presenter.screens.newofficer

import android.app.AlertDialog
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
import com.example.dbofficer.databinding.FragmentNewOfficerBinding
import com.example.dbofficer.domain.model.OfficerModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewOfficerFragment : Fragment() {

    private lateinit var binding: FragmentNewOfficerBinding
    private val vm: NewOfficerViewModel by viewModel<NewOfficerViewModel>()

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
            val context = requireContext()
            vm.createNewOfficer(OfficerModel(
                id = null,
                name = binding.etName.text.toString(),
                major = binding.etRank.text.toString(),
                birthDate = binding.etYearsInSystem.text.toString(),
                rank = binding.etRank.text.toString()
                ),
                context
            )
            vm.accountSaveResult.observe(viewLifecycleOwner){
                if(it){
                    createAlertDialog("Data is saved!",true)
                    Log.d("AAA","true - $it")
                }else{
                    createAlertDialog("Data not saved!",false)
                    Log.d("AAA","false - $it")
                }
            }
            clearEditText()
        }

        binding.btnSaveFireBase.setOnClickListener {
            vm.createNewOfficerFB(OfficerModel(
                id = null,
                name = binding.etName.text.toString(),
                major = binding.etRank.text.toString(),
                birthDate = binding.etYearsInSystem.text.toString(),
                rank = binding.etRank.text.toString()
                )
            )
            clearEditText()
            vm.accountSaveResult.observe(viewLifecycleOwner){
                if(it){
                    createAlertDialog("Data is saved!",true)
                    Log.d("AAA","true - $it")
                }else{
                    createAlertDialog("Data not saved!",false)
                    Log.d("AAA","false - $it")
                }
            }
        }

        binding.btnBackFromNewOfficerFragment.setOnClickListener {
            findNavController().navigate(R.id.mainFragment)
        }
    }
    fun clearEditText(){
        binding.apply {
            etName.text.clear()
            etRank.text.clear()
            etYearsInSystem.text.clear()
            etRank.text.clear()
            etDepartament.text.clear()
            etPosition.text.clear()
            etMoreInfo.text.clear()
            etWeapons.text.clear()
            etySerialNumber.text.clear()
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
            Log.d("AAA","NewOfficer_true")
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
            Log.d("AAA","NewOfficer_false")
        }
    }
}