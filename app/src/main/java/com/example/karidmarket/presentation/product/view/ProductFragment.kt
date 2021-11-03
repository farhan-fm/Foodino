package com.example.karidmarket.presentation.product.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R


class ProductFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBackPressed()
        setBottomMenuVisibilityForFragment()
    }

    private fun setBottomMenuVisibilityForFragment(){
        if (activity is MainActivity) {
            var  mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.VISIBLE)
        }
    }
    private fun setUpBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        )
    }
}