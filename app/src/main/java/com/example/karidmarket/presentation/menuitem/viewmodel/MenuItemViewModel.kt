package com.example.karidmarket.presentation.menuitem.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.karidmarket.domain.usecase.GetMenuItemUseCase
import com.example.karidmarket.presentation.menuitem.model.MenuItemResponcesModel
import com.example.karidmarket.presentation.menuitem.model.MenuItemResponseModelMapper
import com.example.karidmarket.presentation.recipes.model.RecipedModel
import com.example.karidmarket.presentation.recipes.viewmodel.RecipeModelView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MenuItemViewModel constructor(
    private val usecase: GetMenuItemUseCase,
    private val mapper: MenuItemResponseModelMapper
) : ViewModel() {

    val menuItemLiveData = MutableLiveData<Result>()
    private val disposables = CompositeDisposable()
    private lateinit var result: Result
    private var currentId = 1

    fun getMenuItem() {
        result = Result(null, State.LOADING_DATA, null)
        menuItemLiveData.value = result

        val param = GetMenuItemUseCase.Param.forGetingMenuItem(currentId++)
        val d: Disposable? = usecase.execute(param)?.subscribe({ data ->
            if (data.id != null) {
                result = Result(mapper.transform(data), State.DATA_LOADED, null)
                menuItemLiveData.value = result
            }
        }, {
            result = Result(null, State.LOAD_ERROR, it.message)
            menuItemLiveData.value = result
        })
        d?.let { disposables.add(it) }
    }

    fun loadMoreMenuItem(){
        if (currentId<=3000){
            result = Result(null, State.MORE_DATA_LOADED, null)
            menuItemLiveData.value = result

            val param = GetMenuItemUseCase.Param.forGetingMenuItem(currentId++)
            val d: Disposable? = usecase.execute(param)?.subscribe({ data ->
                result = Result(mapper.transform(data), State.MORE_DATA_LOADED, null)
                menuItemLiveData.value = result
            }, {
                result = Result(null, State.LOAD_MORE_ERROR, it.message)
                menuItemLiveData.value = result
            })
            d?.let { disposables.add(it) }
        }
    }

    data class Result(
        val response: MenuItemResponcesModel?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        MORE_DATA_LOADED,
        LOAD_ERROR,
        LOAD_MORE_ERROR
    }
}