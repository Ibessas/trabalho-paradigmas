package Models

import Data.Avaliacao
import Data.Gosto
import Data.Refeicao
import Interfaces.iComensal
import Usuario
import java.util.UUID

class Professor(
    nome: String,
    email: String,
    senha: String,
    private var creditos: Int
) : Usuario(UUID.randomUUID().toString(), nome, email, senha), iComensal {

    override fun consultarCardapio(cardapio: Cardapio) {
        println("Models.Aluno ${getNome()} consultando cardápio...")
        cardapio.exibir(false)
    }

    override fun sugerirAlteracao(cardapio: Cardapio, sugestao: String) {
        cardapio.adicionarSugestão(sugestao)
    }

    override fun avaliarRefeicao(cardapio: Cardapio, refeicao: Refeicao, nota: Gosto) {
        val avaliacao: Avaliacao = Avaliacao(UUID.randomUUID().toString(), refeicao, nota)
        cardapio.adicionarAvaliacao(avaliacao)
    }

    override fun compraCredito(creditos: Int) {
        this.creditos = creditos / 2
    }


    override fun comprarRefeicao() {
        if(this.creditos <= 0){
            println("Créditos insuficientes")
        }
        println("Creditos restantes: ${this.creditos}")
    }
}
