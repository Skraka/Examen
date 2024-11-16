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

class Retangulo : AppCompatActivity() {

    private lateinit var lblNombre : TextView
    private lateinit var txtBase : EditText
    private lateinit var txtAltura : EditText
    private lateinit var txtArea : TextView
    private lateinit var txtPerimetro : TextView

    private lateinit var btnCalcular : Button
    private lateinit var btnRegresar : Button
    private lateinit var btnLimpiar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retangulo)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun iniciarComponentes(){
        lblNombre = findViewById<TextView>(R.id.lblNombre)
        txtBase = findViewById<EditText>(R.id.txtBase)
        txtAltura = findViewById<EditText>(R.id.txtAltura)
        txtArea = findViewById<TextView>(R.id.txtArea)
        txtPerimetro = findViewById<TextView>(R.id.txtPerimetro)

        btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnRegresar = findViewById<Button>(R.id.btnRegresar)
        btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        var txtNombre : String = intent.getStringExtra("nombre").toString()
        lblNombre.text = "Mi nombre es... $txtNombre"
    }
    fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            if(txtBase.text.toString().contentEquals("") || txtAltura.text.toString().contentEquals("")) {
                Toast.makeText(this, "Fallo al capturar cantidad", Toast.LENGTH_SHORT).show()
            }
            else {
                var area : Float = 0.0f
                var peri : Float = 0.0f

                var base = txtBase.text.toString().toFloat()
                var altura = txtAltura.text.toString().toFloat()

                area = base*altura
                peri = (base*2)+(altura*2)
                txtArea.text = "Area: $area"
                txtPerimetro.text = "Perimetro: $peri"
            }
        })
        btnRegresar.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Retangulo")
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
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtBase.setText("")
            txtAltura.setText("")
            txtArea.text = "Area: "
            txtPerimetro.text = "Perimetro: "
            txtBase.requestFocus()
        })
    }
}