package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanDospem: List<String>,
    onSelectionChanged: (String) -> Unit,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNamaMhs by rememberSaveable {
        mutableStateOf("")
    }
    var txtNIM by rememberSaveable {
        mutableStateOf("")
    }
    var txtKonsentrasi by rememberSaveable {
        mutableStateOf("")
    }
    var txtJudul by remember {
        mutableStateOf("")
    }
    var dosenYgDipilih by rememberSaveable { mutableStateOf("") }

    var txtListData: MutableList<String> =
        mutableListOf(txtNamaMhs, txtNIM, txtKonsentrasi, txtJudul)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(value = txtNamaMhs, onValueChange = {
            txtNamaMhs = it
        }, label = {
            Text(text = "Nama Mahasiswa")
        })
        OutlinedTextField(value = txtNIM, onValueChange = {
            txtNIM = it
        }, label = {
            Text(text = "NIM")
        })
        OutlinedTextField(value = txtKonsentrasi, onValueChange = {
            txtKonsentrasi = it
        }, label = {
            Text(text = "Konsentrasi")
        })
        OutlinedTextField(value = txtJudul, onValueChange = {
            txtJudul = it
        }, label = {
            Text(text = "Judul Skripsi")
        })
        Divider()
        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = { onSubmitButtonClick(txtListData) }) {
            Text(text = stringResource(id = R.string.btn_submit))
        }
        pilihanDospem.forEach { item ->
            Column(
                modifier = Modifier.selectable(
                    selected = dosenYgDipilih == item,
                    onClick = {
                        dosenYgDipilih = item
                        onSelectionChanged(item)
                    }
                )
            )
            {
                RadioButton(selected = dosenYgDipilih == item,
                    onClick = {
                        dosenYgDipilih = item
                        onSelectionChanged(item)
                    }
                )
            }
        }
    }
}