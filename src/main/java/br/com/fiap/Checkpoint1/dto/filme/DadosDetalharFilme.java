package br.com.fiap.Checkpoint1.dto.filme;

import br.com.fiap.Checkpoint1.model.Filme;

public record DadosDetalharFilme(Long id, String titulo, String descricao, Integer anoLancamento, String diretor, String genero) {
    public DadosDetalharFilme(Filme filme){
        this(filme.getId(), filme.getTitulo(), filme.getDescricao(), filme.getAnoLancamento(), filme.getDiretor(), filme.getGenero());
    }
}
