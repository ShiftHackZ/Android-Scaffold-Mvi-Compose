package com.shifthackz.scaffold.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shifthackz.scaffold.presentation.screen.loader.LoaderScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "loader",
            ) {
                composable("loader") {
                    LoaderScreen(
                        viewModel = koinViewModel(),
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
