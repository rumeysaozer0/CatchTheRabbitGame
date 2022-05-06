package com.rumeysaozer.kusyakalamaoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentGirisBinding
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentLastBinding


class LastFragment : Fragment() {
    private var _binding: FragmentLastBinding? = null
    private val binding get() = _binding!!
    private var name = "Muhammed"
    private var skor = 1
    private var mid = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLastBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            name = LastFragmentArgs.fromBundle(it).name
            skor = LastFragmentArgs.fromBundle(it).skor
            mid =  LastFragmentArgs.fromBundle(it).mid
        }
        binding.bitir.setOnClickListener {
            val action = LastFragmentDirections.actionLastFragmentToGirisFragment2()
            findNavController().navigate(action)
        }
        binding.oyna.setOnClickListener {
            val action = LastFragmentDirections.actionLastFragmentToYakalamaFragment(name ,mid)
            findNavController().navigate(action)
        }
        binding.seviye.setOnClickListener {
            val action = LastFragmentDirections.actionLastFragmentToSeviyeFragment(name)
            findNavController().navigate(action)
        }
        binding.name.text = name
        binding.score.text = "Skor: ${skor}"

    }


}