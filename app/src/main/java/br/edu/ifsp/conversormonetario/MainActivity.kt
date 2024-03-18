package br.edu.ifsp.conversormonetario

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*
     * *********************************************************
     * CONVENÇÃO DE CÓDIGO:
     * 1° ATRIBUTOS
     * *********************************************************
    */

    /*
     * Definição de variável que representa o valor para conversão do dolar.
    */

    private val DOLLAR_VALUE = 5.50

    /*
     * Atributos da classe. Aqui estão os objetos que serão vinculados
     * à tela do aplicativo.
    */

    private lateinit var inputEditText: EditText
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView

    /*
     * *********************************************************
     * CONVENÇÃO DE CÓDIGO:
     * 2° MÉTODOS DE CALLBACK (ciclo de vida da activity)
     * *********************************************************
    */

    /*
     * Implementação dos métodos de callback, ou seja, métodos que são
     * invocados pelo sistema operacional Android que altera o estado da
     * activity.
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }


    /*
     * *********************************************************
     * CONVENÇÃO DE CÓDIGO:
     * 3° MÉTODOS DAS INTERFACES:
     * *********************************************************
    */

    /*
     * Implementação do métodos da Interface OnClickListener. O método
     * onClick() é responsável por indentificar o elemento que foi clicado
     * na interface. A view clicada é passada pelo SO como argumento
     * do método
    */

    override fun onClick(v: View) {
        if (v == toDollarButton) {
            dollarConversion()
        } else if(v == toRealButton){
            realConversion()
        }
    }

    /*
     * *********************************************************
     * CONVENÇÃO DE CÓDIGO:
     * 4° MÉTODOS PÚBLICOS DA CLASSE:
     * *********************************************************
    */

    /*
     * *********************************************************
     * CONVENÇÃO DE CÓDIGO:
     * 5° MÉTODOS PRIVADOS DA CLASSE:
     * *********************************************************
    */

    /*
     * O método findViewById() é responsável por recuperar a referencia
     * dos elementos de interface e vinculá-los aos objetos da
     * classe
    */

    private fun findById(){
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_convert_to_dollar)
        toRealButton = findViewById(R.id.button_convert_to_real)
        outputTextView = findViewById(R.id.textview_output)
    }

    /*
    * Configurar como será tratado o clique do botão.
    */

    private fun configClickListener(){
        toDollarButton.setOnClickListener(this)
        toRealButton.setOnClickListener(this)
    }

    /*
    * Método responsável pela lógica do aplicativo, no momento.
    */

    private fun getValue(): Double{
        return try{
            inputEditText.text.toString().toDouble()
        } catch (e : NumberFormatException) {
            0.0
        }
    }

    private fun dollarConversion(){
        var value = getValue()
        value = value / DOLLAR_VALUE

        outputTextView.text = String.format("U$ %.2f", value)
    }

    private fun realConversion(){
        var value = getValue()
        value = value * DOLLAR_VALUE

        outputTextView.text = String.format("R$ %.2f", value)
    }

}