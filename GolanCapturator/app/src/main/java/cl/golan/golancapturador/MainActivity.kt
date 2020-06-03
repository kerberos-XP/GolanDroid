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
         * Eventos al tocar el botón checkCantidadUnitaria.
         */
        checkCantidadUnitaria.setOnClickListener {
            if (checkCantidadUnitaria.isChecked) {
                txtCantidad.setText("1")
                txtCodigoBarra.requestFocus()
            } else {
                txtCantidad.setText("")
                txtCantidad.requestFocus()
            }
        }

        /**
         * Eventos al tocar el botón checkCantidadUnitaria.
         */
        btnAgregar.setOnClickListener {
            txtCodigoBarra.requestFocus()
        }

        /**
         * Eventos al tocar el botón checkCantidadUnitaria.
         */
        btnTraspasarDatos.setOnClickListener {
            // Crear hilo que contenga la lógica para que no se pega la app
            txtCodigoBarra.requestFocus()
        }
    }

    /**
     * Inicializar componentes de la interfaz de usuario.
     */
    private fun inicializarComponentes() {
        txtCantidad.setText("1")
        txtCodigoBarra.setGravity(Gravity.CENTER)
        checkCantidadUnitaria.setChecked(true)
        txtCodigoBarra.requestFocus()
    }

}