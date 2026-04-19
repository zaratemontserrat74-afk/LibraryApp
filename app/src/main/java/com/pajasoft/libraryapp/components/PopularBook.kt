package com.pajasoft.libraryapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.pajasoft.Book
import com.pajasoft.books
import com.pajasoft.libraryapp.screens.BooksScreen
import com.pajasoft.libraryapp.ui.theme.LibraryAppTheme

@Composable
fun PopularBook (
    book: Book,
    navController: NavController
){
    Box(
        modifier = Modifier
            .padding(end = 10.dp)
            .width(150.dp)
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = MaterialTheme.colorScheme.tertiary)
            .clickable{
                navController.navigate(route = "books/${book.id}")
            }
    ) {
        Text(
            text = book.title.take(2).uppercase(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.align(Alignment.Center)
        )
        AsyncImage(
            model = book.image,
            contentDescription = book.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = book.title,
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = book.author.uppercase(),
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PopularBookPreview(){
    LibraryAppTheme {
        PopularBook(
            book = books[1] ,
            navController = rememberNavController()
        )
    }
}



