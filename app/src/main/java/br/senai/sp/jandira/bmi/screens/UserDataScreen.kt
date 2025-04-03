package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navegacao: NavHostController?) {

    var ageState = remember {
        mutableStateOf("")
    }

    var weigState = remember {
        mutableStateOf("")
    }

    var heigState = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val userName = userFile.getString("user_name", "User name not found!")

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
    ) {

        Text(
            text = stringResource(R.string.hi) + ", $userName!",
            modifier = Modifier
                .padding(top = 50.dp, start = 28.dp),
            color = Color.Green,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(725.dp),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 48.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {

                    Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.iconhomem),
                            contentDescription = "Masculino",
                            modifier = Modifier
                                .height(100.dp)
                                .size(92.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color.Green,
                                    shape = RoundedCornerShape(100.dp)
                                )
                        )
                        Button(
                            onClick = {},
                            modifier = Modifier.padding(top = 8.dp),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(text = stringResource(R.string.male))
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.iconmulher),
                            contentDescription = "Feminino",
                            modifier = Modifier
                                .height(100.dp)
                                .size(92.dp)
                                .border(
                                    width = 2.dp,
                                    color = Color.Green,
                                    shape = RoundedCornerShape(100.dp)
                                )
                        )
                        Button(
                            onClick = {},
                            modifier = Modifier.padding(top = 8.dp),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(text = stringResource(R.string.female))
                        }
                    }
                }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            label = {
                                Text(text = stringResource(R.string.age))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "Icone de Idade"
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            value = weigState.value,
                            onValueChange = {
                                weigState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            label = {
                                Text(text = stringResource(R.string.weight))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "Icone de Peso"
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            value = heigState.value,
                            onValueChange = {
                                heigState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            label = {
                                Text(text = stringResource(R.string.height))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "Icone de Altura"
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            )
                        )

                        Button(
                            onClick = {
                                val editor = userFile.edit()
                                editor.putInt("user_age", ageState.value.toInt())
                                editor.putInt("user_weight", weigState.value.toInt())
                                editor.putFloat("user_height", heigState.value.toFloat())
                                editor.apply()
                                navegacao?.navigate("resultado")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(top = 40.dp),
                            shape = RoundedCornerShape(8.dp)

                        ) {
                            Text(
                                text = stringResource(R.string.calculate),
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
}

@Preview(showSystemUi = true)
@Composable
private fun UserDataPreview() {
    UserDataScreen(null)
}