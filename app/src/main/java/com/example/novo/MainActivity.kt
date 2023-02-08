
package com.example.novo
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity(){

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val btnCalcular = findViewById<Button>(R.id.btnCalcular)
    val edtpeso: EditText = findViewById<EditText>(R.id.editext_peso)
    val edtaltura: EditText = findViewById<EditText>(R.id.editext_altura)


    btnCalcular.setOnClickListener{

        val alturaStr = edtaltura.text.toString()
        val pesoStr = edtpeso.text.toString()
        if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {

            val altura: Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

            val alturaFinal: Float = altura * altura
            val result: Float = peso / alturaFinal

            val Intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(Intent)
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()

        }
    }
}}

