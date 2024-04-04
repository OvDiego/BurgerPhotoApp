package com.example.burgerphotoapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.burgerphotoapp.R
import com.example.burgerphotoapp.model.BurgerPhoto
//import com.example.burgerphotoapp.model.Result
import com.example.burgerphotoapp.vievmodel.BurgerUiState




@Composable
fun HomeScreen(
    burgerUiState:BurgerUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when( burgerUiState){
        is BurgerUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BurgerUiState.Success -> BurgerPhotoCard( photo = burgerUiState.photos, modifier =  modifier.fillMaxSize())
        is BurgerUiState.Error -> ErrorScreen(modifier =  modifier.fillMaxSize())
    }
}



@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.loader),
            contentDescription = "Loading")
    }

}

@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos)
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Error Loading" )
        Text(text = stringResource(R.string.problem_with_connection))
    }
}


@Composable
fun BurgerPhotoCard(photo: BurgerPhoto, modifier: Modifier){
    AsyncImage(model = ImageRequest.Builder(context = LocalContext.current)
        .data(photo.image)
        .crossfade(true)
        .build()
        ,
        contentDescription = stringResource(id = R.string.burger_image) ,
        modifier = modifier
    )
}



@Preview
@Composable
fun HomeScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeScreenPreview()
    }
}