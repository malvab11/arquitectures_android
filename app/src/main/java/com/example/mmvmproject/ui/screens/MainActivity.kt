package com.example.mmvmproject.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mmvmproject.ui.theme.MMVMProjectTheme
import com.example.mmvmproject.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MMVMProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UsersScreen(
                        viewModel = userViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UsersScreen(viewModel: UserViewModel, modifier: Modifier = Modifier) {
    val users by viewModel.users.collectAsState()
    Column(modifier = modifier) {
        if (users.isNotEmpty()) {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(users) {
                    Column(modifier = Modifier.fillMaxWidth().background(Color.Cyan)) {
                        Text(text = it.id.toString(), fontSize = 16.sp)
                        Text(text = it.username, fontSize = 16.sp)
                        Text(text = it.name, fontSize = 16.sp)
                    }

                }
            }
        }
        else {
            Text(text = "No hay data", modifier = Modifier.fillMaxWidth(), fontSize = 16.sp)
        }
    }
}