package Interfaces

import Data.Gosto
import Models.Cardapio
import Data.Refeicao

interface iComensal {
    fun consultarCardapio(cardapio: Cardapio)
    fun sugerirAlteracao(cardapio: Cardapio, sugestao: String)
    fun avaliarRefeicao(cardapio: Cardapio, refeicao: Refeicao, nota: Gosto)
    fun compraCredito(creditos: Int)
    fun comprarRefeicao()
}

