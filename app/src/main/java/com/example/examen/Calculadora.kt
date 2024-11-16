package com.example.examen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {

    private lateinit var lblUser : TextView
    private lateinit var txtNum1 : EditText
    private lateinit var txtNum2 : EditText
    private lateinit var lblResultado : TextView
    private lateinit var btnMas : Button
    private lateinit var btnMenos : Button
    private lateinit var btnPor : Button
    private lateinit var btnEntre : Button

    private lateinit var btnLimpiar : Button
    private lateinit var btnRegresar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        lblUser = findViewById<TextView>(R.id.lblUser)
        txtNum1 = findViewById<EditText>(R.id.txtNum1)
        txtNum2 = findViewById<EditText>(R.id.txtNum2)
        lblResultado = findViewById<TextView>(R.id.lblResultado)
        btnMas = findViewById<Button>(R.id.btnMas)
        btnMenos = findViewById<Button>(R.id.btnMenos)
        btnPor = findViewById<Button>(R.id.btnPor)
        btnEntre = findViewById<Button>(R.id.btnEntre)

        btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        btnRegresar = findViewById<Button>(R.id.btnRegresar)

        var txtUsuario : String = intent.getStringExtra("usuario").toString()
        lblUser.text = txtUsuario
    }
    fun eventosClic(){
        btnMas.setOnClickListener(View.OnClickListener {
            if(txtNum1.text.toString().contentEquals("") || txtNum2.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar algun dato", Toast.LENGTH_SHORT).show()
                txtNum1.requestFocus()
            }
            else {
                var res : Float = 0.0f
                var num1 = txtNum1.text.toString().toFloat()
                var num2 = txtNum2.text.toString().toFloat()
                res = num1+num2
                lblResultado.text = "Resultado:  $res"
            }
        })
        btnMenos.setOnClickListener(View.OnClickListener {
            if(txtNum1.text.toString().contentEquals("") || txtNum2.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar algun dato", Toast.LENGTH_SHORT).show()
                txtNum1.requestFocus()
            }
            else {
                var res : Float = 0.0f
                var num1 = txtNum1.text.toString().toFloat()
                var num2 = txtNum2.text.toString().toFloat()
                res = num1-num2
                lblResultado.text = "Resultado:  $res"
            }
        })
        btnPor.setOnClickListener(View.OnClickListener {
            if(txtNum1.text.toString().contentEquals("") || txtNum2.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar algun dato", Toast.LENGTH_SHORT).show()
                txtNum1.requestFocus()
            }
            else {
                var res : Float = 0.0f
                var num1 = txtNum1.text.toString().toFloat()
                var num2 = txtNum2.text.toString().toFloat()
                res = num1*num2
                lblResultado.text = "Resultado:  $res"
            }
        })
        btnEntre.setOnClickListener(View.OnClickListener {
            if(txtNum1.text.toString().contentEquals("") || txtNum2.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar algun dato", Toast.LENGTH_SHORT).show()
                txtNum1.requestFocus()
            }
            else {
                var res : Float = 0.0f
                var num1 = txtNum1.text.toString().toFloat()
                var num2 = txtNum2.text.toString().toFloat()
                res = num1/num2
                lblResultado.text = "Resultado:  $res"
            }
        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtNum1.setText("")
            txtNum2.setText("")
            lblResultado.text = "Resultado: "
        })
        btnRegresar.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Calculadora")
            builder.setMessage("Deseas Regresar?")
            builder.setPositiveButton("Aceptar"){
                    dialog ,whitch ->
                finish()
            }
            builder.setNegativeButton("Cancelar"){
                    dialog ,whitch ->
            }
            builder.show()
        })
    }
}