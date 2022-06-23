package fundamentos

class Pessoa(val nome: String, private val idade: Int) {
    override fun toString(): String {
        return "Classe: Pessoa(nome='$nome', idade=$idade)"
    }
}

fun main() {
    val greg = Pessoa("Greg", 22)
    println(greg)
}