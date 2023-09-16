// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { Básico, Intermediário, Avançado }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.Básico)

class Formacao(val nome: String, vararg conteudos: ConteudoEducacional) {
    private val inscritos = mutableListOf<Usuario>()
    private val conteudosEducacionais = mutableListOf<ConteudoEducacional>()

    init {
        conteudosEducacionais.addAll(conteudos)
    }

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        println("Matriculando ${usuarios.size} usuário(s) na formação $nome")
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for ((index, conteudo) in conteudosEducacionais.withIndex()) {
            println("${index + 1}. ${conteudo.nome} (Duração: ${conteudo.duracao} minutos, Nível: ${conteudo.nivel})")
        }
    }

    fun listarInscritos() {
        println("Usuários matriculados na formação $nome:")
        for ((index, usuario) in inscritos.withIndex()) {
            println("${index + 1}. ${usuario.nome}")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, Nivel.Básico)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 100, Nivel.Intermediário)
    val conteudo3 = ConteudoEducacional("Orientação a Objetos", 110, Nivel.Avançado)

    val formacaoKotlin = Formacao("Formação Kotlin", conteudo1, conteudo2, conteudo3)

    val usuario1 = Usuario("Maria")
    val usuario2 = Usuario("José")
    val usuario3 = Usuario("Marcos Guilherme")

    formacaoKotlin.matricular(usuario1, usuario2, usuario3)

    formacaoKotlin.listarConteudos()
    formacaoKotlin.listarInscritos()
}
