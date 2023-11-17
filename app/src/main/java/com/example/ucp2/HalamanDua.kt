package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ucp2.data.OrderUIState

@Composable
fun HalamanDua(
    orderUIState: OrderUIState,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){

    val contact = listOf(
        Pair(stringResource(R.string.nama), orderUIState.nama),
        Pair(stringResource(R.string.NIM), orderUIState.NIM),
        Pair(stringResource(R.string.Konsen), orderUIState.Konsentrasi),
        Pair(stringResource(R.string.Judul), orderUIState.JudulSkripsi),
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.padding_medium )
            )
        ){
            contact.forEach{item ->
                Column {
                    Text(item.first.toString().uppercase())
                    Text(text = item.second.toString())
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }

        }
    }
}