package Data

data class Refeicao(
    val id: String,
    val nome: String,
    val ingredientes: List<String>,
    val calorias: Int
)