package com.example.karidmarket.presentation.login.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.login.di.DaggerLoginComponent
import com.example.karidmarket.presentation.login.viewmodel.LoginViewModel
import com.example.karidmarket.presentation.login.viewmodel.LoginViewModelFactory
import okhttp3.internal.notify
import javax.inject.Inject


class LoginFragment : Fragment() {

    @Inject
    lateinit var factory: LoginViewModelFactory

    private var modelView: LoginViewModel? = null

    private var username: EditText? = null
    private var password: EditText? = null
    private var loginBtn: Button? = null
    private var getSignUp: TextView? = null

    val PREF_NAME = "userPref"
    var sharedPrefUser: SharedPreferences? = null
    var editor:SharedPreferences.Editor ?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponent()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectViewModel()
        setUpViewModel()
    }

    private fun setUpViewModel() {
        modelView = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    private fun injectViewModel() {
        DaggerLoginComponent.builder().appComponent(App().appComponent)
            .roomDbModule(RoomDbModule(requireContext())).build().inject(this)
    }

    private fun setUpComponent() {
        setBottomMenuVisibilityForFragment()
        setUpView()
        setUpSharedPreferences()
        subscribeLogin()
        getSignUp()
    }

    @SuppressLint("CommitPrefEdits")
    private fun setUpSharedPreferences() {
        sharedPrefUser = activity?.getSharedPreferences(PREF_NAME, 0)
        editor = sharedPrefUser?.edit()
    }



    private fun subscribeLogin() {
        loginBtn?.setOnClickListener {

            modelView?.getLogin(username?.text.toString(), password?.text.toString())

            modelView?.loginUserLiveData?.observe(viewLifecycleOwner, { result ->
                when (result.state) {
                    LoginViewModel.State.LOADING_DATA -> {
                    }
                    LoginViewModel.State.DATA_LOADED -> {
                        result.response?.id?.let { it1 -> editor?.putInt("id", it1) }
                        findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
                    }
                    LoginViewModel.State.LOAD_ERROR -> {
                    }
                }
            }
            )
        }
    }

    private fun getSignUp() {
        getSignUp?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun setUpView() {
        username = view?.findViewById(R.id.loginFragmentUsername)
        password = view?.findViewById(R.id.loginFragmentPassword)
        loginBtn = view?.findViewById(R.id.loginFragmentLoginBtn)
        getSignUp = view?.findViewById(R.id.loginFragmentSignUp)
    }

    private fun setBottomMenuVisibilityForFragment() {
        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }
}