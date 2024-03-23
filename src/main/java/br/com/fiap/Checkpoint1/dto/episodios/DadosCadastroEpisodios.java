package br.com.fiap.Checkpoint1.dto.episodios;

import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Serie;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

public record DadosCadastroEpisodios(
         String titulo,
         Integer numeroEpisodio,
         Integer temporada,
         Serie serie
) {
    public DadosCadastroEpisodios(Episodio episodio) {
        this(episodio.getTitulo(), episodio.getNumeroEpisodio(), episodio.getTemporada(), episodio.getSerie());
    }
}
