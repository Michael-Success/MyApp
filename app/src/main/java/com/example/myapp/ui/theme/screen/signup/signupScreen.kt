package com.example.myapp.ui.theme.screen.signup


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.AuthViewModel
import com.example.myapp.navigation.ROUTE_LOGIN


@Composable
fun SignupScreen(navController: NavController) {
    val context = LocalContext.current
    val authViewModel: AuthViewModel = viewModel()

    val isLoading by authViewModel.isLoading.collectAsState()

    var userName by remember {
        mutableStateOf(value = "")
    }

    var email by remember {
        mutableStateOf(value = "")
    }

    var password by remember {
        mutableStateOf(value = "")
    }

    var confirmPassword by remember {
        mutableStateOf(value = "")
    }


    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Text(
            text = "Please Register Here",
            fontSize = 21.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .padding(20.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = userName,
            onValueChange = { newuserName -> userName = newuserName },
            label = { Text(text = "Enter userName") },
            placeholder = { Text(text = "Please enter userName") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            label = { Text(text = "Enter Email") },
            placeholder = { Text(text = "Please enter Email") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please enter Password") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { newconfirmPassword -> confirmPassword = newconfirmPassword },
            label = { Text(text = "Confirm Password") },
            placeholder = { Text(text = "Please enter confirmPassword") },
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                authViewModel.signup(
                    userName,
                    email,
                    password,
                    confirmPassword,
                    navController,
                    context
                )
            },
            enabled = !isLoading,
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        )
        {
            if (isLoading) {
                CircularProgressIndicator(color = Color.Black, strokeWidth = 4.dp)
            } else {

                Text(
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    text = "SIGN UP"
                )
            }
        }

            Spacer(modifier = Modifier.height(10.dp))

            ClickableText(
                text = AnnotatedString("You have an account? Login here"),
                onClick = {
                    navController.navigate(ROUTE_LOGIN)
                },
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            )

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview(){
   SignupScreen(rememberNavController())
}