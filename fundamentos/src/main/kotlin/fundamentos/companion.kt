package fundamentos

class MinhaClasse(val nome: String) {
    companion object { // permite criar classe com valores estaticos sem precisar instanciar
        fun criaClasseComValoresPadrao(): MinhaClasse {
            return MinhaClasse("Gustavo")
        }

        fun criarAPartirDaSegundaClasse(segundaClasse: SegundaClasse): MinhaClasse {
            return MinhaClasse(segundaClasse.nome)
        }
    }
}

class SegundaClasse(val nome: String) {
    fun criaClasseComValoresPadrao(): SegundaClasse {
        return SegundaClasse("Gustavo")
    }
}

fun main() {
//    val segundaClasse = SegundaClasse().criaClasseComValoresPadrao();
    val minhaClasse = MinhaClasse.criaClasseComValoresPadrao();
    val segundaClasse = MinhaClasse.criarAPartirDaSegundaClasse(SegundaClasse("Gustavo"));
}