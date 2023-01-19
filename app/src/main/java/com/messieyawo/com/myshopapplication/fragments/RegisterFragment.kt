package com.messieyawo.com.myshopapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.messieyawo.com.myshopapplication.data.User
import com.messieyawo.com.myshopapplication.databinding.FragmentRegisterBinding
import com.messieyawo.com.myshopapplication.resource.Resource
import com.messieyawo.com.myshopapplication.utils.RegisterValidation
import com.messieyawo.com.myshopapplication.viewmodel.RegisterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext


class RegisterFragment:Fragment() {
private lateinit var binding:FragmentRegisterBinding
private val viewmodel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRegister.setOnClickListener {
                val user = User(
                    edFirstName.text.toString().trim(),
                    edLastName.text.toString().trim(),
                    edEmail.text.toString().trim()
                )

                val password = edPassword.text.toString()
                viewmodel.createAccountWithEmailAndPassword(user,password)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewmodel.register.collect {
                when (it){
                    is Resource.Loading -> {
                        binding.btnRegister.startAnimation()
                    }
                    is Resource.Success -> {
                        Log.d("Test",it.data.toString())
                        binding.btnRegister.revertAnimation()
                    }
                    is Resource.Error -> {
                        Log.d("Test",it.message.toString())
                        binding.btnRegister.revertAnimation()
                    }else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewmodel.validation.collect {validation ->
                if (validation.email is RegisterValidation.Failed){
                    withContext(Dispatchers.Main){
                        binding.edEmail.apply {
                            requestFocus()
                            error = validation.email.message
                        }
                    }
                }

                if (validation.password is RegisterValidation.Failed){
                    withContext(Dispatchers.Main){
                        binding.edPassword.apply {
                            requestFocus()
                            error = validation.password.message
                        }
                    }
                }
            }
        }
    }
}