package com.example.karidmarket.presentation.editprofile.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.app.App
import com.example.karidmarket.presentation.app.RoomDbModule
import com.example.karidmarket.presentation.editprofile.di.DaggerEditProfileComponent
import com.example.karidmarket.presentation.editprofile.model.UserModel
import com.example.karidmarket.presentation.editprofile.viewmodel.EditProfileViewModel
import com.example.karidmarket.presentation.editprofile.viewmodel.EditProfileViewModelFactory
import javax.inject.Inject


class EditProfileFragment : Fragment() {

    @Inject
    lateinit var factory: EditProfileViewModelFactory

    private var editProfileViewModel: EditProfileViewModel? = null

    private var backBtn: ImageButton? = null
    private var submitChangeProfile: ImageButton? = null
    private var userName: EditText? = null
    private var fullName: EditText? = null
    private var setPass: TextView? = null
    private var actionBar: ConstraintLayout? = null
    private var ID : Int ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_edit_profile, container, false)

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
        editProfileViewModel =
            ViewModelProvider(this, factory).get(EditProfileViewModel::class.java)
    }

    private fun injectViewModel() {
        DaggerEditProfileComponent.builder().appComponent(App().appComponent)
            .roomDbModule(
                RoomDbModule(requireContext())
            ).build().inject(this)
    }

    private fun setUpComponent() {
        getUserFromSharedPref()
        setUpView()
        setUpActionBar()
    }

    private fun setUpView() {
        userName = view?.findViewById(R.id.editProfileFragmentUsername)
        fullName = view?.findViewById(R.id.editProfileFragmentName)
        setPass = view?.findViewById(R.id.editProfileFragmentChangePass)
        backBtn = view?.findViewById(R.id.editProfileBackBtn)
        submitChangeProfile = view?.findViewById(R.id.editProfileSubmitBtn)
    }

    private fun setUpActionBar() {
        setUpBackButtonAction()
        setUpSubmitButtonAction()
    }

    private fun setUpSubmitButtonAction() {
        submitChangeProfile?.setOnClickListener {
            subscribeViewModel(fullName?.text.toString(), userName?.text.toString())
        }
    }

    private fun setUpBackButtonAction() {
        backBtn?.setOnClickListener {
            requireActivity().onBackPressed()
            Toast.makeText(requireContext(), "aaa", Toast.LENGTH_SHORT).show()
        }

    }

    private fun subscribeViewModel(name: String, userName: String) {
        editProfileViewModel?.getEditProfile(UserModel(ID, name, userName, null))

        editProfileViewModel?.editProfileLiveData?.observe(viewLifecycleOwner, { result ->

            when (result.state) {
                EditProfileViewModel.State.DATA_LOADED -> {

                }
                EditProfileViewModel.State.LOAD_ERROR -> {

                }
                EditProfileViewModel.State.LOADING_DATA -> {
                    findNavController().navigate(R.id.action_editProfileFragment_to_profileFragment)
                }
            }

        })

    }
    private fun getUserFromSharedPref(){
        if (activity is MainActivity) {
            var  mainActivity = activity as MainActivity
            ID = mainActivity.getSharedPreferences()
        }
    }
}
