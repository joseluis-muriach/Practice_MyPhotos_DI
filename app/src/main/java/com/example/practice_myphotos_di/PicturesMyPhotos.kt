package com.example.practicandodesarrollointerp1

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.practice_myphotos_di.R

//Para crear todas las fotos
data class Pictures(
    @DrawableRes var photo: Int)

//Lista con todas las fotos
fun getPicture(): List<Pictures> {
    return listOf(
        Pictures(
        R.drawable.image1),
        Pictures(
        R.drawable.image2),
        Pictures(
        R.drawable.image3),
        Pictures(
        R.drawable.image4),
        Pictures(
        R.drawable.image5),
        Pictures(
        R.drawable.image6),
        Pictures(
        R.drawable.image7),
        Pictures(
        R.drawable.image8)
    )
}

//Creando la fila con la imagen que va a ser clicable ...
@Composable
fun ItemPicture(picture: Pictures, onItemSelected: (Pictures) -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onItemSelected(picture)}) {

        //Para mostrar la imagen y darle propiedades
        Image(painter = painterResource(id = picture.photo), //Cogemos el atributo photo
            contentDescription = "Pictures of the project", //Una pequeña descripción
            contentScale = ContentScale.Inside, //Escalamos la imagen dentro del espacio
            modifier = Modifier.padding(5.dp)
        )
    }
}

