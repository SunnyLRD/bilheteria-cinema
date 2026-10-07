// Sistema de Bilheteria - Rede de Cinemas
// Conceitos: POO, tipos básicos, if/else, when, for e null safety (Elvis)

// ---------- Modelagem (POO) ----------

class Filme(
    val titulo: String,
    val genero: String,
    val valorBase: Double
)

class Ingresso(
    val filme: Filme,
    val assento: String,
    val eEstudante: Boolean
) {
    // Meia-entrada (if/else): estudante paga 50% do valor base
    fun calcularValor(): Double {
        return if (eEstudante) {
            filme.valorBase * 0.5
        } else {
            filme.valorBase
        }
    }
}

class Cliente(
    val nome: String,
    val voucherPipoca: String? = null // opcional (String?)
)

// ---------- Regras de negócio ----------

// Venda de múltiplos ingressos (laço for)
fun calcularTotal(carrinho: List<Ingresso>): Double {
    var total = 0.0
    for (ingresso in carrinho) {
        total += ingresso.calcularValor()
    }
    return total
}

// Classificação indicativa (when) com base no gênero
fun classificacaoEtaria(genero: String): String {
    return when (genero.lowercase()) {
        "animação", "infantil" -> "Livre"
        "comédia" -> "10 anos"
        "aventura", "ação" -> "12 anos"
        "drama" -> "14 anos"
        "terror" -> "16 anos"
        else -> "Consultar bilheteria"
    }
}

// Voucher de pipoca (Null Safety + operador Elvis)
fun descricaoBrinde(cliente: Cliente): String {
    return cliente.voucherPipoca ?: "Sem brinde"
}

// ---------- Execução ----------

fun processarVenda(cliente: Cliente, carrinho: List<Ingresso>) {
    println("Cliente: ${cliente.nome}")

    for (ingresso in carrinho) {
        val tipo = if (ingresso.eEstudante) "Meia" else "Inteira"
        println(
            "  Assento ${ingresso.assento} | ${ingresso.filme.titulo} " +
                "(${ingresso.filme.genero}, ${classificacaoEtaria(ingresso.filme.genero)}) " +
                "| $tipo | R$ ${"%.2f".format(ingresso.calcularValor())}"
        )
    }

    val quantidade: Int = carrinho.size
    val total = calcularTotal(carrinho)
    println("  Ingressos: $quantidade")
    println("  Total: R$ ${"%.2f".format(total)}")
    println("  Brinde: ${descricaoBrinde(cliente)}")
    println()
}

fun main() {
    val filme1 = Filme("Super Aventura", "Animação", 30.0)
    val filme2 = Filme("Noite Sombria", "Terror", 40.0)

    // Cliente com voucher
    val ana = Cliente("Ana", "Pipoca média grátis")
    val carrinhoAna = listOf(
        Ingresso(filme1, "A1", true),
        Ingresso(filme1, "A2", false)
    )

    // Cliente sem voucher (null)
    val bruno = Cliente("Bruno")
    val carrinhoBruno = listOf(
        Ingresso(filme2, "C5", false),
        Ingresso(filme2, "C6", true),
        Ingresso(filme2, "C7", true)
    )

    processarVenda(ana, carrinhoAna)
    processarVenda(bruno, carrinhoBruno)
}
