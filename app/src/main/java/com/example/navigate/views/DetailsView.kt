package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.navegacion.components.ActionButton

var value1: String? = null
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun DetailsView(navController: NavController, value: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Detail View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Valor recibido: ${value ?: "No hay valor"}")
            value1=value
            Spacer(modifier = Modifier.height(16.dp))
            ContentDetailsView(navController, value)
        }
    }
}
@Composable
fun ContentDetailsView(navController: NavController, value: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Vista Detalle")

        Text(text = "Valor a enviar: $value")

        // Botón que navega a DetailsView
        Button(onClick = { navController.navigate("new/$value1") }) {
            Text(text = "Ir a New View")
        }
    }
}
