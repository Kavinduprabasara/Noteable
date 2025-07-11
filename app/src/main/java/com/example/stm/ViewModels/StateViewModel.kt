package com.example.stm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateViewModel : ViewModel() {
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
}