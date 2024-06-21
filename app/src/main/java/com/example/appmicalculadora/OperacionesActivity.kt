package com.example.appmicalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperacionesActivity : AppCompatActivity() {

    private lateinit var txtUsuario: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var txtResultado: TextView
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button
    private lateinit var operaciones: Operaciones

    var opcion : Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)

        iniciarComponentes()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes(){
        txtUsuario= findViewById(R.id.txtUsuario)
        txtResultado= findViewById(R.id.txtResultado)
        txtNum1=findViewById(R.id.txtNum1)
        txtNum2= findViewById(R.id.txtNum2)
        btnSumar=findViewById(R.id.btnMas)
        btnMult=findViewById(R.id.btnMul)
        btnRestar=findViewById(R.id.btnRes)
        btnDiv=findViewById(R.id.btnDiv)

        btnRegresar=findViewById(R.id.btnclose)
        btnLimpiar=findViewById(R.id.btnLimpiar)

        val bundle: Bundle? = intent.extras
        txtUsuario.text=bundle?.getString("Usuario ")
    }

    public fun validar(): Boolean{
        if(txtNum1.text.toString().contentEquals("")|| txtNum2.text.toString().contentEquals("")) return false
        else return true
    }

    public fun operacion(): Float{
        var num1 : Float = 0.0f
        var num2 : Float =0.0f
        var res : Float =0.0f
        if(validar()){
            num1 = txtNum1.text.toString().toFloat()
            num2 = txtNum2.text.toString().toFloat()
            operaciones = Operaciones(num1,num2)
            when(opcion){
                1 -> {res=operaciones.suma()}
                2 -> {res= operaciones.resta()}
                3 -> {res= operaciones.multiplica()}
                4 -> {res= operaciones.div()}
            }

    }else Toast.makeText(this, "Captura de informacion incompleta", Toast.LENGTH_SHORT).show()
        return res;
    }
    public fun eventosClic(){
        btnSumar.setOnClickListener(View.OnClickListener {
            opcion =1;
            txtResultado.text= operacion().toString()
        })
        btnRestar.setOnClickListener(View.OnClickListener {
            opcion=2;
            txtResultado.text= operacion().toString()
        })
        btnMult.setOnClickListener(View.OnClickListener {
            opcion=3;
            txtResultado.text= operacion().toString()
        })
        btnDiv.setOnClickListener(View.OnClickListener {
            if(this.txtNum2.text.toString().toFloat()==0f)
                txtResultado.text="Te falla no?"
            else {
                opcion = 4;
                txtResultado.text= operacion().toString()
            }

        })
        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtResultado.text =""
            txtNum2.text.clear()
            txtNum1.text.clear()
        })
            btnRegresar.setOnClickListener(View.OnClickListener {
            finish();
        })
    }
}
