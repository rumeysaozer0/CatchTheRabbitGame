package com.rumeysaozer.kusyakalamaoyunu

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentSplashBinding
import com.rumeysaozer.kusyakalamaoyunu.databinding.FragmentYakalamaBinding
import java.util.*
import kotlin.collections.ArrayList


class YakalamaFragment : Fragment() {
    private var _binding: FragmentYakalamaBinding? = null
    private val binding get() = _binding!!
    private var skor = 0
    private var handler = Handler()
    private var name = "Mahmut"
    private var mid = 1
    private var runnable = Runnable {  }

    var imageArray = ArrayList<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentYakalamaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            name = YakalamaFragmentArgs.fromBundle(it).name
            mid = YakalamaFragmentArgs.fromBundle(it).mid

        }

        imageArray.add(binding.imageView)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        gizle()




        object : CountDownTimer(30000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.sure.text = "Süre: " + millisUntilFinished/1000
            }

            override fun onFinish() {
                binding.sure.text = "Süre: 0"
                handler.removeCallbacks(runnable)
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val action = YakalamaFragmentDirections.actionYakalamaFragmentToLastFragment3(name, skor, mid)
                findNavController().navigate(action)
            }

        }.start()


        binding.imageView.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }

        binding.imageView.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }

        binding.imageView2.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView3.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView4.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView5.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView6.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView7.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView8.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
        binding.imageView9.setOnClickListener {
            skor = skor +1
            binding.skor.text = "Skor: $skor"
        }
    }

    fun gizle(){

        runnable = object : Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE
                if(mid == 1){
                    handler.postDelayed(runnable,
                        500)
                }
                if(mid == 2){
                    handler.postDelayed(runnable,
                        300)
                }
                if(mid == 3){
                    handler.postDelayed(runnable,
                        100)
                }
            }
        }

        handler.post(runnable)



    }


}