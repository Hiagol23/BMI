package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import java.util.Locale


@Composable
fun ResultScreen(navegacao: NavHostController?){

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val editor = userFile.edit()

    val userAge = userFile.getInt("user_age", 0)
    val userWeig = userFile.getInt("user_weight", 0)
    val userHeig = userFile.getFloat("user_height", 0f)

    val bmi = bmiCalculate(userWeig, userHeig.toDouble().div(100))


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF0F5711),
                        Color(0xFF29772C),
                        Color(0xFF3FC747),
                        Color(0xFF84DC89),
                        Color(0xFF3FC747),
                        Color(0xFF29772C),
                        Color(0xFF0F5711)
                    )
                )
            )
    )
    {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.result),
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Card(
                        modifier = Modifier
                            .size(130.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 4.dp,
                            color = bmi.bmiColor
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    )   {
                        Column (
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        )   {
                            Text(
                                text = String.format(
                                    Locale.getDefault(),
                                    "%.1f",
                                    bmi.bmi.second
                                ),
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 35.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = bmi.bmi.first,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(80.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column(
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(70.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.age),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userAge",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(70.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.weight),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userWeig Kg",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .height(60.dp)
                                    .width(70.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.height),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = String.format(Locale.getDefault(), "%.2f", userHeig),
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .background(Color.LightGray)
                    ){

                    }
                    HorizontalDivider()
                    Button(
                        onClick = {
                            navegacao?.navigate("dados")
                            editor.apply()
                                  },
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .width(300.dp)
                            .height(45.dp),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Text(
                            text = stringResource(R.string.new_calculate),
                            fontSize = 25.sp,
                            color = Color.Green,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun ResultPreview (){
    ResultScreen(null)
}