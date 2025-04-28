open class Usuario(
    protected val id: String,
    private val nome: String,
    private val email: String,
    private var senha: String
) {
    fun getNome(): String = nome

    fun getEmail(): String = email

    protected fun alterarSenha(novaSenha: String) {
        this.senha = novaSenha
    }

    fun autenticar(email: String, senha: String): Boolean {
        return this.email == email && this.senha == senha
    }


}
