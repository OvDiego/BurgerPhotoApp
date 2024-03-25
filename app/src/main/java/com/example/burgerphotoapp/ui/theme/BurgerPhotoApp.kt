package com.example.burgerphotoapp.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.burgerphotoapp.R
import com.example.burgerphotoapp.ui.theme.screens.HomeScreen
import com.example.burgerphotoapp.vievmodel.BurgerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerApp(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { BurgerTopBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()) {
            val burgerViewModel:BurgerViewModel = viewModel()
            HomeScreen(burgerUiState = burgerViewModel.burgerUiState, contentPadding = it)

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerTopBar(scrollBehavior: TopAppBarScrollBehavior,modifier:Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium
            )

        }
    )
}