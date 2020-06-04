package cl.golan.capturator.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.golan.activities.R
import cl.golan.capturator.model.CodigoBarras
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val datos = ArrayList<CodigoBarras>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentes()

        /**
         * Evento al tocar el botón Agregar.
         */
        btnAgregar.setOnClickListener {

            var codigoBarra = txtCodigoBarra.text.toString()
            var cantidad = txtCantidad.text.toString()

            // Validar ingreso de cantidad
            if (cantidad.isEmpty() || cantidad.equals("0")) {
                var alerta = AlertDialog.Builder(this)
                alerta.setCancelable(true)
                alerta.setTitle("Aviso")
                alerta.setMessage("Ingrese una cantidad mayor que 0 y menor que 1000000.")
                alerta.show()
                return@setOnClickListener
            }

            // Validar ingreso de código de barra
            if (codigoBarra.isEmpty() || codigoBarra.length < 6) {
                var alerta = AlertDialog.Builder(this)
                alerta.setCancelable(true)
                alerta.setTitle("Aviso")
                alerta.setMessage("Ingrese un código de barra de a lo menos 6 dígitos.")
                alerta.show()
                return@setOnClickListener
            }

            val cb = CodigoBarras(codigoBarra, cantidad)
            datos.add(cb)

            val adaptador = ArrayAdapter<CodigoBarras>(this, android.R.layout.simple_list_item_1, datos)
            lista.adapter = adaptador

            txtCantidad.setText("1")
            txtCodigoBarra.setText("")
            txtCodigoBarra.requestFocus()

            Toast.makeText(
                this,
                "Se agregó: " + codigoBarra + " x " + txtCantidad.text.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }

        /**
         * Evento al tocar el botón Traspasar Datos.
         */
        btnTraspasarDatos.setOnClickListener {
            // Crear hilo que contenga la lógica, así  no se pega la app

            txtCodigoBarra.setText("")
            txtCantidad.setText("1")
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