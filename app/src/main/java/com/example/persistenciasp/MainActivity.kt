package com.example.persistenciasp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
//Comentario
    private val code = ""
    private val name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guardar = findViewById<Button>(R.id.btnSave)
        val buscar = findViewById<Button>(R.id.btnSearch)
        val rut =  findViewById<EditText>(R.id.txtCode)
        val nombre =  findViewById<EditText>(R.id.txtNombre)
        val spName = getSharedPreferences(name, Context.MODE_PRIVATE)

        guardar.setOnClickListener {
            val sp = spName.edit()
            sp.putString(rut.text.toString(), nombre.text.toString())
            sp.apply()
            rut.setText("")
            nombre.setText("")
        }

        buscar.setOnClickListener {
            val sp = spName.getString(rut.text.toString(), "")

            if (sp!!.length>0)
            {
              nombre.setText(sp)
            }
            else
            {
                Toast.makeText(this, "No existe el usuario", Toast.LENGTH_LONG).show()
                Alerta("No existe el usuario")
            }
        }
    }

    fun Alerta(mensaje: String)
    {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Preferencias")
        builder.setMessage(mensaje)
        builder.create().show()

    }

}