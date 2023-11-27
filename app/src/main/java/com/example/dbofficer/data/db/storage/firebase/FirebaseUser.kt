package com.example.dbofficer.data.db.storage.firebase

import android.app.Activity
import android.content.ContentValues
import android.util.Log
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
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
//    private lateinit var searchOfficerData:OfficerDataModel

    override fun signIn(autModelData: AuthModelData) {
        CoroutineScope(Dispatchers.IO).launch{
            auth = Firebase.auth
            auth.signInWithEmailAndPassword(autModelData.email, autModelData.password)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(ContentValues.TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        //updateUI()//need crate go to next Fragment
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                        //updateUI()//need crate go to next Fragment
                    }
                }
        }
    }

    override fun createUserFireBase(autModelData: AuthModelData) {
        CoroutineScope(Dispatchers.IO).launch{
            auth = Firebase.auth
            auth.createUserWithEmailAndPassword(autModelData.email, autModelData.password)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(ContentValues.TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        //updateUI()//need crate go to next Fragment
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                        //updateUI()//need crate go to next Fragment
                    }
                }
        }
    }

    override fun createNewOfficerFB(officerDataModel: OfficerDataModel) {Log.d("AAA","read FB officer")
        CoroutineScope(Dispatchers.IO).launch {
            realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")
            realTimeDB.child(officerDataModel.name!!).setValue(officerDataModel).addOnSuccessListener {
                Log.d("AAA","read FB officer")
            }.addOnFailureListener {
                Log.e("AAA","NOT !!! read FB officer")
            }
        }
    }

    override fun getAllOfficerFB():List<OfficerDataModel> {
        val officerArray = arrayListOf<OfficerDataModel>()

        realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")

        realTimeDB.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    for(officerSnapshot in snapshot.children){
                        val officerFireBase = officerSnapshot.getValue(OfficerDataModel::class.java)
                        officerArray.add(officerFireBase!!)
                    }
                    Log.d("AAA", officerArray[1].name.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        return officerArray
    }

    override fun searchOfficer(nameOfficerSearch: String):List<OfficerDataModel> {// need add return List<OfficerDataModel> and mapping data!!!!
        val listSearch = arrayListOf<OfficerDataModel>()

        realTimeDB = FirebaseDatabase.getInstance("https://officerdatabase-3dffe-default-rtdb.europe-west1.firebasedatabase.app").getReference("Officer")
        realTimeDB.child(nameOfficerSearch).get().addOnSuccessListener {
            if(it.exists()){
                val nameOfficer = it.child("name").value
                val major = it.child("major").value
                val rank = it.child("rank").value
                val birthDate = it.child("birthDate").value
                Log.d("AAA","${nameOfficer.toString()},${major.toString()},${rank.toString()},${birthDate.toString()}")
                var searchOfficerData = OfficerDataModel(name = nameOfficer.toString(), major = major.toString(), rank = rank.toString(), birthDate = birthDate.toString())
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