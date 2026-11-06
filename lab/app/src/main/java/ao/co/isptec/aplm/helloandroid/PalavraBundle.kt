package ao.co.isptec.aplm.helloandroid

data class PalavraBundle(val palavras: List<String>?) {

    val contar = palavras?.size
    val comprimentoMedio = palavras?.map { it.length }?.average()
    val palavraMaisLonga = palavras?.maxByOrNull { it.length } ?: "Não disponível."

    companion object {
        fun gerarResumo(bundle: PalavraBundle): String {
            val palavrasLongas = bundle.palavras?.filter { it.length > 4 }
            return "Palavras: ${bundle.contar}, Comprimento médio: ${bundle.comprimentoMedio},Palavras longas: ${palavrasLongas?.joinToString()}"
        }
    }
}