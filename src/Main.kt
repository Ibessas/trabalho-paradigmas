//import kotlin.math.pow
//import kotlin.math.sqrt
//
//fun main() {
//    // Função auxiliar para verificar os resultados dos testes (não modifique)
//    fun assertEquals(funcao: String, esperado: Any, resultado: Any) {
//        if (esperado != resultado) {
//            throw AssertionError("Falha em $funcao: Esperado $esperado, Obtido $resultado")
//        }
//    }
//
//    // LISTA 1
//    /**
//     * Forneça a função `celsiusToFahrenheit` que recebe uma temperatura em graus Celsius e retorna esta temperatura convertida em graus Fahrenheit.
//     * Fórmula de conversão: F = (9/5)?C+32, onde C é a temperatura em Celsius, e F é a temperatura em Fahrenheit.
//     * Ex.: celsiusToFahrenheit(10.0) retorna 50.0.
//     */
//    fun celsiusToFahrenheit(celsius: Double): Double {
//        return (9.0/5)*celsius+32
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("celsiusToFahrenheit(10.0)", 50.0, celsiusToFahrenheit(10.0))
//    assertEquals("celsiusToFahrenheit(0.0)", 32.0, celsiusToFahrenheit(0.0))
//    assertEquals("celsiusToFahrenheit(5.5)", 41.9, celsiusToFahrenheit(5.5))
//    println("Todos os testes passaram para a função celsiusToFahrenheit!")
//
//    /**
//     * Forneça a função `mediaPonderada` que recebe 3 notas (1a prova, 2a prova e trabalho, nesta ordem) e retorna a média ponderada desta notas.
//     * A 1a prova tem peso 5, a 2a prova tem peso 3, e o trabalho tem peso 2.
//     * Ex: mediaPonderada(8.5, 6, 7) retorna 7.45, pois, (5*8.5 + 3*6 + 2*7) / 10 = 7.45.
//     */
//    fun mediaPonderada(prova1: Double, prova2: Double, trabalho: Double): Double {
//        return (5*prova1+3*prova2+2*trabalho)/10
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("mediaPonderada(8.5, 6, 7)", 7.45, mediaPonderada(8.5, 6.0, 7.0))
//    assertEquals("mediaPonderada(5.0, 5.0, 5.0)", 5.0, mediaPonderada(5.0, 5.0, 5.0))
//    assertEquals("mediaPonderada(1.0, 2.0, 3.0)", 1.7, mediaPonderada(1.0, 2.0, 3.0))
//    println("Todos os testes passaram para a função mediaPonderada!")
//
//    /**
//     * Forneça a função `conversaoTempo` que recebe um tempo total em segundos e retorna um Pair contendo este tempo em horas e minutos, e o restante em segundos.
//     * Ex.: conversaoTempo(7384) retorna Triple(2, 3, 4), pois 7384 segundos = 2 horas, 3 minutos e 4 segundos.
//     */
//    fun conversaoTempo(segundosTotais: Int): Triple<Int, Int, Int> {
//        return Triple( (segundosTotais/60)/60, (segundosTotais/60)%60,segundosTotais%60)
//    }
//
//    assertEquals("conversaoTempo(7384)", Triple(2, 3, 4), conversaoTempo(7384))
//    assertEquals("conversaoTempo(60)", Triple(0, 1, 0), conversaoTempo(60))
//    assertEquals("conversaoTempo(3601)", Triple(1, 0, 1), conversaoTempo(3601))
//    println("Todos os testes passaram para a função conversaoTempo!")
//
//    /**
//     * Forneça a função `premioLoteria` que recebe o valor apostado por cada um dos 3 apostadores, e o prêmio total a ser repartido. Cada apostador ganha uma fração do prêmio proporcional ao valor apostado.
//     * Ex: premioLoteria(10, 20, 30, 1200) retorna Triple(200.0, 400.0, 600.0).
//     * -- Ganho do 1o: 200.0, pois 1200 * (10 / (10+20+30)) = 200
//     * -- Ganho do 2o: 400.0, pois 1200 * (20 / (10+20+30)) = 400
//     * -- Ganho do 3o: 600.0, pois 1200 * (30 / (10+20+30)) = 600
//     */
//    fun premioLoteria(aposta1: Double, aposta2: Double, aposta3: Double, premioTotal: Double): Triple<Double, Double, Double> {
//        val valor = {x:Double -> premioTotal * (x / (aposta1+aposta2+aposta3))}
//        return Triple(valor(aposta1), valor(aposta2), valor(aposta3))
//    }
//
//    assertEquals("premioLoteria(10.0, 20.0, 30.0, 1200.0)", Triple(200.0, 400.0, 600.0), premioLoteria(10.0, 20.0, 30.0, 1200.0))
//    assertEquals("premioLoteria(1.5, 1.5, 1.5, 31.5)", Triple(10.5, 10.5, 10.5), premioLoteria(1.5, 1.5, 1.5, 31.5))
//    assertEquals("premioLoteria(1.0, 2.0, 3.0, 120.0)", Triple(20.0, 40.0, 60.0), premioLoteria(1.0, 2.0, 3.0, 120.0))
//    println("Todos os testes passaram para a função premioLoteria!")
//
//    /**
//     * Forneça a função 'calcularIMC' que recebe o peso e a altura de uma pessoa, e retorna o IMC (Índice de Massa Corporal) dela.
//     * O IMC é calculado pela fórmula: IMC = peso / (altura * altura).
//     * Ex.: calcularIMC(70.0, 1.75) retorna 22.86.
//     */
//    fun calcularIMC(peso: Double, altura: Double): Double {
//        return peso/Math.pow(altura,2.0)
//    }
//
//    assertEquals("calcularIMC(70.0, 1.75)", 22.857142857142858, calcularIMC(70.0, 1.75))
//    assertEquals("calcularIMC(60.0, 1.60)", 23.437499999999996, calcularIMC(60.0, 1.60))
//    assertEquals("calcularIMC(80.0, 1.80)", 24.691358024691358, calcularIMC(80.0, 1.80))
//    println("Todos os testes passaram para a função calcularIMC!")
//
//    // LISTA 2
//    /**
//     * Forneça a função `distancia`, que recebe dois pontos no plano `(x1,y1)` e `(x2,y2)` (ou seja, recebe dois Pairs com dois elementos cada),
//     * e retorna a distância entre estes pontos, dada pela fórmula sqrt((x1?x2)^2+(y1?y2)^2).
//     * Obs.: `sqrt` é a função que fornece a raiz quadrada.
//     * Ex: distancia((3,7), (1,4)) retorna 3.605551275463989.
//     */
//    fun distancia(ponto1: Pair<Double, Double>, ponto2: Pair<Double, Double>): Double {
//        return sqrt(Math.pow(ponto1.first - ponto2.first,2.0) + Math.pow(ponto1.second - ponto2.second,2.0))
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("distancia((3,7), (1,4))", 3.605551275463989, distancia(Pair(3.0, 7.0), Pair(1.0, 4.0)))
//    assertEquals("distancia((7,3), (4,-1))", 5.0, distancia(Pair(7.0, 3.0), Pair(4.0, -1.0)))
//    assertEquals("distancia((1,8), (-4,12))", 6.4031242374328485, distancia(Pair(1.0, 8.0), Pair(-4.0, 12.0)))
//    assertEquals("distancia((0,0), (0,0))", 0.0, distancia(Pair(0.0, 0.0), Pair(0.0, 0.0)))
//    assertEquals("distancia((47.88,43.91), (34.8,40.02))", 13.646189944449699, distancia(Pair(47.88, 43.91), Pair(34.8, 40.02)))
//    println("Todos os testes passaram para a função distancia!")
//
//    /**
//     * Crie uma função que calcule a potencia de um numero (apenas chame uma função da biblioteca padrão).
//     * Obs.: Use a função `pow` para calcular a potência, mas lembre-se que ela retorna um Double.
//     *       Para converter para Int, use a função `toInt()`.
//     * Ex.: calcularPotencia(2, 5) retorna 32.
//     */
//    fun calcularPotencia(base: Int, expoente: Int): Int {
//        return Math.pow(base.toDouble(), expoente.toDouble()).toInt()
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("calcularPotencia(2, 5)", 32, calcularPotencia(2, 5))
//    assertEquals("calcularPotencia(3, 4)", 81, calcularPotencia(3, 4))
//    assertEquals("calcularPotencia(5, 3)", 125, calcularPotencia(5, 3))
//    assertEquals("calcularPotencia(10, 2)", 100, calcularPotencia(10, 2))
//    assertEquals("calcularPotencia(2, 0)", 1, calcularPotencia(2, 0))
//    println("Todos os testes passaram para a função calcularPotencia!")
//
//    /**
//     * Inicialize duas variáveis inteiras com valores recebidos como parâmetro,
//     * troque os valores destas duas variáveis, em seguida retorne um Pair com os valores delas
//     * (na mesma ordem em que foram declaradas).
//     */
//    fun trocarValores(a: Int, b: Int): Pair<Int, Int> {
//        return Pair( b,a)
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("trocarValores(2, 3)", Pair(3, 2), trocarValores(2, 3))
//    assertEquals("trocarValores(1, 2)", Pair(2, 1), trocarValores(1, 2))
//    assertEquals("trocarValores(1, 1)", Pair(1, 1), trocarValores(1, 1))
//    assertEquals("trocarValores(0, 0)", Pair(0, 0), trocarValores(0, 0))
//    println("Todos os testes passaram para a função trocarValores!")
//
//    /**
//     * Dados dois inteiros 'a' e 'b' recebidos como entrada,
//     * retorne um Triple contendo o resultado da divisão inteira, o resto da divisão
//     * e o resultado da divisão fracionária de 'a' por 'b'.
//     */
//    fun calcularDivisao(a: Int, b: Int): Triple<Int, Int, Double> {
//        val res: Double = (a.toDouble()/b)
//        return Triple(res.toInt(), (a % b).toInt() ,res )
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("calcularDivisao(7, 3)", Triple(2, 1, 7.0 / 3.0), calcularDivisao(7, 3))
//    assertEquals("calcularDivisao(10, 2)", Triple(5, 0, 5.0), calcularDivisao(10, 2))
//    assertEquals("calcularDivisao(5, 3)", Triple(1, 2, 5.0 / 3.0), calcularDivisao(5, 3))
//    println("Todos os testes passaram para a função calcularDivisao!")
//
//    /**
//     * Escreva uma função para auxiliar vendedores. A partir de um valor total recebido, retornar:
//     * - o total a pagar com desconto de 10% (para o caso de venda à vista);
//     * - o valor de cada parcela, no parcelamento em 3 x sem juros;
//     * - a comissão do vendedor, no caso da venda ser à vista (5% sobre o valor com desconto )
//     * - a comissão do vendedor, no caso da venda ser parcelada (5% sobre o valor total)
//     */
//    fun calcularValores(valorTotal: Double): Triple<Double, Double, Pair<Double, Double>> {
//        val valorComDesconto: Double = valorTotal - (valorTotal * .1)
//        return Triple(valorComDesconto, valorTotal/3, Pair(valorComDesconto * 0.05, valorTotal * 0.05 ))
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    assertEquals("calcularValores(100.0)", Triple(90.0, 100.0 / 3.0, Pair(4.5, 5.0)), calcularValores(100.0))
//    assertEquals("calcularValores(200.0)", Triple(180.0, 200.0 / 3.0, Pair(9.0, 10.0)), calcularValores(200.0))
//    assertEquals("calcularValores(300.0)", Triple(270.0, 100.0, Pair(13.5, 15.0)), calcularValores(300.0))
//    println("Todos os testes passaram para a função calcularValores!")
//
////LISTA 3
///**
// * Dado um valor inteiro recebido, retorne a string "positivo", "nulo" ou "negativo",
// * dependendo do sinal do valor recebido.
// * Ex.: determinarSinal( 2) retorna "positivo".
// *      determinarSinal(-5) retorna "negativo".
// */
//fun determinarSinal(valor: Int): String {
//    if(valor > 0){
//        return "positivo"
//    }else if(valor < 0){
//        return "negativo"
//    }
//    return "nulo"
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("determinarSinal(2)", "positivo", determinarSinal(2))
//assertEquals("determinarSinal(4)", "positivo", determinarSinal(4))
//assertEquals("determinarSinal(-5)", "negativo", determinarSinal(-5))
//assertEquals("determinarSinal(0)", "nulo", determinarSinal(0))
//assertEquals("determinarSinal(-11)", "negativo", determinarSinal(-11))
//println("Todos os testes passaram para a função determinarSinal!")
//
///**
// * Forneça a função 'calculadora' que recebe dois valores inteiros e um operador em caráter
// * ('+', '-', '*' ou '/')
// * e retorna uma string contendo o resultado da operação (um inteiro convertido para string, se
// * a operação for válida).
// * Se a operação não pode ser realizada, retorna a string "invalida".
// * Ex.: calculadora(2, 3, '+') retorna "5".
// *      calculadora(2, 3, '-') retorna "-1".
// *      calculadora(2, 0, '/') retorna "invalida".
// *      calculadora(2, 3, 'x') retorna "invalida".
// * Obs.: Use 'toString()' para converter o resultado da operação em string.
// */
//fun calculadora(a: Int, b: Int, operador: Char): String {
//    if(operador == '+'){
//        return "${a + b}"
//    }else if(operador=='-'){
//        return "${a - b}"
//    }else if(operador=='*'){
//        return "${a * b}"
//    }else if (operador=='/'){
//        if(a > 0 && b > 0 ) {
//            return "${a / b}"
//        }
//    }
//    return "invalida"
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("calculadora(2, 3, '+')", "5", calculadora(2, 3, '+'))
//assertEquals("calculadora(2, 3, '-')", "-1", calculadora(2, 3, '-'))
//assertEquals("calculadora(2, 3, '*')", "6", calculadora(2, 3, '*'))
//assertEquals("calculadora(2, 3, '/')", "0", calculadora(2, 3, '/'))
//assertEquals("calculadora(2, 0, '/')", "invalida", calculadora(2, 0, '/'))
//assertEquals("calculadora(2, 3, 'x')", "invalida", calculadora(2, 3, 'x'))
//println("Todos os testes passaram para a função calculadora!")
//
///**
// * Forneça a função 'verificarAprovacao' que recebe as notas de 2 provas (P1 e P2) e a nota da
// * prova final (PF), e
// * retorna verdadeiro se o aluno foi aprovado, e falso caso contrário.
// * Seja M a média de P1 e P2.
// * O aluno é aprovado se M >= 7.0, independente da nota fornecido para a prova final.
// * Se 4.0 <= M < 7.0, o aluno é aprovado se PF >= 4.0 e a média entre M e PF for maior ou igual
// * a 5.0.
// * Em todos os os outros casos, o aluno é reprovado.
// * Ex.: verificarAprovacao(7.0, 8.0, 0.0) retorna true.
// *      verificarAprovacao(6.0, 5.0, 3.0) retorna false.
// *      verificarAprovacao(6.0, 5.0, 4.0) retorna false.
// *      verificarAprovacao(6.0, 5.0, 4.5) retorna true.
// */
//fun verificarAprovacao(p1: Double, p2: Double, pf: Double): Boolean {
//    val m = (p1+p2)/2
//    if(m >= 7.0){
//        return true
//    }
//    else if( m < 4.0){
//        return false
//    }else{
//        if(pf >= 4.0){
//            val mf = (m+pf)/2
//            return mf >= 5.0
//        }
//    }
//    return false
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("verificarAprovacao(7.0, 8.0, 0.0)", true, verificarAprovacao(7.0, 8.0, 0.0))
//assertEquals("verificarAprovacao(6.0, 5.0, 3.0)", false, verificarAprovacao(6.0, 5.0, 3.0))
//assertEquals("verificarAprovacao(6.0, 5.0, 4.0)", false, verificarAprovacao(6.0, 5.0, 4.0))
//assertEquals("verificarAprovacao(6.0, 5.0, 4.5)", true, verificarAprovacao(6.0, 5.0, 4.5))
//println("Todos os testes passaram para a função verificarAprovacao!")
//
///**
// * Um funcionário trabalha de segunda a sexta, de 8 até 11:59 e de 14 até 17:59.
// * No sábado, ele trabalha apenas de 8 até 11:59.
// *
// * Forneça a função 'trabalhandoOuNao' que recebe um dia (1 a 7), uma hora (0 a 23) e um minuto
// * (0 a 59) e retorna um booleano indicando se o funcionário está trabalhando ou não.
// * Os dias da semana são representados pelos códigos inteiros abaixo:
// *      1 = DOM, 2 = SEG, 3 = TER, 4 = QUA, 5 = QUI, 6 = SEX, 7 = SAB
// */
//fun trabalhandoOuNao(dia: Int, hora: Int, minuto: Int): Boolean {
//    when(dia){
//        in 2..6 -> {
//            if ((hora in 8..11) || (hora in 14..17)){
//                return true
//            }
//        }
//        7 -> {
//            if((hora in 8..11)){
//                return true
//            }
//        }
//    }
//    return false
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("trabalhandoOuNao(1, 8, 0)", false, trabalhandoOuNao(1, 8, 0))
//assertEquals("trabalhandoOuNao(2, 8, 0)", true, trabalhandoOuNao(2, 8, 0))
//assertEquals("trabalhandoOuNao(2, 11, 59)", true, trabalhandoOuNao(2, 11, 59))
//assertEquals("trabalhandoOuNao(2, 12, 0)", false, trabalhandoOuNao(2, 12, 0))
//assertEquals("trabalhandoOuNao(2, 14, 0)", true, trabalhandoOuNao(2, 14, 0))
//assertEquals("trabalhandoOuNao(7, 14, 0)", false, trabalhandoOuNao(7, 14, 0))
//assertEquals("trabalhandoOuNao(4, 18, 0)", false, trabalhandoOuNao(4, 18, 0))
//println("Todos os testes passaram para a função trabalhandoOuNao!")
//
///**
// * Forneça a função `maiorValor`, que recebe 6 números inteiros e retorna o maior deles.
// * Ex.: maiorValor(5, 2, 4, 1, 3, 6) retorna 6.
// * Dica: declare uma variável auxiliar para armazenar o maior valor encontrado até o momento.
// */
//fun maiorValor(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
//    var maior = -999
//    if(a > maior){
//        maior = a
//    }
//    if(b > maior){
//        maior = b
//    }
//    if(c > maior){
//        maior = c
//    }
//    if(d > maior){
//        maior = d
//    }
//    if(e > maior){
//        maior = e
//    }
//    if(f > maior){
//        maior = f
//    }
//
//    return maior
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("maiorValor(5, 2, 4, 1, 3, 6)", 6, maiorValor(5, 2, 4, 1, 3, 6))
//assertEquals("maiorValor(1, 1, 1, 1, 1, 1)", 1, maiorValor(1, 1, 1, 1, 1, 1))
//assertEquals("maiorValor(1, 2, 3, 4, 5, 0)", 5, maiorValor(1, 2, 3, 4, 5, 0))
//assertEquals("maiorValor(-1, -2, -3, -4, -5, -6)", -1, maiorValor(-1, -2, -3, -4, -5, -6))
//println("Todos os testes passaram para a função maiorValor!")
//
///**
// * Forneça a função `meio`, que recebe 3 números inteiros e retorna o elemento do meio caso os
// * 3 valores sejam colocados em ordem crescente.
// * Ex.: meio(5, 2, 4) retorna 4.
// *      meio(6, 5, 7) retorna 6.
// */
//fun meio(a: Int, b: Int, c: Int): Int {
//    var meio: Int = -1
//
//    if(a > b && a < c || a < b && a > c){
//        meio = a
//    }
//    if(b > a && b < c || b < a && b > c){
//        meio = b
//    }
//    if(c > a && c < b || c < a && c > b){
//        meio = c
//    }
//
//    return meio
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("meio(5, 2, 4)", 4, meio(5, 2, 4))
//assertEquals("meio(6, 5, 7)", 6, meio(6, 5, 7))
//assertEquals("meio(1, 2, 3)", 2, meio(1, 2, 3))
//println("Todos os testes passaram para a função meio!")
//
///**
// * Receba dois inteiros e diga se ambos são divisíveis por 3 ou ambos divisíveis por 5.
// * O valor de retorno é um booleano.
// * Ex.: divisivelPor3ou5(3,  4) retorna false.
// *      divisivelPor3ou5(5, 10) retorna true.
// */
//fun divisivelPor3ou5(a: Int, b: Int): Boolean {
//    val verifica = {x: Int-> (a % x == 0 && b % x == 0)}
//    return verifica(3) || verifica(5)
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//
//assertEquals("divisivelPor3ou5(3, 4)", false, divisivelPor3ou5(3, 4))
//assertEquals("divisivelPor3ou5(5, 0)", true, divisivelPor3ou5(5, 0))
//assertEquals("divisivelPor3ou5(0, 3)", true, divisivelPor3ou5(0, 3))
//assertEquals("divisivelPor3ou5(5, 10)", true, divisivelPor3ou5(5, 10))
//assertEquals("divisivelPor3ou5(5, 9)", false, divisivelPor3ou5(5, 9))
//assertEquals("divisivelPor3ou5(0, 3)", true, divisivelPor3ou5(0, 3))
//assertEquals("divisivelPor3ou5(10, 9)", false, divisivelPor3ou5(10, 9))
//assertEquals("divisivelPor3ou5(15, 45)", true, divisivelPor3ou5(15, 45))
//println("Todos os testes passaram para a função divisivelPor3ou5!")
//
//
///**
// * Receba três valores inteiros. Retorne a quantidade de valores iguais dentre os três.
// * Ex.: quantidadeIguais(3, 3, 1) retorna 2.
// *      quantidadeIguais(4, 4, 4) retorna 3.
// *      quantidadeIguais(1, 3, 2) retorna 0.
// */
//fun quantidadeIguais(a: Int, b: Int, c: Int): Int {
//    var cont = 0
//
//    if(a == b){
//        cont = 2
//        if(b == c){
//            cont++
//        }
//    }
//    else if(a == c){
//        cont = 2
//        if(c == b){
//            cont++
//        }
//    }
//    if(b == c){
//        cont = 2
//        if(c == a)
//            cont++
//    }
//    return cont
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("quantidadeIguais(3, 3, 1)", 2, quantidadeIguais(3, 3, 1))
//assertEquals("quantidadeIguais(1, 3, 3)", 2, quantidadeIguais(1, 3, 3))
//assertEquals("quantidadeIguais(4, 4, 4)", 3, quantidadeIguais(4, 4, 4))
//assertEquals("quantidadeIguais(1, 5, 1)", 2, quantidadeIguais(1, 5, 1))
//assertEquals("quantidadeIguais(1, 3, 2)", 0, quantidadeIguais(1, 3, 2))
//assertEquals("quantidadeIguais(6, 5, 4)", 0, quantidadeIguais(6, 5, 4))
//println("Todos os testes passaram para a função quantidadeIguais!")
//
///**
// * Dada uma equação do 2o grau, calcule as raízes reais da equação.
// * Entrada: 3 valores ponto flutuante, corresponde aos parâmetros 'a', 'b' e 'c' de uma equação
// *          do 2o grau.
// * Saída: Uma tupla contendo um booleano (verdadeiro apenas se há raízes reais) e dois valores
// *        ponto flutuante (menor raiz e maior raiz, ou zeros caso não haja raízes reais).
// *
// * Ex.: calcularRaizes(5.0,  3.0,   5.0) retorna (false, 0.0, 0.0)
// *      calcularRaizes(1.0, -1.0, -20.0) retorna (true, -4.0, 5.0)
// */
//fun calcularRaizes(a: Double, b: Double, c: Double): Triple<Boolean, Double, Double> {
//    val delta = Math.pow(b,2.0)-(4 * a * c)
//    var x1 = (-b - Math.sqrt(delta))/(2.0*a)
//    var x2 = (-b + Math.sqrt(delta))/(2.0*a)
//    if(delta < 0){
//        x1 = 0.0
//        x2 = 0.0
//    }
//    return Triple(delta >= 0, x1,x2)
//}
//
//// <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//assertEquals("calcularRaizes(5.4, 25.0, -12.0)", Triple(true, -5.068101913740091, 0.4384722841104621), calcularRaizes(5.4, 25.0, -12.0))
//assertEquals("calcularRaizes(3.0, -7.0, 4.0)", Triple(true, 1.0, 1.3333333333333333), calcularRaizes(3.0, -7.0, 4.0))
//assertEquals("calcularRaizes(9.0, -12.0, 4.0)", Triple(true, 0.6666666666666666, 0.6666666666666666), calcularRaizes(9.0, -12.0, 4.0))
//assertEquals("calcularRaizes(5.0, 3.0, 5.0)", Triple(false, 0.0, 0.0), calcularRaizes(5.0, 3.0, 5.0))
//assertEquals("calcularRaizes(1.0, -1.0, -20.0)", Triple(true, -4.0, 5.0), calcularRaizes(1.0, -1.0, -20.0))
//assertEquals("calcularRaizes(1.0, -1.0, 20.0)", Triple(false, 0.0, 0.0), calcularRaizes(1.0, -1.0, 20.0))
//assertEquals("calcularRaizes(1.0, -1.0, 20.0)", Triple(false, 0.0, 0.0), calcularRaizes(1.0, -1.0, 20.0))
//println("Todos os testes passaram para a função calcularRaizes!")
//
//    //lista 2.2
//
//    /**
//     * Forneça a função 'mercantilV1' que recebe o valor do produto, o chute do 1o jogador e o chute
//     * do 2o jogador, e retorna uma string indicando o vencedor ("primeiro", "segundo" ou "empate").
//     * O vencedor é o jogador cujo chute está mais próximo do valor do produto.
//     * Se ambos os chutes estiverem a mesma distância do valor do produto, o resultado é um "empate".
//     * Ex.: mercantilV1(10.0, 9.0, 11.0) retorna "empate".
//     *      mercantilV1(10.0, 9.0, 12.0) retorna "primeiro".
//     * Obs.: Use comandos de seleção (ao invés da função 'abs') para calcular a distância entre os
//     *       chutes e o valor do produto.
//     */
//    fun mercantilV1(valorProduto: Double, chute1: Double, chute2: Double): String {
//        var prox1 = chute1 - valorProduto
//        var prox2 = chute2 - valorProduto
//
//        prox1 = if (prox1 < 0) -prox1 else prox1
//        prox2 = if (prox2 < 0) -prox2 else prox2
//
//        return ""
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("mercantilV1(10.0, 9.0, 11.0)", "empate", mercantilV1(10.0, 9.0, 11.0))
//    assertEquals("mercantilV1(10.0, 9.0, 12.0)", "primeiro", mercantilV1(10.0, 9.0, 12.0))
//    assertEquals("mercantilV1(10.0, 9.0, 8.0)", "primeiro", mercantilV1(10.0, 9.0, 8.0))
//    assertEquals("mercantilV1(10.0, 9.0, 10.0)", "segundo", mercantilV1(10.0, 9.0, 10.0))
//    assertEquals("mercantilV1(10.0, 12.0, 9.0)", "segundo", mercantilV1(10.0, 12.0, 9.0))
//    println("Todos os testes passaram para a função mercantilV1!")
//    */
//
//    /**
//     * Cada produto tem um valor ponto flutuante que nenhum dos competidores conhece.
//     * O primeiro competidor chuta um valor.
//     * O segundo competidor chuta se acha que o valor real é maior ou menor que o valor chutado pelo
//     * primeiro competidor.
//     * Quando o primeiro competidor acerta o valor, ele ganha o jogo independentemente do chute do segundo.
//     * Portanto, neste jogo não pode haver empate.
//     *
//     * Forneça a função 'mercantilV2' que recebe o valor do produto, o chute do 1o jogador e a
//     * escolha do 2o jogador ('m' para menor ou 'M' para maior), e retorna uma string indicando o
//     * vencedor ("primeiro" ou "segundo").
//     *
//     * Ex.: mercantilV2(10.0,  9.0, 'm') retorna "primeiro".
//     *      mercantilV2(10.0, 11.0, 'm') retorna "segundo".
//     *      mercantilV2(10.0, 11.0, 'M') retorna "primeiro".
//     */
//    fun mercantilV2(valorProduto: Double, chute1: Double, escolha2: Char): String {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return ""
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("mercantilV2(10.0, 9.0, 'm')", "primeiro", mercantilV2(10.0, 9.0, 'm'))
//    assertEquals("mercantilV2(10.0, 11.0, 'm')", "segundo", mercantilV2(10.0, 11.0, 'm'))
//    assertEquals("mercantilV2(10.0, 11.0, 'M')", "primeiro", mercantilV2(10.0, 11.0, 'M'))
//    assertEquals("mercantilV2(10.0, 10.0, 'm')", "primeiro", mercantilV2(10.0, 10.0, 'm'))
//    assertEquals("mercantilV2(10.0, 10.0, 'M')", "primeiro", mercantilV2(10.0, 10.0, 'M'))
//    println("Todos os testes passaram para a função mercantilV2!")
//    */
//
//    /**
//     * Forneça a função 'quizHarryPotter' as respostas das 4 perguntas do quiz abaixo, e retorna a
//     * quantidade de acertos.
//     *
//     * 1 - A que casa pertencia Harry Potter e seus amigos ?
//     * a) Hufflepuff
//     * b) Ravenclaw
//     * c) Slytherin
//     * d) Gryffindor [RESPOSTA CORRETA]
//     *
//     * 2 - Qual o nome verdadeiro do personagem o qual é conhecido por aquele que não deve ser nomeado ?
//     * a) Tom Riddle [RESPOSTA CORRETA]
//     * b) Draco Malfoy
//     * c) Bellatrix Lestrange
//     * d) Pedro Pettigrew
//     *
//     * 3 - Quais dessa opções não é uma Relíquia da Morte ?
//     * a) A varinha de sabugueiro
//     * b) A pedra da ressurreição
//     * c) A pedra filosofal [RESPOSTA CORRETA]
//     * d) A capa de invisibilidade
//     *
//     * 4 - O ministério da magia proibiu o uso de três feitiços, conhecidos como as maldições imperdoáveis,
//     *     por ela possuírem caráter maligno e o objetivo cruel. Marque opção abaixo que não corresponde
//     *     a umas das maldições imperdoáveis:
//     * a) Crucio
//     * b) Imperio
//     * c) Avada Kedavra
//     * d) Expecto Patronum [REPOSTA CORRETA]
//     *
//     * Ex.: quizHarryPotter('d', 'b', 'c', 'c') retorna 2.
//     */
//    fun quizHarryPotter(resposta1: Char, resposta2: Char, resposta3: Char, resposta4: Char): Int {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return 0
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("quizHarryPotter('d', 'b', 'c', 'c')", 2, quizHarryPotter('d', 'b', 'c', 'c'))
//    assertEquals("quizHarryPotter('d', 'a', 'c', 'd')", 4, quizHarryPotter('d', 'a', 'c', 'd'))
//    assertEquals("quizHarryPotter('a', 'a', 'a', 'a')", 1, quizHarryPotter('a', 'a', 'a', 'a'))
//    assertEquals("quizHarryPotter('b', 'b', 'b', 'b')", 0, quizHarryPotter('b', 'b', 'b', 'b'))
//    println("Todos os testes passaram para a função quizHarryPotter!")
//    */
//
//    /**
//     * Forneça a função 'jokenpo' que retorna o resultado do jogo pedra, papel e tesoura.
//     * Os jogadores podem escolher entre R(rock), P(paper) e S(scissor), que correspondem ao nosso
//     * pedra, papel e tesoura (nesta ordem).
//     * A entrada são dois caracteres, um para cada jogador, e a saída é uma string indicando o
//     * resultado do jogo ("jog1", "jog2" ou "empate").
//     *
//     * Quem ganha:
//     * - Pedra ganha de tesoura
//     * - Tesoura ganha de papel
//     * - Papel ganha de pedra
//     *
//     * Ex.: jokenpo('R', 'R') retorna "empate".
//     *      jokenpo('R', 'P') retorna "jog2".
//     *      jokenpo('R', 'S') retorna "jog1".
//     */
//    fun jokenpo(jog1: Char, jog2: Char): String {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return ""
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("jokenpo('R', 'R')", "empate", jokenpo('R', 'R'))
//    assertEquals("jokenpo('R', 'P')", "jog2", jokenpo('R', 'P'))
//    assertEquals("jokenpo('R', 'S')", "jog1", jokenpo('R', 'S'))
//    assertEquals("jokenpo('P', 'R')", "jog1", jokenpo('P', 'R'))
//    assertEquals("jokenpo('P', 'S')", "jog2", jokenpo('P', 'S'))
//    assertEquals("jokenpo('S', 'R')", "jog2", jokenpo('S', 'R'))
//    assertEquals("jokenpo('S', 'P')", "jog1", jokenpo('S', 'P'))
//    println("Todos os testes passaram para a função jokenpo!")
//    */
//
//    /**
//     * Forneça a função 'zerimOuUm' que 3 valores inteiros indicando o número de dedos utilizados por
//     * cada jogador, e retorna uma string indicando o resultado do jogo ("primeiro", "segundo", "terceiro"
//     * ou "empate").
//     * Cada jogador pode utilizar 0 ou 1 dedos.
//     * O jogador que fornecer um número de dedos diferente dos outros dois vence.
//     * Se todos os jogadores fornecerem o mesmo número de dedos, o resultado é um empate.
//     * Ex.: zerimOuUm(0, 0, 0) retorna "empate".
//     *      zerimOuUm(0, 1, 1) retorna "primeiro".
//     *      zerimOuUm(0, 0, 1) retorna "terceiro".
//     */
//    fun zerimOuUm(a: Int, b: Int, c: Int): String {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return ""
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("zerimOuUm(0, 0, 0)", "empate", zerimOuUm(0, 0, 0))
//    assertEquals("zerimOuUm(0, 1, 1)", "primeiro", zerimOuUm(0, 1, 1))
//    assertEquals("zerimOuUm(0, 0, 1)", "terceiro", zerimOuUm(0, 0, 1))
//    assertEquals("zerimOuUm(1, 0, 1)", "segundo", zerimOuUm(1, 0, 1))
//    println("Todos os testes passaram para a função zerimOuUm!")
//    */
//
//    /**
//     * No zerim ou um americano, cada participante coloca quantos dedos quiser na roda.
//     * Um dos participantes soma os dedos e aponta para cada participante enquanto conta.
//     * Ganha aquele que estiver sendo apontado no momento que a contagem coincidir com a soma dos dedos.
//     * Suponha que existem 4 jogadores. O contador, o jogador 1, aponta pra cima e diz "zero", e então
//     * aponta pra si mesmo e diz "um", aponta para o jogador 2 e diz "dois", para o jogador 3 e diz
//     * "três", para o jogador 4 e diz "quatro", volta a apontar para si e diz "cinco", e assim
//     * sucessivamente até a contagem atingir o total de dedos.
//     *
//     * Forneça a função 'zerimOuUmAmericano' que recebe os números dos 4 jogadores e retorna uma
//     * string indicando o número do jogador que ganhou ("jog1", "jog2", "jog3", "jog4") ou "nenhum"
//     * se a soma deu 0.
//     * Ex.: zerimOuUmAmericano(1, 2, 3, 4) retorna "jog1".
//     *      zerimOuUmAmericano(2, 3, 4, 1) retorna "jog2".
//     *      zerimOuUmAmericano(3, 4, 1, 2) retorna "jog3".
//     *      zerimOuUmAmericano(4, 1, 2, 3) retorna "jog4".
//     *      zerimOuUmAmericano(0, 0, 0, 0) retorna "nenhum".
//     */
//    fun zerimOuUmAmericano(jog1: Int, jog2: Int, jog3: Int, jog4: Int): String {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return ""
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("zerimOuUmAmericano(0, 0, 0, 0)", "nenhum", zerimOuUmAmericano(0, 0, 0, 0))
//    assertEquals("zerimOuUmAmericano(1, 0, 0, 0)", "jog1", zerimOuUmAmericano(1, 0, 0, 0))
//    assertEquals("zerimOuUmAmericano(0, 3, 0, 0)", "jog3", zerimOuUmAmericano(0, 3, 0, 0))
//    assertEquals("zerimOuUmAmericano(2, 2, 2, 2)", "jog4", zerimOuUmAmericano(2, 2, 2, 2))
//    assertEquals("zerimOuUmAmericano(1, 1, 1, 1)", "jog4", zerimOuUmAmericano(1, 1, 1, 1))
//    assertEquals("zerimOuUmAmericano(2, 1, 1, 1)", "jog1", zerimOuUmAmericano(2, 1, 1, 1))
//    assertEquals("zerimOuUmAmericano(2, 10, 1, 1)", "jog2", zerimOuUmAmericano(2, 10, 1, 1))
//    println("Todos os testes passaram para a função zerimOuUmAmericano!")
//    */
//
//    /**
//     * Forneça a função 'droneDeEntrega' que recebe os 3 lados de uma caixa e a altura e largura de
//     * uma janela e retorna se um booleano indicando se existe alguma forma da caixa passar pela janela.
//     * A caixa pode ser rotacionada, mas não pode ser desmontada.
//     * Ex.: droneDeEntrega(10, 20, 30, 25, 15) retorna true.
//     *      droneDeEntrega(10, 20, 30, 15, 10) retorna false.
//     * Obs.: Não ordene os lados da caixa (apenas faça as comparações necessárias).
//     */
//    fun droneDeEntrega(lado1: Int, lado2: Int, lado3: Int, largura: Int, altura: Int): Boolean {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return false
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("droneDeEntrega(10, 20, 30, 25, 15)", true, droneDeEntrega(10, 20, 30, 25, 15))
//    assertEquals("droneDeEntrega(10, 20, 30, 15, 10)", false, droneDeEntrega(10, 20, 30, 15, 10))
//    assertEquals("droneDeEntrega(10, 20, 30, 30, 20)", true, droneDeEntrega(10, 20, 30, 30, 20))
//    assertEquals("droneDeEntrega(10, 20, 30, 20, 10)", true, droneDeEntrega(10, 20, 30, 20, 10))
//    assertEquals("droneDeEntrega(10, 20, 30, 10, 5)", false, droneDeEntrega(10, 20, 30, 10, 5))
//    println("Todos os testes passaram para a função droneDeEntrega!")
//    */
//
//    /**
//     * Assuma que a distância entre os dois marcadores de horas consecutivas é 6 centímetros.
//     * Ou seja, se a formiga sai do ponto 00:00 e anda até 01:00, ela anda 6 centímetros, o que
//     * equivale a dizer que cada 10 min equivale a 1 cm para o ponteiro das horas.
//     * Ex.: De 02:00 até 03:30 são então 9 centímetros.
//     * Para simplificar, a formiga sempre vai iniciar sua caminhada em valores múltiplos de 10 nos minutos.
//     * Dado a posição inicial da formiga no relógio, a direção que ela está caminhado H(horário)
//     * A(anti-horário) e quantos centímetros ela caminhou (um inteiro), informe em que posição do
//     * relógio ela vai terminar sua caminhada.
//     *
//     * Forneça a função 'formiga' que recebe a hora e o minuto que a formiga começa sua caminhada, o
//     * sentido que ela anda ('H' para horário ou 'A' para anti-horário) e a distância caminhada em
//     * centímetros. Para simplificar, o meio dia será representado pelo horário 00:00 e não por 12:00.
//     * A saída é a posição (hora e minuto) que ela termina sua caminhada.
//     *
//     * Ex.: formiga(2, 0, 'H', 6) retorna (3, 0).
//     *      formiga(2, 0, 'A', 3) retorna (1, 30).
//     *
//     * Dicas:
//     * - Converta inicialmente tudo para centímetro como se estivesse calculando a distancia entre o
//     *   ponto 00:00 e o ponto atual. Depois faça a operação de forma modular (utilizando o operador
//     *   de resto da divisão). Então reconverta o resultado para hora.
//     * - Para converter para centímetro, multiplique a hora por 6, e divida os minutos por 10.
//     *   Ex.: 04:20 equivale a 4 * 6 + 20 / 10 = 26 centímetros do ponto meio dia.
//     * - Após isso, opere utilizando soma (horário) ou subtração(anti-horário) o valor obtido com a
//     *   distância percorrida pela formiga.
//     * - Você precisará fazer uma operação modular para "recolocar" esse valor dentro do relógio
//     *   novamente.
//     * - Perceba que o relógio inteiro possui 12 * 6 = 72 centímetros. Talvez o valor que você
//     *   calculou, seja maior que 72 ou menor que 0. Você pode "consertá-lo" fazendo (valor % 72).
//     *   Se esse valor for negativo, some com 72 para reposicionar dentro do relógio.
//     * - Agora você precisa converter esses centímetros de volta pra um horário válido.
//     *   Divida por 6 para saber quantas horas você possui.
//     *   O resto da divisão por 6 equivale aos minutos. Pegue o resto da divisão e multiplique por 10.
//     *   Pronto, resultado obtido!
//     */
//    fun formiga(hora: Int, minuto: Int, sentido: Char, distancia: Int): Pair<Int, Int> {
//        // <FORNEÇA AQUI SUA SOLUÇÃO>
//        return Pair(0, 0)
//    }
//
//    // <INCLUA O TRECHO ABAIXO PARA TESTAR SUA SOLUÇÃO>
//    /*
//    assertEquals("formiga(0, 40, 'A', 1)", Pair(0, 30), formiga(0, 40, 'A', 1))
//    assertEquals("formiga(0, 10, 'A', 2)", Pair(11, 50), formiga(0, 10, 'A', 2))
//    assertEquals("formiga(7, 40, 'A', 915)", Pair(11, 10), formiga(7, 40, 'A', 915))
//    assertEquals("formiga(5, 10, 'H', 492)", Pair(3, 10), formiga(5, 10, 'H', 492))
//    assertEquals("formiga(9, 10, 'H', 27)", Pair(1, 40), formiga(9, 10, 'H', 27))
//    assertEquals("formiga(2, 10, 'A', 926)", Pair(3, 50), formiga(2, 10, 'A', 926))
//    assertEquals("formiga(0, 0, 'H', 736)", Pair(2, 40), formiga(0, 0, 'H', 736))
//    assertEquals("formiga(11, 20, 'A', 429)", Pair(11, 50), formiga(11, 20, 'A', 429))
//    assertEquals("formiga(2, 20, 'H', 123)", Pair(10, 50), formiga(2, 20, 'H', 123))
//    assertEquals("formiga(7, 10, 'A', 802)", Pair(5, 30), formiga(7, 10, 'A', 802))
//    assertEquals("formiga(6, 0, 'A', 167)", Pair(2, 10), formiga(6, 0, 'A', 167))
//    assertEquals("formiga(1, 40, 'A', 42)", Pair(6, 40), formiga(1, 40, 'A', 42))
//    assertEquals("formiga(9, 30, 'A', 919)", Pair(0, 20), formiga(9, 30, 'A', 919))
//    assertEquals("formiga(8, 10, 'H', 324)", Pair(2, 10), formiga(8, 10, 'H', 324))
//    assertEquals("formiga(11, 0, 'A', 526)", Pair(7, 20), formiga(11, 0, 'A', 526))
//    assertEquals("formiga(7, 20, 'H', 873)", Pair(8, 50), formiga(7, 20, 'H', 873))
//    assertEquals("formiga(2, 20, 'H', 281)", Pair(1, 10), formiga(2, 20, 'H', 281))
//    assertEquals("formiga(9, 30, 'H', 327)", Pair(4, 0), formiga(9, 30, 'H', 327))
//    assertEquals("formiga(8, 50, 'H', 729)", Pair(10, 20), formiga(8, 50, 'H', 729))
//    assertEquals("formiga(1, 50, 'H', 895)", Pair(7, 0), formiga(1, 50, 'H', 895))
//    assertEquals("formiga(6, 30, 'H', 367)", Pair(7, 40), formiga(6, 30, 'H', 367))
//    assertEquals("formiga(2, 20, 'A', 750)", Pair(9, 20), formiga(2, 20, 'A', 750))
//    println("Todos os testes passaram para a função formiga!")
//    */
//}