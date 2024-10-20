package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.components.ActionButton
import com.example.navegacion.components.TitleBar

//Navegacion
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    val navController = rememberNavController()  // Crear el NavController

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        // Definir las rutas y las pantallas dentro del NavHost
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { ContentHomeView(navController) }
            composable("details/{value}") { backStackEntry ->
                DetailsView(navController, backStackEntry.arguments?.getString("value"))
            }
        }
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    // Estado para mantener el valor que se enviará
    val value = "123" // Puedes cambiar este valor según sea necesario
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Inicio de la aplicación")

        Text(text = "Valor a enviar: $value")

        // Botón que navega a DetailsView
        Button(onClick = { navController.navigate("details/$value") }) {
            Text(text = "Ir a Details")
        }
    }
}

