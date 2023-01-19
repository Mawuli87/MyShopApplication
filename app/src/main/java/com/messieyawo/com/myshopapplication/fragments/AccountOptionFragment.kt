package com.messieyawo.com.myshopapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.messieyawo.com.myshopapplication.R
import com.messieyawo.com.myshopapplication.databinding.FragmentAccountOptionBinding

class AccountOptionFragment:Fragment() {
    lateinit var binding:FragmentAccountOptionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountOptionBinding.inflate(inflater,container,false)
        return binding.root
    }

}