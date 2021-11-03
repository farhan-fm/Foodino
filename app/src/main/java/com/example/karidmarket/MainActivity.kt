package com.example.karidmarket

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var bottomNavigationView: BottomNavigationView? = null

    val PREF_NAME = "userPref"
    var sharedPrefUser: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    //var dataBack: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpComponent()
    }

    private fun setUpComponent() {
        setUpBottomNavigationView()
        setUpBottomMenuComponent()
        setUpSharedPreferences()
    }

    private fun setUpBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.mainActivityBottomMenu)
    }

    @SuppressLint("CommitPrefEdits")
    private fun setUpSharedPreferences() {
        sharedPrefUser = getSharedPreferences(PREF_NAME, 0)
        editor = sharedPrefUser?.edit()
    }

    fun setSharedPreferences(id: Int) {
        editor?.putInt("id", id)
        editor?.commit()
    }

    fun getSharedPreferences(): Int {
        var dataBack = getSharedPreferences(PREF_NAME, 0)
        if (dataBack.contains("id"))
            return dataBack.getInt("id", 1)
        return -1
    }

    private fun setUpBottomMenuComponent() {
        bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val currentDestination =
                        findNavController(R.id.navHostFragment).currentDestination?.id
                    currentDestination?.let { toTheHomeFragment(it) }
                }
                R.id.recipe -> {
                    val currentDestination =
                        findNavController(R.id.navHostFragment).currentDestination?.id
                    currentDestination?.let { toTheRecipeFragment(it) }
                }
                R.id.product -> {
                    val currentDestination =
                        findNavController(R.id.navHostFragment).currentDestination?.id
                    currentDestination?.let { toTheProductFragment(it) }

                }
                R.id.meal -> {
                    val currentDestination =
                        findNavController(R.id.navHostFragment).currentDestination?.id
                    currentDestination?.let { toTheMealFragment(it) }

                }
                R.id.profile -> {
                    val currentDestination =
                        findNavController(R.id.navHostFragment).currentDestination?.id
                    currentDestination?.let { toTheProfileFragment(it) }
                }
            }
            true
        }
    }

    private fun toTheProfileFragment(it: Int) {
        when (it) {
            R.id.homeFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_homeFragment_to_profileFragment)
            }
            R.id.recipesFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_recipesFragment_to_profileFragment)
            }
            R.id.productFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_productFragment_to_profileFragment)
            }
            R.id.mealFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_mealFragment_to_profileFragment)
            }

        }

    }

    private fun toTheMealFragment(it: Int) {
        when (it) {
            R.id.homeFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_homeFragment_to_mealFragment)
            }
            R.id.recipesFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_recipesFragment_to_mealFragment)
            }
            R.id.productFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_productFragment_to_mealFragment)
            }
            R.id.profileFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_profileFragment_to_mealFragment)
            }

        }
    }

    private fun toTheProductFragment(it: Int) {
        when (it) {
            R.id.homeFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_homeFragment_to_productFragment)
            }
            R.id.recipesFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_recipesFragment_to_productFragment)
            }
            R.id.mealFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_mealFragment_to_productFragment)
            }
            R.id.profileFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_profileFragment_to_productFragment)
            }

        }
    }

    private fun toTheRecipeFragment(it: Int) {
        when (it) {
            R.id.homeFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_homeFragment_to_recipesFragment)
            }
            R.id.productFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_productFragment_to_recipesFragment)
            }
            R.id.mealFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_mealFragment_to_recipesFragment)
            }
            R.id.profileFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_profileFragment_to_recipesFragment)
            }

        }
    }

    private fun toTheHomeFragment(it: Int) {
        when (it) {
            R.id.recipesFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_recipesFragment_to_homeFragment)
            }
            R.id.productFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_productFragment_to_homeFragment)
            }
            R.id.mealFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_mealFragment_to_homeFragment)
            }
            R.id.profileFragment -> {
                findNavController(R.id.navHostFragment).navigate(R.id.action_profileFragment_to_homeFragment)
            }

        }
    }

    fun setBottomNavigationVisibility(visibility: Int) {
        bottomNavigationView?.visibility = visibility
    }

}