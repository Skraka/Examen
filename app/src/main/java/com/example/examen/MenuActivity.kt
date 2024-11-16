package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var crvRetangulo : CardView
    private lateinit var crvCalculadora : CardView
    private lateinit var crvSalir : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        crvRetangulo = findViewById<CardView>(R.id.crvRetangulo)
        crvCalculadora = findViewById<CardView>(R.id.crvCalculadora)
        crvSalir = findViewById<CardView>(R.id.crvSalir)
    }
    fun eventosClic(){
        crvRetangulo.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,loginRetangulo::class.java)
            startActivity(intent)
        })
        crvCalculadora.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,loginCalculadora::class.java)
            startActivity(intent)
        })
        crvSalir.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Deseas Salir?")
            builder.setPositiveButton("Aceptar"){
                    dialog ,whitch ->
                finishAffinity()
            }
            builder.setNegativeButton("Cancelar"){
                    dialog ,whitch ->
            }
            builder.show()
        })
    }
}