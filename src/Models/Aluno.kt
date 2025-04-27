package Models

import Data.Avaliacao
import Data.Gosto
import Data.Refeicao
import Interfaces.IAcoesAluno
import Usuario
import java.util.UUID

class Aluno(
    nome: String,
    email: String,
    senha: String,
    private var creditos: Int
) : Usuario(UUID.randomUUID().toString(), nome, email, senha), IAcoesAluno {

    override fun consultarCardapio(cardapio: Cardapio) {
        println("Models.Aluno ${getNome()} consultando cardápio...")
        cardapio.exibir()
    }

    override fun sugerirAlteracao(cardapio: Cardapio, sugestao: String) {
        cardapio.adicionarSugestão(sugestao)
    }

    override fun avaliarRefeicao(cardapio: Cardapio, refeicao: Refeicao, nota: Gosto) {
        val avaliacao: Avaliacao = Avaliacao(UUID.randomUUID().toString(), refeicao, nota)
        cardapio.adicionarAvaliacao(avaliacao)
    }

    fun pagarAlimentação() {
        creditos = creditos - 1;
        println("Créditos restantes: ${creditos}");
    }
}
