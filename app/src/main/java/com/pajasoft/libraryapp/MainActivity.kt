package com.pajasoft.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pajasoft.books
import com.pajasoft.libraryapp.screens.BookDetailScreen
import com.pajasoft.libraryapp.screens.BooksScreen
import com.pajasoft.libraryapp.screens.CounterScreen
import com.pajasoft.libraryapp.ui.theme.LibraryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        startDestination = "counter",
                        navController = navController
                    ){
                        composable (route= "books"){
                            BooksScreen(innerPadding, navController)
                        }
                        composable (
                            route = "books/{id}",
                            arguments = listOf(
                                navArgument(
                                    name = "id"
                                ){
                                    type = NavType.IntType
                                    nullable = false
                                }
                            )
                        )
                        { backStack ->
                            val id = backStack.arguments?.getInt("id") ?: 0
                            BookDetailScreen(id)
                        }
                        composable (route = "counter"){
                            CounterScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryAppTheme {
        Greeting("Android")
    }
}