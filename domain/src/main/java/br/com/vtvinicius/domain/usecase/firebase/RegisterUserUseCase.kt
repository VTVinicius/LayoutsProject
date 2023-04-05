package br.com.vtvinicius.domain.usecase.firebase

import br.com.vtvinicius.domain.core.UseCase
import br.com.vtvinicius.domain.exception.MissingParamsException
import kotlinx.coroutines.CoroutineScope
//
//
//class RegisterUserUseCase(
//    scope: CoroutineScope,
//) : UseCase<Unit, RegisterUserUseCase.Params>(scope) {
//
//    private lateinit var auth: FirebaseAuth
//
//    override fun run(params: RegisterUserUseCase.Params?) = when {
//        params == null -> throw NullPointerException()
//        params.email.isNullOrEmpty() -> throw MissingParamsException()
//        params.password.isNullOrEmpty() -> throw MissingParamsException()
//        else -> {
//            auth = FirebaseAuth.getInstance()
//            auth.createUserWithEmailAndPassword(params.email, params.password)
//                .addOnCompleteListener { task ->
//                    if (task.isSuccessful) {
//                        Log.d("Register", "createUserWithEmail:success")
//                    } else {
//                        Log.w("Register", "createUserWithEmail:failure", task.exception)
//                    }
//                }
//
//        }
//    }
//
//    data class Params(
//        val email: String,
//        val password: String
//    )
//
//}