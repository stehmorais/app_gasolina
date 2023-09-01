package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnCalcular(view: View) {

       val preco_Alcool = precoAlcool.text.toString()
       val preco_Gasolina = precoGasolina.text.toString()

        calcularPreco(preco_Alcool, preco_Gasolina)


        val validacampos = validarCampos(preco_Alcool, preco_Gasolina)

        if(validacampos){
            calcularPreco(preco_Alcool, preco_Gasolina)
        }else {

        }


    }

    fun validarCampos (precoAlcool: String, precoGasolina: String): Boolean {

        var camposValidados:Boolean = true

        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }



    fun calcularPreco(precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultado = valorAlcool / valorGasolina

        if (resultado >= 0.7) {
            textoResultado.setText("Melhor Gasolina")
        }else {
            textoResultado.setText("Melhor Alcool")
        }

    }

}
