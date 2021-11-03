package com.example.karidmarket.presentation.meal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MealFragment : Fragment() {

    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.rotate_close_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.to_bottom_anim
        )
    }

    private var mealFragmentMore: FloatingActionButton? = null
    private var mealFragmentMenuItemInfo: FloatingActionButton? = null
    private var mealFragmentMealPlan: FloatingActionButton? = null
    private var mealFragmentIngredientCompute: FloatingActionButton? = null

    private var clicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpBackPressed()
        setBottomMenuVisibilityForFragment()
        setUpComponent()
    }

    private fun setUpView() {
        mealFragmentMore = view?.findViewById(R.id.mealFragmentMore)
        mealFragmentMenuItemInfo = view?.findViewById(R.id.mealFragmentMenuItemInfo)
        mealFragmentMealPlan = view?.findViewById(R.id.mealFragmentMealPlan)
        mealFragmentIngredientCompute = view?.findViewById(R.id.mealFragmentIngredientCompute)
    }

    private fun setUpComponent() {
        setUpFloatButton()
        setUpMealGenerate()
        setUpMenuItem()
    }

    private fun setUpMenuItem() {
        mealFragmentMenuItemInfo?.setOnClickListener {

            findNavController().navigate(R.id.action_mealFragment_to_menuItemFragment)
        }
    }

    private fun setUpMealGenerate() {
        mealFragmentMealPlan?.setOnClickListener {
            findNavController().navigate(R.id.action_mealFragment_to_generateMealFragment)
        }
    }

    private fun setUpFloatButton() {
        mealFragmentMore?.setOnClickListener {
            setMainFloatButton()
        }
    }

    private fun setMainFloatButton() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = clicked != true
        //clicked != clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            mealFragmentMenuItemInfo?.visibility = View.VISIBLE
            mealFragmentMealPlan?.visibility = View.VISIBLE
            mealFragmentIngredientCompute?.visibility = View.VISIBLE
        } else {
            mealFragmentMenuItemInfo?.visibility = View.GONE
            mealFragmentMealPlan?.visibility = View.GONE
            mealFragmentIngredientCompute?.visibility = View.GONE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            mealFragmentMenuItemInfo?.startAnimation(fromBottom)
            mealFragmentMealPlan?.startAnimation(fromBottom)
            mealFragmentIngredientCompute?.startAnimation(fromBottom)
            mealFragmentMore?.startAnimation(rotateOpen)
        } else {
            mealFragmentMenuItemInfo?.startAnimation(toBottom)
            mealFragmentMealPlan?.startAnimation(toBottom)
            mealFragmentIngredientCompute?.startAnimation(toBottom)
            mealFragmentMore?.startAnimation(rotateClose)
        }
    }

    private fun setBottomMenuVisibilityForFragment() {
        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
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