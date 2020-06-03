package cl.golan.golancapturador

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val datos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentes()

        /**
         * Evento al tocar el botón Agregar.
         */
        btnAgregar.setOnClickListener {

            var codigoBarra = txtCodigoBarra.text.toString()
            datos.add(codigoBarra)


            txtCodigoBarra.setText("")
            txtCodigoBarra.requestFocus()

            Toast.makeText(this, "Se agregó: " + codigoBarra + " x 1",
                Toast.LENGTH_SHORT).show()
        }

        /**
         * Evento al tocar el botón Traspasar Datos.
         */
        btnTraspasarDatos.setOnClickListener {
            // Crear hilo que contenga la lógica, así  no se pega la app

            txtCodigoBarra.setText("")
            txtCodigoBarra.requestFocus()

            var alerta = AlertDialog.Builder(this)
            alerta.setCancelable(true)
            alerta.setTitle("Aviso")
            alerta.setMessage("Conecte el dispositivo al PC.")
            alerta.show()
        }
    }

    /**
     * Inicializar componentes de la interfaz de usuario.
     */
    private fun inicializarComponentes() {
        txtCantidad.setText("1")
        txtCodigoBarra.setGravity(Gravity.CENTER)
        txtCodigoBarra.requestFocus()
    }

}