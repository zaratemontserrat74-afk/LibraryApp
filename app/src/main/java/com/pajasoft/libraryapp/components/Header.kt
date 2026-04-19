package com.pajasoft.libraryapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pajasoft.libraryapp.screens.BooksScreen
import com.pajasoft.libraryapp.ui.theme.LibraryAppTheme

@Composable
fun Header(innerPadding: PaddingValues){
    //Header
    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(RoundedCornerShape(bottomStart = 75.dp))
            .background(colors.primary)
            .padding(innerPadding)
            .padding(15.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Hola Montse",
                    color = colors.onPrimary,
                    style = typography.headlineSmall
                )
                Text(
                    text = "Comencemos a leer",
                    color = colors.onPrimary,
                    style = typography.bodyMedium
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(colors.tertiary)
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    tint = colors.onPrimary
                )
            }
            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(start = 100.dp)
                    .clip(CircleShape)
                    .background(colors.tertiary)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings",
                    tint = colors.onPrimary
                )
            }
        }

        Text(
            text = "Continuar leyendo...",
            style = typography.titleLarge,
            color = colors.onPrimary,
            modifier = Modifier.padding(top = 5.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
                .background(colors.surface)
        ) {
            AsyncImage(
                model = "",
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(15.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Magenta)
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(15.dp)
            ) {
                Text(
                    text = "Nombre de un libro"
                )
                Text(
                    text = "Autor de un libro",
                    modifier = Modifier.weight(1f)
                )
                Row(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            colors.secondary,
                            RoundedCornerShape(5.dp)
                        )
                        .padding(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                    Text(
                        text = "leer"
                    )
                }
            }
        }
    }
}


