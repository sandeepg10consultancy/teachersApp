package com.teacherapplication.teacherapplication.ui.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel () : ViewModel(){
    var phoneNumber = mutableStateOf("")
    var password = mutableStateOf("")

    fun loginButton(){
        if (phoneNumber.value.isNotEmpty() && password.value.isNotEmpty()){

        }else{
            phoneNumber.value = ""
            password.value = ""
        }
    }
}