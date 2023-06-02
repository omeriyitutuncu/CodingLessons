package com.example.codeinlessons

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codeinlessons.ui.theme.CodeinLessonsTheme
import kotlin.concurrent.timer
import androidx.compose.ui.text.font.FontWeight.Companion as FontWeight1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val restaurantItemList = mutableListOf<RestaurantClass>(
            RestaurantClass("Omer a", "Omer 1"),
            RestaurantClass("Omer b", "Omer 2"),
            RestaurantClass("Omer c", "Omer 3"),
            RestaurantClass("Omer d", "Omer 4"),
        )
        for (i in 1..300){
            restaurantItemList.add(RestaurantClass("Omer $i","Omer address $i"))
        }
        var timerState by mutableStateOf(0)
        val timer = timer(period = 1000) {
            timerState++
// state degistirmek icin kullaniyoruz ama variable olarak bunu degilde
            // degistirdigi timerState i kullaniriz
        }
        setContent {
            CodeinLessonsTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                       contentPadding = PaddingValues(
                           vertical = 8.dp,
                           horizontal = 8.dp
                       )
                    ) {



                      items(restaurantItemList){
                          Greeting( it)
                      }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(restaurantItem: RestaurantClass) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_anchor_24),
                contentDescription = "",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                contentScale = ContentScale.Inside


            )
            Column() {
                Text(
                    text = restaurantItem.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(3.dp)
                )
                Text(
                    text = restaurantItem.description,
                    color = Color.Gray,
                    modifier = Modifier.padding(3.dp)

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CodeinLessonsTheme {
        Greeting(
            RestaurantClass("omer 1", "omer 2")
        )
    }
}
