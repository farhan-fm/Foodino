package com.example.karidmarket.presentation.recipes.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.recipes.di.DaggerRecipeComponent
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelViewFactory
import javax.inject.Inject


class RecipesFragment : Fragment() {

    @Inject
    lateinit var recipeFactory: RecipeModelViewFactory

    private var recipeModelView: RecipeModelView? = null
    private var recipeRecycleAdapter: RecipeAdapter? = null
    var recyclerView:RecyclerView?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectViewModel()
        setUpViewModel()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBackPressed()
        setBottomMenuVisibilityForFragment()
        subscribeRecipe()
        setUpComponent()
    }

    private fun injectViewModel() {
        DaggerRecipeComponent.builder().appComponent(App().appComponent).build().inject(this)
    }

    private fun setUpViewModel() {
        recipeModelView = ViewModelProvider(this, recipeFactory).get(RecipeModelView::class.java)
    }

    private fun setUpComponent() {

        setUpAdapters()
    }


    private fun subscribeRecipe() {
        recipeModelView?.getRecipe()

        recipeModelView?.recipeLiveData?.observe(viewLifecycleOwner, Observer { result ->
            when (result.state) {
                RecipeModelView.State.DATA_LOADED -> {
                    //println(result.response?.cryptoCard?.size)
                    result.response?.otherDetailModel?.let {
                        recipeRecycleAdapter?.setItems(it)
                    }

                }
                RecipeModelView.State.MORE_DATA_LOADED ->{
                    result.response?.otherDetailModel.let {
                        recipeRecycleAdapter?.addItems(it!!)
                    }
                }
            }
        })
    }

    private fun setUpAdapters() {
        recipeRecycleAdapter = RecipeAdapter(requireContext())
        recyclerView = view?.findViewById(R.id.recipeFRecipeRecycle)
        with(recyclerView) {
            this?.adapter = recipeRecycleAdapter
            this?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            this?.addOnScrollListener(object :
                EndlessOnScrollListener(layoutManager as LinearLayoutManager) {
                override fun onLoadMore() {
                    recipeModelView?.loadMoreRecipe()
                }
            })

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