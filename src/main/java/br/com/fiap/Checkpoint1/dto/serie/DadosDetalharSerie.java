package br.com.fiap.Checkpoint1.dto.serie;

import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Serie;

import java.util.List;

public record DadosDetalharSerie(Long id, String titulo, String descricao, Integer anoLancamento, String genero, List<Episodio> episodios) {
    public DadosDetalharSerie(Serie serie) {
        this(serie.getId(), serie.getTitulo(), serie.getDescricao(), serie.getAnoLancamento(), serie.getGenero(), serie.getEpisodios());
    }
}
