package com.example.josecarlos_sancho_pmdm.Componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiTopAppBar(onMenuClick: () -> Unit) {

    TopAppBar(
        navigationIcon = {

            IconButton(onClick =  onMenuClick )  {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },

        title = { Text(text = "Examen Jose Carlos") },
        actions = {
            IconButton(onClick = { /*TODO*/ } ) {
                Icon(
                    imageVector = Icons.Rounded.Create,
                    contentDescription = null
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.MailOutline,
                    contentDescription = null
                )
            }
        }
    )
}

