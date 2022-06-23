package fundamentos

fun retornaNumeroPorExtenso(num: Int): String {
    if (num == 5) {
        return "cinco"
    } else if (num == 6) {
        return "seis"
    }
    return "Outro valor"
}

fun main() {
    println(retornaNumeroPorExtenso(12))
}