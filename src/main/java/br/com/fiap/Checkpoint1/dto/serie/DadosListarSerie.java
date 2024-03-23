package br.com.fiap.Checkpoint1.dto.serie;

import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Serie;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public record DadosListarSerie(
        Long id,
        String titulo,
        String descricao,
        Integer anoLancamento,
        String genero,
        List<Episodio> episodios
) {

    public DadosListarSerie(Serie serie) {
        this(serie.getId(),
                serie.getTitulo(),
                serie.getDescricao(),
                serie.getAnoLancamento(),
                serie.getGenero(),
                serie.getEpisodios());
    }
}
