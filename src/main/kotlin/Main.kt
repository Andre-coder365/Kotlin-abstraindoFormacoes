enum class Nivel{ BASICO, INTERMEDIARIO, AVANCADO }

class Usuario  (val nome:String){
    override fun toString(): String {
        return nome
    }}

data class ConteudoEducacional(var descricao: String, val duracao: Int = 60)

data class Formacao( var nivel: Nivel, val nome:String, val conteudos: List<ConteudoEducacional>){

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario:Usuario){
        inscritos.add(usuario)
    }


}



fun main(){

    val usuario1 = Usuario("Márcia")
    val usuario2 = Usuario("Guilherme")
    val usuario3 = Usuario ("Lucas")
    val usuario4 = Usuario ("Joana")


    val conteudoFormacao1 = ConteudoEducacional("Pensamento Computacional",10)
    val conteudoFormacao2 = ConteudoEducacional ("Kotlin",20)
    val conteudoFormacao3 = ConteudoEducacional ("Java", 60);


    val formacaoKotlin = Formacao(Nivel.BASICO, nome = "Formação Kotlin", listOf<ConteudoEducacional>(conteudoFormacao1,conteudoFormacao2,conteudoFormacao3))

    formacaoKotlin.matricular(usuario1);
    formacaoKotlin.matricular(usuario2);
    formacaoKotlin.matricular(usuario3);
    formacaoKotlin.matricular(usuario4);

    println("")

    println("************** ---------- **************")
    println("")

    print(formacaoKotlin.nome)
    print(" - Nível: ")
    println(formacaoKotlin.nivel)

    println("")


    println("Conteúdos da Formação")
    for(conteudo in formacaoKotlin.conteudos){
        println(" ${conteudo.descricao}")
    }

    println("")

    println("Alunos inscritos nessa formação:") ;

    for(inscrito in formacaoKotlin.inscritos){
        println(" $inscrito")
    }




}