package cl.golan.golancapturador

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentes()

        /**
         * Evento al tocar el botón Agregar.
         */
        btnAgregar.setOnClickListener {
            txtCodigoBarra.requestFocus()
        }

        /**
         * Evento al tocar el botón Traspasar Datos.
         */
        btnTraspasarDatos.setOnClickListener {
            // Crear hilo que contenga la lógica, así  no se pega la app
            txtCodigoBarra.requestFocus()
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