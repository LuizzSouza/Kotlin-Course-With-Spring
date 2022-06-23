package fundamentos

fun main(): Unit { // pode omitir : Unit
    dizOi(retornaNome(), 22)
    dizOi(idade = 12, nome = "João")
    dizOi("Gretzky")
}

fun retornaNome(): String {
    return "Greg"
}

fun dizOi(nome: String, idade: Int = 18) {
    println("Oi, $nome! Você tem $idade anos.")
}