/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.recyclersample.addFlower

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclersample.R
import com.google.android.material.textfield.TextInputEditText

const val FLOWER_NAME = "name"
const val FLOWER_DESCRIPTION = "description"
const val FLOWER_AROMA = "aroma"
const val  FLOWER_TEXTURA = "textura"
const val FLOWER_TAMANIO = "tamanio"
const val  FLOWER_TEMPORADA = "temporada"

class AddFlowerActivity : AppCompatActivity() {
    private lateinit var addFlowerName: TextInputEditText
    private lateinit var addFlowerDescription: TextInputEditText
    private lateinit var addFlowerAroma: TextInputEditText
    private lateinit var addFlowerTextura: TextInputEditText
    private lateinit var addFlowerTamanio: TextInputEditText
    private lateinit var addFlowerTemporada: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_flower_layout)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addFlower()
        }
        addFlowerName = findViewById(R.id.add_flower_name)
        addFlowerDescription = findViewById(R.id.add_flower_description)
        addFlowerAroma = findViewById(R.id.add_flower_aroma)
        addFlowerTextura = findViewById(R.id.add_flower_textura)
        addFlowerTamanio = findViewById(R.id.add_flower_tamanio)
        addFlowerTemporada = findViewById(R.id.add_flower_temporada)
    }

    /* The onClick action for the done button. Closes the activity and returns the new flower name
    and description as part of the intent. If the name or description are missing, the result is set
    to cancelled. */

    private fun addFlower() {
        val resultIntent = Intent()

        if (addFlowerName.text.isNullOrEmpty() || addFlowerDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addFlowerName.text.toString()
            val description = addFlowerDescription.text.toString()
            val aroma = addFlowerAroma.text.toString()
            val textura = addFlowerTextura.text.toString()
            val tamanio = addFlowerTamanio.text.toString()
            val temporada = addFlowerTemporada.text.toString()
            resultIntent.putExtra(FLOWER_NAME, name)
            resultIntent.putExtra(FLOWER_DESCRIPTION, description)
            resultIntent.putExtra(FLOWER_AROMA, aroma)
            resultIntent.putExtra(FLOWER_TEXTURA,textura)
            resultIntent.putExtra(FLOWER_TAMANIO,tamanio)
            resultIntent.putExtra(FLOWER_TEMPORADA,temporada)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }
}