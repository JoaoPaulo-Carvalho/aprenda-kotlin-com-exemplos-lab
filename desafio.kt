// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Aluno(nome: String, email: String) : Usuario(nome = nome, email = email)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableSetOf<Aluno>()
    
    fun matricular(aluno: Aluno): Boolean {
        return inscritos.add(aluno)
    }
}

fun realizaMatricula(formacao: Formacao, aluno: Aluno) {
    val resultado = formacao.matricular(aluno)
    if (resultado) println("Aluno ${aluno.nome} matriculado com sucesso!")
    else println("Aluno ${aluno.nome} já está matriculado!")
}

fun main() {
    val aluno1 : Aluno = Aluno("John Doe", "example@domain.com")
    val aluno2 : Aluno = Aluno("Jane Austin", "austin@domain.com")
    
    val ce1 = ConteudoEducacional("Orientação a Objetos em Kotlin", 90)
    val ce2 = ConteudoEducacional("Collections em Kotlin")
    
    val conteudos = listOf(ce1, ce2)
    val formacao = Formacao("Kotlin para Backend", Nivel.BASICO, conteudos)
    
    realizaMatricula(formacao, aluno1)
    realizaMatricula(formacao, aluno2)
    realizaMatricula(formacao, aluno1)
}
