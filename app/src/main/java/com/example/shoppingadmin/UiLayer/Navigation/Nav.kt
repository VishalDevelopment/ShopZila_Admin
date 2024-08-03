package com.example.shoppingadmin.UiLayer.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Fax
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Backpack
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Fax
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

sealed class Navigation {
    @Serializable
    object DashBoard

    @Serializable
    object AddProduct

    @Serializable
    object Notification

    @Serializable
    object Category

    @Serializable
    object Order
}

data class BottomItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
@Preview(showSystemUi = true)
fun Nav() {
    val navController = rememberNavController()
    var selectedIconIndex by remember {
        mutableStateOf(0)
    }
    val itemList = listOf<BottomItem>(
        BottomItem("Dashboard", Icons.Default.Dashboard, Icons.Outlined.Dashboard),
        BottomItem("Product", Icons.Default.Fax, Icons.Outlined.Fax),
        BottomItem("Category", Icons.Default.Category, Icons.Outlined.Category),
        BottomItem("Notification", Icons.Default.Notifications, Icons.Outlined.Notifications),
        BottomItem("Orders", Icons.Default.Backpack, Icons.Outlined.Backpack)
    )

    Scaffold(bottomBar = {
        NavigationBar {
            itemList.forEachIndexed { index, item ->
                NavigationBarItem(selected = selectedIconIndex == index, onClick = {
                    if (selectedIconIndex == index) {
                        selectedIconIndex = index

                        if (selectedIconIndex == 0){

                        } else if (selectedIconIndex==1){

                        } else if (selectedIconIndex==2){

                        } else if (selectedIconIndex ==3){

                        }else if(selectedIconIndex == 4){

                        }else if (selectedIconIndex==5){

                        }
                    }
                }, icon = {
                    Icon(
                        imageVector = if (selectedIconIndex == index) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        }, contentDescription = null
                    )
                })
            }
        }
    }) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Navigation.DashBoard) {
                composable<Navigation.DashBoard> {

                }
                composable<Navigation.Order> {

                }
                composable<Navigation.Category> {

                }
                composable<Navigation.AddProduct> {

                }
                composable<Navigation.Notification> {

                }
            }
        }
    }



}