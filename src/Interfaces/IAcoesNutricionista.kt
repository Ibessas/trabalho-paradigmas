package Interfaces

import Data.Refeicao
import Models.Cardapio

interface IAcoesNutricionista {
    fun cadastrarRefeicao(refeicao: Refeicao)
    fun alterarRefeicao(idRefeicao: String, novaRefeicao: Refeicao)
    fun consultarCardapio()
    fun pegarCardapio(): Cardapio;
}
