package com.example.karidmarket.presentation.menuitem.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.menuitem.di.DaggerMenuItemComponent
import com.example.karidmarket.presentation.menuitem.viewmodel.MenuItemViewModel
import com.example.karidmarket.presentation.menuitem.viewmodel.MenuItemViewModelFactory
import com.example.karidmarket.presentation.recipes.view.EndlessOnScrollListener
import com.example.karidmarket.presentation.recipes.view.RecipeAdapter
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import kotlinx.android.synthetic.main.fragment_menu_item.*
import javax.inject.Inject


class MenuItemFragment : Fragment() {

    @Inject
    lateinit var menuItemFactory: MenuItemViewModelFactory

    private var menuItemViewModel: MenuItemViewModel? = null

    private var menuItemAdapter: MenuItemAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_menu_item, container, false)


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

    private fun setUpComponent() {
        setUpAdapter()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        menuItemViewModel?.getMenuItem()

        menuItemViewModel?.menuItemLiveData?.observe(viewLifecycleOwner, { result ->
            when (result.state) {

                MenuItemViewModel.State.LOADING_DATA -> {
                    println("-----LOADING DATA -----  ")
                }
                MenuItemViewModel.State.DATA_LOADED -> {
                    result.response.let {
                        it?.let { it1 -> menuItemAdapter?.setItems(it1) }
                    }
                    println("-----LOAD DATA -----  ")
                }
                MenuItemViewModel.State.MORE_DATA_LOADED -> {
                    result.response.let {
                        it?.let { it1 -> menuItemAdapter?.addItems(it1) }
                    }
                    println("-----LOAD MORE DATA -----  ")
                }
                MenuItemViewModel.State.LOAD_ERROR -> {
                    println("-----LOAD ERROR -----  " + result.error)
                }
                MenuItemViewModel.State.LOAD_MORE_ERROR -> {
                    println("-----LOAD MORE DATA -----  " + result.error)
                }
            }
        })

    }

    private fun setUpAdapter() {
        menuItemAdapter = MenuItemAdapter(requireContext())
        // recyclerView = view?.findViewById(R.id.recipeFRecipeRecycle)
        with(menuItemFragmentRecycle) {
            adapter = menuItemAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            this?.addOnScrollListener(object :
                EndlessOnScrollListener(layoutManager as LinearLayoutManager) {
                override fun onLoadMore() {
                    menuItemViewModel?.loadMoreMenuItem()
                }
            })

        }
    }

    private fun setUpViewModel() {
        menuItemViewModel =
            ViewModelProvider(this, menuItemFactory).get(MenuItemViewModel::class.java)
    }

    private fun injectViewModel() {
        DaggerMenuItemComponent.builder().appComponent(App().appComponent).build().inject(this)
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

    private fun setBottomMenuVisibilityForFragment() {
        if (activity is MainActivity) {
            val mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }

}