package com.example.dbofficer.data.db.storage.firebase

import android.app.Activity
import android.content.ContentValues
import android.util.Log
import com.example.dbofficer.data.db.model.AuthModelData
import com.example.dbofficer.data.db.model.OfficerDataModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirebaseUser (private val activity: Activity): UserStorage {

    private lateinit var auth: FirebaseAuth
    private lateinit var realTimeDB: DatabaseReference

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

    override fun createNewOfficerFB(officerDataModel: OfficerDataModel) {
        CoroutineScope(Dispatchers.IO).launch {
            realTimeDB = FirebaseDatabase.getInstance().getReference("Officer")
            realTimeDB.child(officerDataModel.name).setValue(officerDataModel).addOnSuccessListener {
                Log.d("AAA","read FB officer")
            }.addOnFailureListener {
                Log.e("AAA","NOT !!! read FB officer")
            }
        }
    }
}