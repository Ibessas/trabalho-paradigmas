package Models

import Data.Avaliacao
import Data.Gosto
import Data.Refeicao
import Interfaces.iComensal
import Usuario
import java.util.UUID

class Aluno(
    nome: String,
    email: String,
    senha: String,
    private var insento: Boolean,
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
        if(insento){
            println("Aluno Insento")
            return
        }

        this.creditos = creditos
    }

    override fun comprarRefeicao() {
        if(insento){
            return println("Aluno Insento")
        }
        if(this.creditos <= 0){
            println("Créditos insuficientes")
        }
        this.creditos --
        println("Creditos restantes: ${this.creditos}")
    }
}
