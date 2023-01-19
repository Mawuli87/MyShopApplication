package com.messieyawo.com.myshopapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.messieyawo.com.myshopapplication.R
import com.messieyawo.com.myshopapplication.databinding.FragmentIntroductionBinding
import com.messieyawo.com.myshopapplication.databinding.FragmentLoginBinding

class LoginFragment:Fragment() {
     lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

}