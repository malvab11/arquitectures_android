package com.example.mmvmproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.mmvmproject.interactor.UserInteractor
import com.example.mmvmproject.network.RetrofitClient
import com.example.mmvmproject.presenter.UserPresenter
import com.example.mmvmproject.ui.theme.MMVMProjectTheme
import com.example.mmvmproject.view.UserScreen
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = RetrofitClient.apiService
        val interactor = UserInteractor(api)
        val presenter = UserPresenter(interactor)

        enableEdgeToEdge()
        setContent {
            MMVMProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserScreen(presenter = presenter)
                }
            }
        }
    }
}