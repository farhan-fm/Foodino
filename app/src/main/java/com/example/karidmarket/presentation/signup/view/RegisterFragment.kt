package com.example.karidmarket.presentation.signup.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.login.viewmodel.LoginViewModel
import com.example.karidmarket.presentation.signup.di.DaggerRegisterComponent
import com.example.karidmarket.presentation.signup.model.UserModel
import com.example.karidmarket.presentation.signup.viewmodel.RegisterViewModel
import com.example.karidmarket.presentation.signup.viewmodel.RegisterViewModelFactory
import javax.inject.Inject


class RegisterFragment : Fragment() {

    @Inject
    lateinit var factory: RegisterViewModelFactory

    private var registerViewModel: RegisterViewModel? = null

    private var username: EditText? = null
    private var password: EditText? = null
    private var reEnterPassword: EditText? = null
    private var fullName: EditText? = null
    private var registerBtn: Button? = null
    private var userModel: UserModel? = null

    val PREF_NAME = "userPref"
    var sharedPrefUser: SharedPreferences? = null
    var editor: SharedPreferences.Editor ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_regiter, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpComponent()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectViewModel()
        setUpViewModel()
    }

    private fun setUpComponent() {
        setBottomMenuVisibilityForFragment()
        setUpView()
        setUpSharedPreferences()
        getRegistering()

    }
    @SuppressLint("CommitPrefEdits")
    private fun setUpSharedPreferences() {
        sharedPrefUser = activity?.getSharedPreferences(PREF_NAME, 0)
        editor = sharedPrefUser?.edit()
    }


    private fun setUpView() {
        username = view?.findViewById(R.id.signUpFragmentUsername)
        password = view?.findViewById(R.id.signUpFragmentPassword)
        reEnterPassword = view?.findViewById(R.id.signUpFragmentRePassword)
        fullName = view?.findViewById(R.id.signUpFragmentFullName)
        registerBtn = view?.findViewById(R.id.signUpFragmentSignUpBtn)
    }

    private fun getRegistering() {
        registerBtn?.setOnClickListener {
            if (checkInputValidation()) {

                userModel = UserModel(
                    null,
                    fullName?.text.toString(),
                    username?.text.toString(),
                    password?.text.toString()
                )
                userModel?.let { it1 -> subscribeRegisterViewModel(it1) }
            }
        }
    }

    private fun checkInputValidation(): Boolean {
        var condition: Int = 0
        if (password?.text.toString() == reEnterPassword?.text.toString()) {
            condition + 1
        } else {
            dialogMassage("Password confirmation is incorrect !")
        }
        if (!(TextUtils.isEmpty(username?.text)
                    && TextUtils.isEmpty(password?.text)
                    && TextUtils.isEmpty(reEnterPassword?.text))
        ) {
            condition + 1
        } else {
            dialogMassage("Complete your information")
        }
        if (TextUtils.isEmpty(username?.text) && !TextUtils.isEmpty(password?.text)
            && !TextUtils.isEmpty(reEnterPassword?.text)
        ) {
            dialogMassage("Username filed should not be empty !")
        }
        if (!TextUtils.isEmpty(username?.text) && TextUtils.isEmpty(password?.text)
            && !TextUtils.isEmpty(reEnterPassword?.text)
        ) {
            dialogMassage("password filed should not be empty !")
        }
        if (!TextUtils.isEmpty(username?.text) && !TextUtils.isEmpty(password?.text)
            && TextUtils.isEmpty(reEnterPassword?.text)
        ) {
            dialogMassage("Please do confirmation your password !")
        }
        if (password?.text?.length!! >= 6) {
            condition + 1
        } else {
            dialogMassage("Password must be more than 6 digit")
        }

        if (condition == 3)
            return true
        return false

    }

    private fun dialogMassage(dialogMassage: String) {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("Error")
        dialog.setIcon(R.drawable.ic_error)
        dialog.setMessage(dialogMassage)
        dialog.setPositiveButton("Ok", null)
        dialog.show()

    }


    private fun subscribeRegisterViewModel(userModel: UserModel) {

        registerViewModel?.getRegistering(userModel)

        registerViewModel?.registerLiveData?.observe(viewLifecycleOwner, { result ->
            when (result.state) {
                RegisterViewModel.State.LOADING_DATA -> {
                }
                RegisterViewModel.State.DATA_LOADED -> {
                    result.response?.let { editor?.putInt("id", it.toInt()) }
                    findNavController().navigate(R.id.action_registerFragment_to_profileFragment)
                }
                RegisterViewModel.State.LOAD_ERROR -> {
                }
            }
        }
        )
    }

    private fun setUpViewModel() {
        registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
    }

    private fun injectViewModel() {
        DaggerRegisterComponent.builder().appComponent(App().appComponent)
            .roomDbModule(RoomDbModule(requireContext())).build().inject(this)
    }

    private fun setBottomMenuVisibilityForFragment() {
        if (activity is MainActivity) {
            var mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }

}