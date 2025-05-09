package com.dmdpcuatro.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dmdpcuatro.laboratorio5.ui.navigation.NavigationScreen
import com.dmdpcuatro.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                NavigationScreen()
            }
        }
    }
}