package com.example.karidmarket.presentation.generatemeal.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.generatemeal.di.DaggerGenerateMealComponent
import com.example.karidmarket.presentation.generatemeal.model.NutrientsModel
import com.example.karidmarket.presentation.generatemeal.viewmodel.GenerateMealViewModel
import com.example.karidmarket.presentation.generatemeal.viewmodel.GenerateMealViewModelFactory
import com.example.karidmarket.presentation.recipes.view.EndlessOnScrollListener
import com.example.karidmarket.presentation.recipes.view.RecipeAdapter
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import kotlinx.android.synthetic.main.action_bar_generate_meal_plan.view.*
import kotlinx.android.synthetic.main.fragment_generate_meal.*
import javax.inject.Inject

class GenerateMealFragment : Fragment() {

    @Inject
    lateinit var factory: GenerateMealViewModelFactory

    private var generateMealViewModel: GenerateMealViewModel? = null

    private var mealPlanAdapter: GenerateMealPlanAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_generate_meal, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomMenuVisibilityForFragment()
        setUpBackPressed()
        setUpComponent()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectViewModel()
        setUpViewModel()
    }


    private fun setUpViewModel() {
        generateMealViewModel =
            ViewModelProvider(this, factory).get(GenerateMealViewModel::class.java)
    }

    private fun injectViewModel() {
        DaggerGenerateMealComponent.builder().appComponent(App().appComponent).build().inject(this)
    }

    private fun setUpComponent() {
        setUpAdapters()
        setUpSubscribeViewModel()
        setUpSubscribeViewModelRefresh()
        setUpPressBackBtn()
    }

    private fun setUpPressBackBtn() {
        generateMealFragmentActionBar.generateMealPlanBackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_generateMealFragment_to_mealFragment)
        }
    }

    private fun setUpSubscribeViewModel() {
        generateMealViewModel?.getMealPlan("day")

        generateMealViewModel?.mealPlanLiveData?.observe(viewLifecycleOwner, { result ->
            when (result.state) {

                GenerateMealViewModel.State.LOADING_DATA -> {
                    println("111111111111111111111111111")
                    println(result.response?.nutrientsModel?.calories)
                }
                GenerateMealViewModel.State.DATA_LOADED -> {
                    result.response?.mealModels.let {
                        result.response?.mealModels?.forEach {
                            mealPlanAdapter?.setItems(it)
                        }
                    }

                    result.response?.let { it1 -> setUpNutrients(it1.nutrientsModel) }
                    println("222222222222222222222222222")

                }
                GenerateMealViewModel.State.LOAD_ERROR -> {
                    println("3333333333333333333333333333")
                    println(result.error)
                }

            }

        })
    }

    private fun setUpSubscribeViewModelRefresh() {

        generateMealFragmentActionBar.generateMealPlanRefresh?.setOnClickListener {

            generateMealViewModel?.getMealPlan("day")

            generateMealViewModel?.mealPlanLiveData?.observe(viewLifecycleOwner, { result ->
                when (result.state) {

                    GenerateMealViewModel.State.LOADING_DATA -> {
                        println("111111111111111111111111111")
                        println(result.response?.nutrientsModel?.calories)
                    }
                    GenerateMealViewModel.State.DATA_LOADED -> {
                        result.response?.mealModels.let {
                            result.response?.mealModels?.forEach {
                                mealPlanAdapter?.setItems(it)
                            }
                        }

                        result.response?.let { it1 -> setUpNutrients(it1.nutrientsModel) }
                        println("222222222222222222222222222")

                    }
                    GenerateMealViewModel.State.LOAD_ERROR -> {
                        println("3333333333333333333333333333")
                        println(result.error)
                    }

                }

            })

        }
    }

    private fun setUpNutrients(nutrientsModel: NutrientsModel) {
        calories.text = nutrientsModel.calories.toString()
        carbohydrates.text = nutrientsModel.carbohydrates.toString()
        fat.text = nutrientsModel.fat.toString()
        protein.text = nutrientsModel.protein.toString()
    }

    private fun setUpAdapters() {
        mealPlanAdapter = GenerateMealPlanAdapter(requireContext())
        with(generateMealFragmentRecycle) {
            adapter = mealPlanAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        }
    }

    private fun setBottomMenuVisibilityForFragment() {
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }

    private fun setUpBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_generateMealFragment_to_mealFragment)
                }
            }
        )
    }

}