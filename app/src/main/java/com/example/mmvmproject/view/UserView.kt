package com.example.mmvmproject.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.mmvmproject.entity.User
import com.example.mmvmproject.presenter.UserPresenter

@Composable
fun UserScreen(modifier: Modifier = Modifier, presenter: UserPresenter) {

    var users by remember { mutableStateOf<List<User>>(emptyList()) }

    LaunchedEffect(true) { users = presenter.loadUsers() }

    Column {
        users.forEach{
            Text(text = it.name)
        }
    }

}