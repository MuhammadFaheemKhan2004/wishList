package com.example.mywishlistapp


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mywishlistapp.data.DummyWish
import com.example.mywishlistapp.data.Screen
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishViewModel



//import com.example.mywishlistapp.ui.theme.AppBarview

@Composable
fun Homeview(navController: NavController,
             viewModel: WishViewModel){
    Scaffold(
        topBar = {AppBarview(title = "WishList")},

        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(all=20.dp),
                contentColor = Color.White,
              // backgroundColor = Color.Black
                onClick = {
//Toast.makeText(context,"FAButton Clicked",Toast.LENGTH_LONG)
                    navController.navigate(Screen.AddScreen.route)



                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription =null )
            }
        }
    ) {
        val wishlist=viewModel.getAllWishes.
        collectAsState(initial = listOf())
LazyColumn(modifier = Modifier
    .fillMaxSize()
    .padding(it))
     {
items(wishlist.value){
   wis-> WishItem(wish = wis) {

    }
}
}
    }
}
@Composable
fun WishItem(wish : Wish, onClick:() ->Unit){
Card(modifier= Modifier
    .fillMaxWidth()
    .padding(8.dp)
    .clickable { onClick() },
    elevation=10.dp,
    backgroundColor = Color.LightGray
    ){
Column(modifier=Modifier.padding(16.dp)) {
Text(text = wish.title, fontWeight = FontWeight.ExtraBold, color = Color.Black)
Text(text = wish.description,color = Color.Black)
}
}
}