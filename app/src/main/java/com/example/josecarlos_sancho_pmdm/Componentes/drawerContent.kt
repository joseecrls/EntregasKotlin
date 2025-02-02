package com.example.josecarlos_sancho_pmdm.Componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.josecarlos_sancho_pmdm.Pantallas.Ruta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(onDestinationClicked: (String) -> Unit) {
    val items = listOf(
        NavigationItem("Formulario", Ruta.Formulario.ruta, Icons.Filled.Edit, Icons.Outlined.Edit),
        NavigationItem("ListadoDetalle", Ruta.ListadoDetalle.ruta, Icons.Filled.MailOutline, Icons.Outlined.MailOutline)
    )
    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(24.dp))
        items.forEach { item ->
            NavigationDrawerItem(

                label = { Text(text = item.title) },

                selected = false,

                onClick = { onDestinationClicked(item.route) },
                icon = {
                    Icon(imageVector = item.selectedIcon, contentDescription =item.title)
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}

data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)