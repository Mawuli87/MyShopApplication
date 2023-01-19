package com.messieyawo.com.myshopapplication.utils

import android.util.Patterns
import java.util.regex.Pattern

fun validateEmail(email:String): RegisterValidation {
    if(email.isEmpty())
        return RegisterValidation.Failed("Email Cannot be empty")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("Wrong email format")

    return RegisterValidation.Success

}

fun validatePassword(password:String):RegisterValidation{
    if (password.isEmpty())
        return RegisterValidation.Failed("Password connot be empty")

    if (password.length < 6)
        return RegisterValidation.Failed("Password should contains 6 char")
    return RegisterValidation.Success
}