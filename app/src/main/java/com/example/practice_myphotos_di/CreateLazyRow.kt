package com.example.practicandodesarrollointerp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/*
Ahora que tenemos preparas la imagenes, que estaran en una lista y que serán clickables,
vamos ha crear el swipe y que cuando cliquemos en la foto, salga en grande
*/

@Composable
fun LazyRowPhotos() {
    //Primero, como siempre, creamos la columna para coger el espacio
    Column(Modifier.fillMaxSize()) {

        //Funcion para cuando cliquemos en una foto
        var selectedPicture: Pictures? by remember {mutableStateOf(null)}

        //Para poder hacer swipe en la row
        LazyRow {
            //Cogermos la lista de fotos
            items(getPicture()) {allPicture -> //Todas se llamaran así
                ItemPicture(
                    //Seleccionamos todas las fotos
                    picture = allPicture
                ) {selectedPicture = it} //La variable se la asignamos al usuario
            }
        }
        /*Ahora creamos una fila para que, cuando seleccionemos una foto
        salga en el centro de la pantalla con un tamaño que nosotros elijamos*/

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            //La imagen que seleccione el usuario estara en esta variable
            selectedPicture?.let {//Si no es nulo el valor, se hace lo que va debajo
                //De lo que ha elegido el user, cogemos la foto
                Image(painter = painterResource(id = it.photo),
                    //Desripción (que esto da igual)
                    contentDescription = "La imagen que elija el user",
                    //Asignamos el tamañp de la foto
                    modifier = Modifier.size(500.dp).padding(5.dp))
            }
        }
    }
}