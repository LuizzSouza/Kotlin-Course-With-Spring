package fundamentos

fun main() {
    val pessoa: Pessoa? = Pessoa("João", 24);

    print(pessoa!!.nome)
}