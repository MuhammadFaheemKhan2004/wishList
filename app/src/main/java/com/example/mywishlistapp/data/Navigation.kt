package com.example.mywishlistapp.data

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mywishlistapp.Homeview


@Composable
fun Navigation(viewModel: WishViewModel=viewModel()
               ,navController: NavHostController= rememberNavController()
){
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route ){
        composable(Screen.HomeScreen.route)
        {
        Homeview(navController,viewModel)
        }

        composable(Screen.AddScreen.route)
        {
            AddEditDetailView(id=0L,viewModel=viewModel,navController=navController)
        }
    }



}
