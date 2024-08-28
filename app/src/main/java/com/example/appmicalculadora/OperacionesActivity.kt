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

    private lateinit var txtusuario: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var txtResultado: TextView

    private lateinit var btnsumar: Button
    private lateinit var btnrestar: Button
    private lateinit var btndividir: Button
    private lateinit var btnmultiplicar: Button

    private lateinit var btnCerrar: Button
    private lateinit var btnLimpiar: Button

    private lateinit var operaciones: Operaciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operaciones)

        iniciarcomponentes()
        initClickEvents()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarcomponentes() {
        txtusuario = findViewById(R.id.txtUsuario)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        txtResultado = findViewById(R.id.txtResultado)

        btnsumar = findViewById(R.id.btnsumar)
        btnrestar = findViewById(R.id.btnrestar)
        btndividir = findViewById(R.id.btndividir)
        btnmultiplicar = findViewById(R.id.btnmultiplicar)

        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val bundle: Bundle? = intent.extras
        txtusuario.text = bundle?.getString("nombre")
        operaciones = Operaciones(0f, 0f)
    }

    private fun validar(): Boolean {
        return txtNum1.text.toString().isNotEmpty() && txtNum2.text.toString().isNotEmpty()
    }

    private fun assignValues() {
        if (validar()) {
            operaciones.num1 = txtNum1.text.toString().toFloat()
            operaciones.num2 = txtNum2.text.toString().toFloat()
        } else {
            throw IllegalArgumentException("Inserte valores válidos en ambos campos, por favor.")
        }
    }

    private fun formatNumber(n: Float): String {
        return String.format("%.2f", n)
    }

    public fun initClickEvents() {
        btnsumar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    txtResultado.text = "Resultado: " + formatNumber(operaciones.sumar())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })

        btnrestar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    txtResultado.text = "Resultado: " + formatNumber(operaciones.restar())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })

        btnmultiplicar.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    txtResultado.text = "Resultado: " + formatNumber(operaciones.multiplicar())
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })

        btndividir.setOnClickListener(View.OnClickListener {
            try {
                if (validar()) {
                    assignValues()
                    if (operaciones.num2.toInt() == 0) {
                        txtResultado.text = "Resultado: INDEFINIDO"
                    } else {
                        txtResultado.text = "Resultado: " + formatNumber(operaciones.dividir())
                    }
                } else {
                    Toast.makeText(this, "Inserte valores, por favor.", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        })

        btnLimpiar.setOnClickListener(View.OnClickListener {
            txtNum1.text.clear()
            txtNum2.text.clear()
            txtResultado.text = "Resultado: "
        })

        btnCerrar.setOnClickListener(View.OnClickListener { finish() })
    }

}
