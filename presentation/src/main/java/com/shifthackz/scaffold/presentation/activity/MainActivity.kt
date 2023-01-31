package com.shifthackz.scaffold.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shifthackz.scaffold.presentation.screen.loader.LoaderScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "loader") {
                composable("loader") {
                    LoaderScreen(
                        viewModel = hiltViewModel(),
                        toastFn = {
                            Toast
                                .makeText(this@MainActivity, it, Toast.LENGTH_LONG)
                                .show()
                        }
                    ).Build()
                }
            }
        }
    }
}
