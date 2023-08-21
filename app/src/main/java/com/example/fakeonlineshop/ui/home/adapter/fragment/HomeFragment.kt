package com.example.fakeonlineshop.ui.home.adapter.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.fakeonlineshop.databinding.FragmentHomeBinding
import com.example.fakeonlineshop.ui.home.adapter.GetProductAdapter
import com.example.fakeonlineshop.utils.Status
import com.example.fakeonlineshop.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel.getProducts()

        mainViewModelInit()

        return binding.root
    }

    private fun mainViewModelInit() {
        viewModel.getProduct.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {

                }

                Status.SUCCESS -> {
                    binding.rv.visibility = View.VISIBLE

                    val getProductAdapter = GetProductAdapter(it.data!!)
                    binding.rv.adapter = getProductAdapter
                }

                Status.ERROR -> {
                    Toast.makeText(requireContext(), "Error!!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }


}