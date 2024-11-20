package com.example.mywishlistapp




import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
//import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon


import androidx.compose.material3.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.TopAppBarColors


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.mywishlistapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarview(
    title:String,
    onBackNavClicked:()->Unit={}
){

    val navigationIcon:(@Composable () -> Unit )= {
        if (!title.contains("WishList"))
        {
            IconButton(onClick = {onBackNavClicked() }) {
                Icon(
                    imageVector= Icons.Filled.ArrowBack,
                    tint=Color.White,
                    contentDescription=null,

                    )
            }
        }else{
            null
        }
    }

    TopAppBar(title = {
        Text(text = title, color = colorResource(id = R.color.white),
            modifier= Modifier
                .padding(start = 4.dp)
                .heightIn(max = 24.dp) )
    },
        modifier = Modifier.background(colorResource(id = R.color.app_bar_color)),
        elevation=3.dp,
        backgroundColor= colorResource(id = R.color.app_bar_color),
        navigationIcon =navigationIcon
    )
}