package cl.golan.capturator.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.widget.AdapterView.OnItemLongClickListener
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
                alerta.setIcon(android.R.drawable.ic_dialog_alert)
                alerta.setTitle("Aviso")
                alerta.setMessage("Ingrese una cantidad mayor que 0 y menor que 1000000.")
                alerta.show()

                txtCodigoBarra.requestFocus()

                return@setOnClickListener
            }

            // Validar ingreso de código de barra
            if (codigoBarra.isEmpty() || codigoBarra.length < 6) {
                var alerta = AlertDialog.Builder(this)
                alerta.setCancelable(true)
                alerta.setIcon(android.R.drawable.ic_dialog_alert)
                alerta.setTitle("Aviso")
                alerta.setMessage("Ingrese un código de barras de a lo menos 6 dígitos.")
                alerta.show()

                txtCodigoBarra.requestFocus()

                return@setOnClickListener
            }

            // Crear objeto CodigoBarras a partir del código y cantidad ingresado
            val codigo = CodigoBarras(codigoBarra, cantidad)

            // Si ya está agregado sumarlo, de lo contrario se agrega a la lista
            if (datos.contains(codigo)) {
                for (cb in datos) {
                    if (codigo.equals(cb)) {
                        cb.cantidad = (cb.cantidad.toInt() + codigo.cantidad.toInt()).toString()
                    }
                }
            } else {
                datos.add(codigo)
            }

            val adaptador =
                ArrayAdapter<CodigoBarras>(this, android.R.layout.simple_list_item_1, datos)
            lista.adapter = adaptador

            Toast.makeText(
                this,
                "Se agregó: " + codigoBarra + " x " + txtCantidad.text.toString(),
                Toast.LENGTH_SHORT
            ).show()

            txtCantidad.setText("1")
            txtCodigoBarra.setText("")
            txtCodigoBarra.requestFocus()
        }

        /**
         * Evento al tocar el botón Traspasar Datos.
         */
        btnEnviarDatos.setOnClickListener {
            // Crear hilo que contenga la lógica, así  no se pega la app

            txtCodigoBarra.requestFocus()

            var alerta = AlertDialog.Builder(this)
            alerta.setCancelable(true)
            alerta.setTitle("Aviso")
            alerta.setMessage("Conecte el dispositivo al PC.")
            alerta.show()
        }

        /**
         * Evento al tocar el botón Limpiar.
         */
        btnLimpiar.setOnClickListener {

            datos.clear()
            val adaptador = ArrayAdapter<CodigoBarras>(this, android.R.layout.simple_list_item_1, datos)
            lista.adapter = adaptador

            txtCodigoBarra.setText("")
            txtCantidad.setText("1")
            txtCodigoBarra.requestFocus()
        }
        
        lista.setOnItemLongClickListener(OnItemLongClickListener { arg0, arg1, pos, id ->
            Toast.makeText(
                this,
                "SAPBE!!",
                Toast.LENGTH_SHORT
            ).show()
            true
        })
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


