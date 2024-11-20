package com.example.mywishlistapp.data


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mywishlistapp.AppBarview
import com.example.mywishlistapp.R
import kotlinx.coroutines.launch
import java.time.format.TextStyle

@Composable
fun AddEditDetailView(
    id:Long,
    viewModel:WishViewModel,
    navController: NavController

){
    val snackMessage=remember{
        mutableStateOf("")
    }

    val scope= rememberCoroutineScope()
    val scaffoldState= rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar={
        AppBarview(title =
        if(id!=0L) stringResource(id = R.string.Update_Wish)
        else stringResource(id = R.string.Add_Wish),{navController.navigateUp()})
            }


    ) {
          Column(modifier = Modifier
              .padding(it)
              .wrapContentSize(),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center)
          {
             Spacer(modifier = Modifier.height(10.dp))
                WishTextField(label = "Title", value = viewModel.wishTitleState,
                 onValueChanged ={viewModel.onWishTitleChanged(it)} )



                Spacer(modifier = Modifier.height(10.dp))
                     WishTextField(label = "Description", value = viewModel.wishDescrState,
                          onValueChanged ={viewModel.onWishDescrChanged(it)} )
                    Spacer(modifier = Modifier.height(10.dp))

                        Button(onClick = {
                            if(viewModel.wishTitleState.isNotEmpty() &&
                                viewModel.wishDescrState.isNotEmpty())
                            {
                                if(id!=0L)
                                {
                                    //TODO updatewish
                                }
                                    else{
                                //TODO addwish
                                viewModel.addWish(Wish(
                                    title=viewModel.wishTitleState.trim(),
                                    description =viewModel.wishDescrState.trim()
                                ))
                                    snackMessage.value="Wish Has been Created"
                              }

                             }
                               else{
                                snackMessage.value="Enter fields to create a wish"
                            }

scope.launch {
    scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
    navController.navigateUp()
}






                        }) {
                           Text(
                           text= if(id!=0L) stringResource(id = R.string.Update_Wish) else
                          stringResource(id = R.string.Add_Wish),
                       fontStyle = FontStyle(12)
                )


    }
  }
  }
  }



@Composable
fun WishTextField(
    label:String,
    value:String,
    onValueChanged:(String)->Unit
){
OutlinedTextField(value = value,
    onValueChange =onValueChanged ,label={
        Text(text=label,color= Color.Black)
    },
    keyboardOptions = KeyboardOptions(keyboardType =
    KeyboardType.Text),
    colors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black,
        focusedBorderColor = colorResource(id = R.color.black),
        unfocusedBorderColor = colorResource(id = R.color.black),
        cursorColor = colorResource(id = R.color.black),
        focusedLabelColor = colorResource(id = R.color.black),
        unfocusedLabelColor = colorResource(id = R.color.black)
    ),
    modifier = Modifier.fillMaxWidth()
)


}