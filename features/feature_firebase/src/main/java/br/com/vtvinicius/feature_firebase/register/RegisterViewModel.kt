package br.com.vtvinicius.feature_firebase.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.core.component.KoinComponent

class RegisterViewModel : ViewModel(), KoinComponent {


    private lateinit var auth: FirebaseAuth

    fun register(email: String, password: String) {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Register", "createUserWithEmail:success")
                } else {
                    Log.w("Register", "createUserWithEmail:failure", task.exception)
                }
            }
    }
}