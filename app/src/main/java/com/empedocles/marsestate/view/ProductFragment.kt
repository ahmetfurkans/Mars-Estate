package com.empedocles.marsestate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.empedocles.marsestate.databinding.FragmentProductBinding
import com.empedocles.marsestate.model.Estate
import com.empedocles.marsestate.util.circularProgressFactory
import com.empedocles.marsestate.util.downloadFromUrl

class ProductFragment : Fragment() {
    private lateinit var binding: FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(inflater)
        init()
        return binding.root
    }

    // Set data to layout
    // Get data from arguments
    // Set listener to navigate up
    private fun init() {
        val estate = arguments?.getParcelable<Estate>("estate")
        binding.apply {
            binding.estate = estate
            backIcon.setOnClickListener {
                findNavController().navigateUp()
            }
            estate?.let {
                productImg.downloadFromUrl(
                    it.imageUrl,
                    circularProgressFactory(binding.root.context)
                )
            }
        }
    }
}

