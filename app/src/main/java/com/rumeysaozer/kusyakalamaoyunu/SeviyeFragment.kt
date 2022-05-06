package com.rumeysaozer.kusyakalamaoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentSeviyeBinding

class SeviyeFragment : Fragment() {
    private var _binding: FragmentSeviyeBinding? = null
    private val binding get() = _binding!!
    private var name = "Muhammed"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeviyeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            name = SeviyeFragmentArgs.fromBundle(it).name
        }
        super.onViewCreated(view, savedInstanceState)
        binding.kolay.setOnClickListener {
            val action = SeviyeFragmentDirections.actionSeviyeFragmentToYakalamaFragment(name,1)
            findNavController().navigate(action)

        }
        binding.orta.setOnClickListener {
            val action = SeviyeFragmentDirections.actionSeviyeFragmentToYakalamaFragment(name,2)
            findNavController().navigate(action)
        }
        binding.zor.setOnClickListener {
            val action = SeviyeFragmentDirections.actionSeviyeFragmentToYakalamaFragment(name,3)
            findNavController().navigate(action)
        }

    }


}