package com.messieyawo.com.myshopapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.messieyawo.com.myshopapplication.R
import com.messieyawo.com.myshopapplication.databinding.FragmentIntroductionBinding

class IntroductionFragment:Fragment() {
    lateinit var binding: FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroductionBinding.inflate(inflater,container,false)
        return binding.root
    }
}