package com.example.appmicalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText;
    private lateinit var txtContraseña: EditText;
    private lateinit var btnIngresar: Button;
    private lateinit var btnSalir: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//bonjour mon ami

        iniciarComponentes()
        eventosClic()





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarComponentes(){
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContraseña=findViewById(R.id.txtContraseña)
        btnSalir=findViewById(R.id.btnSalir)
        btnIngresar=findViewById(R.id.btnIngresar)
    }
    public fun eventosClic(){
        btnIngresar.setOnClickListener(View.OnClickListener {
            val usuario: String=getString(R.string.usuario)
            val pas: String =getString(R.string.pass)
            val nombre: String=getString(R.string.nombre)
            if(txtUsuario.text.toString().contentEquals(usuario) && txtContraseña.text.toString().contentEquals(pas) ){
                val intent = Intent(this, OperacionesActivity::class.java)
                intent.putExtra("Usuario",usuario)
                startActivity(intent)

            }else
                Toast.makeText(this, "El usuario o password no es correcto", Toast.LENGTH_SHORT).show()
        })
        btnSalir.setOnClickListener(View.OnClickListener {
            finish();
        })
    }
}