package com.example.cookingtips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.ui.theme.CookingTipsTheme
import model.DishTip
import model.TipsRepo

// Main activity that sets the content of the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CookingTipsTheme {
                CookingTipsApp()
            }
        }
    }
}

// Composable function for the main app layout
@Composable
fun CookingTipsApp(){
    Scaffold(
        topBar = {
            CookingTipsTopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(TipsRepo.tips) { tip ->
                CookingCard(tip = tip, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

// Composable function for the top app bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookingTipsTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium
        )
    })
}

// Composable function for each cooking tip card
@Composable
fun CookingCard(tip: DishTip, modifier: Modifier = Modifier){
    // State to manage the expanded state of the card
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .clickable(onClick = { expanded = !expanded }) // Toggle expanded state on click
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
        ) {
            // Display day
            Text(
                text = stringResource(tip.day),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            // Display dish name
            Text(
                text = stringResource(tip.dishName),
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            // Display dish image
            Image(
                painter = painterResource(tip.imageResourceId),
                contentDescription = stringResource(tip.dishName),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop,
            )
            // Display description if the card is expanded
            if (expanded){
                Text(
                    text = stringResource(tip.description),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

// Preview function for the app
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CookingTipsTheme {
        CookingTipsApp()
    }
}
