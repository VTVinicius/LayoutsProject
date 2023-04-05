package br.com.vtvinicius.feature_firebase.login

import androidx.lifecycle.ViewModel
import br.com.vtvinicius.base_feature.extensions.useCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.IsUserLoggedUseCase
import br.com.vtvinicius.domain.usecase.shaerdPreferences.SaveUserLoggedUseCase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

class LoginViewModel : ViewModel(), KoinComponent {
    private lateinit var auth: FirebaseAuth

//    private val isUserLoggedUseCase: IsUserLoggedUseCase by useCase()
//    private val saveUserLoggedUseCase: SaveUserLoggedUseCase by useCase()

    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state

    init {
        isUserLogged()
    }

    fun login(email: String, password: String) {

        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isUserLogged()
                } else {
                    isUserLogged()
                }
            }
    }

//
//    private fun saveUserLogged(value: Boolean) {
//        saveUserLoggedUseCase(
//            params = SaveUserLoggedUseCase.Params(value),
//            onSuccess = {
//                isUserLogged()
//            },
//            onError = { error ->
//
//            }
//        )
//
//    }
//

     fun isUserLogged() {
         FirebaseAuth.getInstance().getCurrentUser()?.let {
             _state.update {
                 it.copy(isUserLogged = true)
             }
         } ?: run {
             _state.update {
                 it.copy(isUserLogged = false)
             }
         }
//        isUserLoggedUseCase(
//            params = null,
//            onSuccess = { result ->
//                _state.update {
//                    it.copy(isUserLogged = result ?: false)
//                }
//            },
//            onError = { error ->
//                _state.update {
//                    it.copy(isUserLogged = false)
//                }
//            })
    }
}