package fundamentos

class Carro(var cor: String, val anoFabricacao: Int, val dono: Dono) {

}

data class Dono(var nome: String, var idade: Int)

fun main() {
    val carro = Carro("Amarelo", 2019, Dono("Greg", 22))
    println(carro.cor)
    carro.cor = "Azul"
    println(carro.cor)

    println(carro.dono.nome)
    carro.dono.nome = "Daniel"
    println(carro.dono)
}