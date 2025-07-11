package com.example.stm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel :ViewModel(){
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onNameUpdate(newName:String){
        _email.value = newName
    }

    fun onPasswordUpdate(newPassword:String){
        _password.value = newPassword
    }

    private val auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val _authState  = MutableLiveData<AuthState>()

    val authState: LiveData<AuthState> = _authState

    init{
        checkAuthStatus()
    }
    fun checkAuthStatus(){
        if(auth.currentUser ==null){
            _authState.value = AuthState.Unauthenticated
        }else{
            _authState.value = AuthState.Authenticated
        }
    }

    fun login(email:String,password:String){
        if(email.isEmpty() ||password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be empty")
        }
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{ task->
                if(task.isSuccessful){
                    _authState.value = AuthState.Authenticated

                }else {
                    _authState.value = AuthState.Error(task.exception?.message?: "Login Error")
                }
            }
    }

    fun signup(email:String,password:String){
        if(email.isEmpty() ||password.isEmpty()){
            _authState.value = AuthState.Error("Email or Password can't be empty")
        }
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{ task->
                if(task.isSuccessful){
                    _authState.value = AuthState.Authenticated

                }else {
                    _authState.value = AuthState.Error(task.exception?.message?: "Sign up Error")
                }
            }
    }

    fun signout(){
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}



sealed class AuthState{
    object Authenticated:AuthState()
    object Unauthenticated:AuthState()
    object Loading :AuthState()

    data class Error(val message: String) :AuthState()
}
