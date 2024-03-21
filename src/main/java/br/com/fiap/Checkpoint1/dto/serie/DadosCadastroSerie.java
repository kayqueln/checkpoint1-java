package br.com.fiap.Checkpoint1.dto.serie;

import br.com.fiap.Checkpoint1.model.Episodio;

import java.util.List;

public record DadosCadastroSerie(
        String titulo,
        String descricao,
        Integer anoLancamento,
        String genero,
        List<Episodio> episodios
) {
}
