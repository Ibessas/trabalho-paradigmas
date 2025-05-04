package Models

import Data.Avaliacao
import Data.Gosto
import Data.Refeicao
import java.util.Date

class Cardapio(private val data: Date) {
    private val refeicoes: MutableList<Refeicao> = mutableListOf()
    private val avaliacoes: MutableList<Avaliacao> = mutableListOf()
    private val sugestoes: MutableList<String> = mutableListOf()

    fun getData(): Date = data;
    fun getRefeicoes(): MutableList<Refeicao> = refeicoes;

    fun adicionarRefeicao(refeicao: Refeicao) {
        refeicoes.add(refeicao)
    }

    private fun exibirVotos(aval: List<Avaliacao?>) {
        if (aval.size > 0) {
            println("  ${aval[0]?.refeicao?.nome} - ${aval[0]?.nota} - ${aval.count()} votos")
        }
    }

    fun exibir() {
        for (ref in refeicoes) {
            println("- ${ref.id} ${ref.nome} (${ref.calorias} kcal) (${ref.ingredientes.joinToString(", ")})")
            if (avaliacoes.size > 0) {
                val avB: List<Avaliacao?> = avaliacoes.filter { ref.id == it.refeicao.id && it.nota == Gosto.BOM }
                val avN: List<Avaliacao?> = avaliacoes.filter { ref.id == it.refeicao.id && it.nota == Gosto.NORMAL }
                val avR: List<Avaliacao?> = avaliacoes.filter { ref.id == it.refeicao.id && it.nota == Gosto.RUIM }
                exibirVotos(avB)
                exibirVotos(avN)
                exibirVotos(avR)
            }
        }
        if (sugestoes.size > 0) {
            println("- Sugetsões: ")
            sugestoes.forEach({ println("- ${it}") })
        }
    }

    fun atualizarRefeicao(id: String, novaRefeicao: Refeicao): Boolean {
        val index = refeicoes.indexOfFirst { it.id == id }
        return if (index >= 0) {
            refeicoes[index] = novaRefeicao
            true
        } else {
            false
        }
    }

    fun adicionarSugestão(sugestao: String) {
        sugestoes.add(sugestao)
        print("Sugestão: ${sugestao} adicionada!")
    }

    fun adicionarAvaliacao(avaliacao: Avaliacao) {
        avaliacoes.add(avaliacao)
        println("Avaliação adicionada!")
    }

}
