package com.example.dbofficer.data.db.storage.firebase

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.example.dbofficer.domain.model.OfficerModel
import com.example.dbofficer.presenter.screens.auth.SingleLiveEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirebaseUser (private val activity: Activity): UserStorage {

    private lateinit var auth: FirebaseAuth
    private lateinit var realTimeDB: DatabaseReference

    override fun signIn(autModelData: AuthModelData,result:SingleLiveEvent<Boolean>){
        Firebase.auth.signInWithEmailAndPassword(autModelData.email, autModelData.password)
            .addOnCompleteListener(activity) { task ->
                   if(task.isSuccessful){
                       Log.d("AAA", "sign:success")
                       result.postValue(true)
                   }else{
                       Log.d("AAA", "sign:failure")
                       result.postValue(false)
                   }
            }
    }

    override fun createUserFireBase(autModelData: AuthModelData,result:SingleLiveEvent<Boolean>) {
        CoroutineScope(Dispatchers.IO).launch{
            auth = Firebase.auth
            auth.createUserWithEmailAndPassword(autModelData.email, autModelData.password)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        result.postValue(true)
                        Log.d("AAA", "createUserWithEmail:success")
                    } else {
                        result.postValue(false)
                        Log.e("AAA", "createUserWithEmail:failure")

                    }
                }
        }
    }

    override fun createNewOfficerFB(officerDataModel: OfficerDataModel,saveResultFB:SingleLiveEvent<Boolean>) {Log.d("AAA","read FB officer")
        CoroutineScope(Dispatchers.IO).launch {
            realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")
            realTimeDB.child(officerDataModel.name!!).setValue(officerDataModel).addOnSuccessListener {
                Log.d("AAA","read FB officer")
                saveResultFB.postValue(true)
            }.addOnFailureListener {
                Log.e("AAA","NOT !!! read FB officer")
                saveResultFB.postValue(false)
            }
        }
    }

    override fun getAllOfficerFB():List<OfficerModel> {
        val officerArray = arrayListOf<OfficerModel>()

        realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")

        realTimeDB.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(officerSnapshot in snapshot.children){
                        val officerFireBase = officerSnapshot.getValue(OfficerModel::class.java)
                        officerArray.add(officerFireBase!!)
                    }
                    Log.d("AAA", officerArray[0].name.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return officerArray
    }

    override fun searchOfficer(nameOfficerSearch: String):List<OfficerModel> {// need add return List<OfficerDataModel> and mapping data!!!!
        val listSearch = arrayListOf<OfficerModel>()

        realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")
        realTimeDB.child(nameOfficerSearch).get().addOnSuccessListener {
            if(it.exists()){
                val nameOfficer = it.child("name").value
                val major = it.child("major").value
                val rank = it.child("rank").value
                val birthDate = it.child("birthDate").value
                Log.d("AAA","${nameOfficer.toString()},${major.toString()},${rank.toString()},${birthDate.toString()}")
                var searchOfficerData = OfficerModel(name = nameOfficer.toString(), major = major.toString(), rank = rank.toString(), birthDate = birthDate.toString())
                listSearch.add(searchOfficerData)
            }else{
                Log.d("AAA","Required Officer not found!!!")
            }

        }.addOnFailureListener {
            Log.d("AAA","!!!!!!ERRORRR!!!!")
        }
        return listSearch
    }

}