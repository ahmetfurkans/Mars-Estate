package com.empedocles.marsestate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.empedocles.marsestate.R
import com.empedocles.marsestate.databinding.FragmentOnBoardingBinding
import com.empedocles.marsestate.util.fromHtml

class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater)
        binding.onBoardingH2.text = getString(R.string.string).fromHtml()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            onBoardingButton.setOnClickListener {
                findNavController().navigate(R.id.action_onBoarding_to_feedFragment)
            }
        }
    }
}