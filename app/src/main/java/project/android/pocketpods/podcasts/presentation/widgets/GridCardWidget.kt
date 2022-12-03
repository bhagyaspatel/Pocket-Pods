package project.android.pocketpods.podcasts.presentation.widgets

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import project.android.pocketpods.R
import project.android.pocketpods.ui.theme.PocketPodsTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun cards(
    data : String,
    notSelectedBgColor : Color = Color.Black.copy(alpha = 0.6f),
    selectedBgColor : Color = Color.Gray.copy(alpha = 0.6f),
    selectedTextColor : Color = colorResource(id = R.color.darkGreen),
    notSelectedTextColor : Color = Color.Green,
) {
    val context = LocalContext.current
    var selectedState by remember { mutableStateOf(false) }
    var bgColor by remember { mutableStateOf(notSelectedBgColor) }
    var textColor by remember { mutableStateOf(notSelectedTextColor) }

    Card(
        backgroundColor = bgColor,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {
            selectedState = !selectedState

            if(selectedState){
                bgColor = selectedBgColor
                textColor = selectedTextColor
            }else{
                bgColor = notSelectedBgColor
                textColor = notSelectedTextColor
            }
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
        },
//        elevation = 6.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = data,
                fontSize = MaterialTheme.typography.h2.fontSize,
                color = Color.Green
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    PocketPodsTheme {
        cards(data = "Hindi")
    }
}

