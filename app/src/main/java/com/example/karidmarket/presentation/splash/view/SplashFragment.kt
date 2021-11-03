package com.example.karidmarket.presentation.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.karidmarket.MainActivity
import com.example.karidmarket.R
import com.example.karidmarket.presentation.network.NetworkAvailability


class SplashFragment : Fragment() {

    private var delayStartMainPage = 2000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpComponent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setBottomMenuVisibilityForFragment()
    }

    override fun onResume() {
        super.onResume()
        setBottomMenuVisibilityForFragment()
    }

    private fun setUpComponent() {

        loadHomePage()
    }

    private fun loadHomePage() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (NetworkAvailability.isNetworkAvailable(requireContext())) {
                startHomePage()
            } else {
                delayStartMainPage = 500
                loadHomePage()
            }
        }, delayStartMainPage)
    }


    private fun startHomePage() {
        val navController = requireView().findNavController()
        if (navController.currentDestination?.id == R.id.splashFragment) {
            navController.navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
    private fun setBottomMenuVisibilityForFragment(){
        if (activity is MainActivity) {
            var  mainActivity = activity as MainActivity
            mainActivity.setBottomNavigationVisibility(View.GONE)
        }
    }
}