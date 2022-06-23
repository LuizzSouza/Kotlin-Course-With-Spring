package fundamentos

fun main() {
    println(parOuImpar(2))
    println(parOuImpar(13))

    println(resultadoDaNota(6.5))
    println(resultadoDaNota(4.2))
    println(resultadoDaNota(2.5))
}

fun parOuImpar(num: Int): String = if (num % 2 == 0) "par" else "impar"

// > 6 === passou
// > 4 === recuperação
// < 4 === reprovou
fun resultadoDaNota(nota: Double): String {
    return if (nota >= 6) {
        "passou"
    } else if (nota >= 4) {
        "recuperação"
    } else {
        "reprovou"
    }
}