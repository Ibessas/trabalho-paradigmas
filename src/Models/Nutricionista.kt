package Models

import Data.Refeicao
import Interfaces.IAcoesNutricionista
import Usuario
import java.time.Instant
import java.util.*

class Nutricionista(
    nome: String,
    email: String,
    senha: String,
    private val cardapios: MutableList<Cardapio>
) : Usuario(UUID.randomUUID().toString(), nome, email, senha), IAcoesNutricionista {

    override fun cadastrarRefeicao(refeicao: Refeicao) {
        println("Refeicão cadastrada: ${refeicao.nome}")
        pegarCardapio().adicionarRefeicao(refeicao)
    }

    override fun alterarRefeicao(idRefeicao: String, novaRefeicao: Refeicao) {
        pegarCardapio().atualizarRefeicao(idRefeicao, novaRefeicao)
    }

    override fun consultarCardapio() {
        pegarCardapio().exibir()
    }

    override fun pegarCardapio(): Cardapio {
        val today: Date = Date.from(Instant.now())
        if (cardapios.size > 0) {
            val lastData: Date = cardapios[0].getData()

            if (lastData.date == today.date &&
                lastData.month == today.month &&
                lastData.year == today.year
            ) {
                return cardapios[0]
            }
        }
        val cardapio = Cardapio(today)
        cardapios.add(cardapio)
        return cardapio
    }

    fun pegarRefeicaoPeloId(id: String): Refeicao? {
        cardapios.forEach { cardapio ->
            val res = cardapio.getRefeicoes().find { refeicao -> refeicao.id == id }
            if(res != null){
                return res
            }
        }
        return null
    }

    fun gerarRelatorioNutricional(cardapio: Cardapio) {
        for (el in cardapios) {
            el.exibir()
        }
    }
}
