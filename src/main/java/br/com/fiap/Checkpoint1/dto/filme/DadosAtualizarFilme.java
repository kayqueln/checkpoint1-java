package br.com.fiap.Checkpoint1.dto.filme;

public record DadosAtualizarFilme(
        String titulo,
        String descricao,
        Integer anoLancamento,
        String diretor,
        String genero
) {
}
