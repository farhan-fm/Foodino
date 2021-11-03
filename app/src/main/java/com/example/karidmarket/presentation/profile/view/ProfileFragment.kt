package com.example.karidmarket.presentation.profile.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : Fragment() {

    private var floatingActionButton: FloatingActionButton? = null
    private var bottomSheetDialog: BottomSheetDialog? = null
    private var bottomSheetSetting: LinearLayout? = null
    private var bottomSheetEditProfile: LinearLayout? = null
    private var bottomSheetLogin: LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpBackPressed()
        setBottomMenuVisibilityForFragment()
        setUpComponent()
    }

    private fun setUpComponent() {
        setUpView()
        setUpBottomSheet()
    }

    private fun setUpView() {
        floatingActionButton = view?.findViewById(R.id.profileFragmentToolbar)
    }

    private fun setUpBottomSheet() {
        floatingActionButton?.setOnClickListener {
            bottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog?.setContentView(R.layout.profile_bottom_sheet)
            bottomSheetDialog?.findViewById<ConstraintLayout>(R.id.bottomSheetContainer)
            bottomSheetDialog?.show()
            setUpBottomSheetComponent()
        }
    }

    private fun setUpBottomSheetComponent() {
        bottomSheetLogin = bottomSheetDialog?.findViewById(R.id.profileFragmentLogin)
        bottomSheetSetting = bottomSheetDialog?.findViewById(R.id.profileFragmentSetting)
        bottomSheetEditProfile = bottomSheetDialog?.findViewById(R.id.profileFragmentEditProfile)
        setUpBottomSheetAction()
    }

    private fun setUpBottomSheetAction() {
        setUpBottomSheetSetting()
        setUpBottomSheetLogin()
        setUpBottomSheetEditProfile()
    }

    private fun setUpBottomSheetEditProfile() {
        bottomSheetEditProfile?.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            bottomSheetDialog?.dismiss()
        }
    }

    private fun setUpBottomSheetLogin() {
        bottomSheetLogin?.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            bottomSheetDialog?.dismiss()
        }
    }

    private fun setUpBottomSheetSetting() {
        bottomSheetSetting?.setOnClickListener {
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