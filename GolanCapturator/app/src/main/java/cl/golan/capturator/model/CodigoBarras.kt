package cl.golan.capturator.model

class CodigoBarras(codigo: String, cantidad: String) {

    var codigo: String = ""
    var cantidad: String = ""

    init {
        this.codigo = codigo
        this.cantidad = cantidad
    }

    override fun toString(): String {
        return "$codigo - $cantidad unid."
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CodigoBarras

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return codigo.hashCode()
    }

}