package fundamentos

fun main() {
//    val lista = listOf(1, 2, 3, 4, 5, 6);
//    val pares = lista.filter { it % 2 == 0 };
//    val primeiroPar = lista.first { it % 2 == 0 };
//    lista.forEach { println(it) }
//
//    println(pares);
//    println(primeiroPar);
//
//    for (num in lista) {
//        println(num);
//    }
//
//    println(lista[0]);
//    println(lista.get(0));
//    println(lista.size);
//    println(lista.indexOf(3));
// ==============================
//    val lista = mutableListOf(1, 3, 10, 4, 2, 5);
//    println(lista);
//    lista.add(7);
//    lista.add(8);
//    println(lista);
//    lista.remove(3);
//    lista.removeAt(0);
//    lista.sort();
//    println(lista);
//    lista.shuffle();
//    println(lista);
// =============================
//    val setNumeros = mutableSetOf(1, 2, 3, 4, 5, 6); // setOf
//    println(setNumeros);
//    println(setNumeros.contains(2));

    val map = mutableMapOf("Gustavo" to 24, "João" to 23, "Maria" to 22); // map == associative array (sem chaves duplicadas)
    map.put("Pedro", 25); // map["Pedro"] = 25;
    map.remove("Gustavo");
    map.putIfAbsent("João", 26); // não muda valor caso já tenha chave
    println(map);
}