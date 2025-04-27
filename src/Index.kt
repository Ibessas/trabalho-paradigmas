import Data.Gosto
import Data.Refeicao
import Models.Aluno
import Models.Cardapio
import Models.Nutricionista
import java.util.UUID

fun main() {
    val nutricionista: Nutricionista = Nutricionista("Nome", "email@mail.com", "1234", mutableListOf<Cardapio>())
    val israel: Aluno = Aluno("Israel", "israel@mail.com", "1234", 30)
    val lucas: Aluno = Aluno("Lucas", "lucas@mail.com", "1234", 30)

    val refCB: Refeicao = Refeicao(UUID.randomUUID().toString(), "Carne Branca", listOf("Frango, Molho, Sal"), 200)
    val refCV: Refeicao =
        Refeicao(UUID.randomUUID().toString(), "Carne Vermelha", listOf("Carne de Boi, Sal, Alho"), 210)
    val refV: Refeicao = Refeicao(UUID.randomUUID().toString(), "Vegetariano", listOf("Soja, Sal, Alho, Molho"), 150)

    nutricionista.cadastrarRefeicao(refCB)
    nutricionista.cadastrarRefeicao(refCV)
    nutricionista.cadastrarRefeicao(refV)

    val cardapio: Cardapio = nutricionista.pegarCardapio()

    val gostos: List<Gosto> = listOf(Gosto.RUIM, Gosto.NORMAL, Gosto.BOM)

    for (i in 1..100000) {
        israel.pagarAlimentação()
        israel.avaliarRefeicao(
            cardapio,
            cardapio.getRefeicoes()[(0 .. cardapio.getRefeicoes().size - 1).random()],
            gostos[(0..gostos.size - 1).random()]
        )
    }

    for (i in 1..100000) {
        lucas.pagarAlimentação()
        lucas.avaliarRefeicao(
            cardapio,
            cardapio.getRefeicoes()[(0 .. cardapio.getRefeicoes().size - 1).random()],
            gostos[(0..gostos.size - 1).random()]
        )
    }
    cardapio.exibir()

}
