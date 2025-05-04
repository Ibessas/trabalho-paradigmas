import Data.Gosto
import Data.Refeicao
import Models.Aluno
import Models.Cardapio
import Models.Nutricionista
import java.util.Scanner
import java.util.UUID

fun main() {
    val nutricionista: Nutricionista = Nutricionista("Nome", "email@mail.com", "1234", mutableListOf<Cardapio>())
    val israel: Aluno = Aluno("Israel", "israel@mail.com", "1234", 30)
    val lucas: Aluno = Aluno("Lucas", "lucas@mail.com", "1234", 30)
    val cardapio = nutricionista.pegarCardapio()
    val usuarios = mutableListOf<Usuario>(nutricionista, israel, lucas)
    val gostos: List<Gosto> = listOf(Gosto.RUIM, Gosto.NORMAL, Gosto.BOM)
    val refCB: Refeicao = Refeicao(UUID.randomUUID().toString(), "Carne Branca", listOf("Frango, Molho, Sal"), 200)
    val refCV: Refeicao =
        Refeicao(UUID.randomUUID().toString(), "Carne Vermelha", listOf("Carne de Boi, Sal, Alho"), 210)
    val refV: Refeicao = Refeicao(UUID.randomUUID().toString(), "Vegetariano", listOf("Soja, Sal, Alho, Molho"), 150)

    nutricionista.cadastrarRefeicao(refCB)
    nutricionista.cadastrarRefeicao(refCV)
    nutricionista.cadastrarRefeicao(refV)

    var usuarioLogado: Usuario? = null

    var rodando = true
    do {

        println("Sistema de gerenciamento do RU")
        println("Selecione ação\n 1 - Entrar\n 2 - Sair")
        val test = readln().trim().toInt()
        when (test) {
            1 -> {
                var login: Boolean = true
                do {
                    println("Insira seu email")
                    val email = readln().trim()
                    println("Insira sua senha")
                    val senha = readln().trim()


                    for (user in usuarios) {
                        if (user.autenticar(email, senha)) {
                            usuarioLogado = user
                            login = false
                            println("Logado com sucesso")
                        }
                    }
                    if (usuarioLogado === null) {
                        println("Autenticação inválida\n Deseja tentar novamente?\n 1 - Sim\n 2 - Não")
                        login = readln().trim().toInt() == 1
                    }
                } while (login)
            }

            else -> {
                println("Fechando sistema")
                return
            }
        }

        if (usuarioLogado !== null) {
            if (usuarioLogado is Aluno) {
                while (usuarioLogado !== null && usuarioLogado is Aluno) {
                    println("Escolha uma opção abaixo\n1 - Consultar cadrapio\n2 - Sugerir alteração\n3 - Avaliar refeição\n4 - Pagar alimentação\n5 - Sair")
                    val escolha = readln().trim().toInt()
                    when (escolha) {
                        1 -> usuarioLogado.consultarCardapio(cardapio)
                        2 -> {
                            print("Insira sua sugestão: ")
                            usuarioLogado.sugerirAlteracao(cardapio, readln())
                            println("Sugestão salva com sucesso")
                        }

                        3 -> {
                            println("Selecione a refeicao")
                            var auxCont = 0
                            for (ref in cardapio.getRefeicoes()) {
                                println("${auxCont} - ${ref.nome}")
                                auxCont++
                            }
                            auxCont = 0
                            val refSelecionada = readln().trim().toInt()

                            println("Selecione o gosto")
                            for (gosto in gostos) {
                                println("${auxCont} - ${gosto.name}")
                                auxCont++
                            }

                            val gostoSelecionado = readln().trim().toInt()

                            usuarioLogado.avaliarRefeicao(
                                cardapio,
                                cardapio.getRefeicoes()[refSelecionada],
                                gostos[gostoSelecionado]
                            )
                        }

                        4 -> usuarioLogado.pagarAlimentação()
                        5 -> usuarioLogado = null
                        else -> {
                            println("Opção inválida, tente novamente")
                        }
                    }
                }
            }
            if (usuarioLogado is Nutricionista) {
                while (usuarioLogado !== null && usuarioLogado is Nutricionista) {
                    println("Escolha uma opção abaixo\n1 - Cadastrar Refeição\n2 - Alterar Refeição\n3 - Consultar Cardápio\n4 - Mostrar Relatório\n5 - Sair")
                    val escolha = readln().trim().toInt()
                    when (escolha) {
                        1 -> {
                            println("Qual o nome da refeição? ")
                            val nome = readln().trim()
                            println("Quais os ingredientes? (separe-os por ',') ")
                            val ingredientes = readln().split(',')
                            println("Quantas calorias tem a refeição?")
                            val calorias = readln().toInt()
                            val novaRef: Refeicao = Refeicao(UUID.randomUUID().toString(), nome, ingredientes, calorias)

                            nutricionista.cadastrarRefeicao(novaRef)
                        }
                        2 -> {
                            var tentarIdNovamente = true
                            var ref: Refeicao?
                            var id = ""
                            do {
                                nutricionista.gerarRelatorioNutricional(nutricionista.pegarCardapio())
                                print("\nDigite o Id da refeição que deseja alterar: ")
                                id = readln()
                                ref = nutricionista.pegarRefeicaoPeloId(id)
                                if (ref == null) {
                                    println("Refeição não encontrada, deseja tentar novamente?\n1 - Sim\n2 - Não")
                                    tentarIdNovamente = readln().toInt() == 1
                                } else {
                                    tentarIdNovamente = false
                                }
                            } while (tentarIdNovamente)

                            println("Escolha qual atributo deseja alterar:\n1 - Nome\n2 - Ingredientes\n3 - Calorias")
                            val atributo = readln().toInt()
                            when (atributo) {
                                1 -> {
                                    println("Digite o novo nome")
                                    if (ref != null) {
                                        nutricionista.alterarRefeicao(
                                            id,
                                            Refeicao(ref.id, readln().trim(), ref.ingredientes, ref.calorias)
                                        )
                                    }
                                }

                                2 -> {
                                    println("Digite os ingredientes separados por ',':")
                                    if (ref != null) {
                                        nutricionista.alterarRefeicao(
                                            id,
                                            Refeicao(ref.id, ref.nome, readln().split(','), ref.calorias)
                                        )
                                    }

                                }

                                3 -> {
                                    println("Digite a nova quantidade de calorias:")
                                    if (ref != null) {
                                        nutricionista.alterarRefeicao(
                                            id,
                                            Refeicao(ref.id, ref.nome, ref.ingredientes, readln().toInt())
                                        )
                                    }

                                }
                            }
                        }
                        3 -> {
                            nutricionista.consultarCardapio()
                        }
                        4 -> {
                            nutricionista.gerarRelatorioNutricional(nutricionista.pegarCardapio())
                        }
                        5 -> {
                            usuarioLogado = null
                        }
                    }
                }
            }
        }


    } while (rodando)


//
//    val cardapio: Cardapio = nutricionista.pegarCardapio()
//
//    val gostos: List<Gosto> = listOf(Gosto.RUIM, Gosto.NORMAL, Gosto.BOM)
//
//    for (i in 1..10) {
//        israel.pagarAlimentação()
//        israel.avaliarRefeicao(
//            cardapio,
//            cardapio.getRefeicoes()[(0 .. cardapio.getRefeicoes().size - 1).random()],
//            gostos[(0..gostos.size - 1).random()]
//        )
//    }
//
//    israel.sugerirAlteracao(cardapio,  "Teste" )
//
//    for (i in 1..10) {
//        lucas.pagarAlimentação()
//        lucas.avaliarRefeicao(
//            cardapio,
//            cardapio.getRefeicoes()[(0 .. cardapio.getRefeicoes().size - 1).random()],
//            gostos[(0..gostos.size - 1).random()]
//        )
//    }
//    cardapio.exibir()

}
