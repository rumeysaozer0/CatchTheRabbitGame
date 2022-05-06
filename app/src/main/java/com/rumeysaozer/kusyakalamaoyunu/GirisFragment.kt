package com.rumeysaozer.kusyakalamaoyunu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentGirisBinding
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentSplashBinding


class GirisFragment : Fragment() {
    private var _binding: FragmentGirisBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGirisBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.basla.setOnClickListener {
            if(binding.editText.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Lütfen isminizi giriniz...", Toast.LENGTH_LONG).show()
            }
            val action = GirisFragmentDirections.actionGirisFragment2ToSeviyeFragment(binding.editText.text.toString())
            findNavController().navigate(action)
        }
    }

}