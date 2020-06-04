package cl.golan.capturator.model

class CodigoBarras(codigo: String, cantidad: String) {
    var codigo: String = ""
    var cantidad: String = ""

    init {
        this.codigo = codigo
        this.cantidad = cantidad
    }
}