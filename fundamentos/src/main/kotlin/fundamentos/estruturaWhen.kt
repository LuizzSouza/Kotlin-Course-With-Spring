package fundamentos

fun main() {

//    when (10) {
//        1 -> println("um")
//        2 -> println("dois")
//        3 -> println("tres")
//        4 -> println("quatro")
//        5 -> println("cinco")
//        10 -> {
//            println("dez")
//            println("dezena")
//        }
//        5 -> println("cinco de novo")
//
//        in 11..15 -> println("onze ate quinze")
//        !in 16..20 -> println("maior que dezesseis e menor que vinte")
//        else -> println("outro")
//    }

    when {
        comecaComOi("Oi") -> println("começa com oi")
        comecaComOi(5) -> println("cinco")
    }
}

fun comecaComOi(x: Any): Boolean {
    return when(x) {
        is String -> x.lowercase().startsWith("oi")
        else -> false
    }
}