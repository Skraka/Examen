package com.example.examen

import android.content.Intent
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

class loginRetangulo : AppCompatActivity() {

    private lateinit var txtNombre : EditText
    private lateinit var btnEntrar : Button
    private lateinit var btnSalir : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_retangulo)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        txtNombre = findViewById<EditText>(R.id.txtNombre)
        btnEntrar = findViewById<Button>(R.id.btnEntrar)
        btnSalir = findViewById<Button>(R.id.btnSalir)
    }
    fun eventosClic(){
        btnEntrar.setOnClickListener(View.OnClickListener {
            if(txtNombre.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar el Nombre", Toast.LENGTH_SHORT).show()
                txtNombre.requestFocus()
            }
            else {
                val intent = Intent(this,Retangulo::class.java)
                intent.putExtra("nombre", txtNombre.text.toString())
                startActivity(intent)
            }
        })
        btnSalir.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("")
            builder.setMessage("Deseas Salir?")
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