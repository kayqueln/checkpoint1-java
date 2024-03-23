package br.com.fiap.Checkpoint1.dto.serie;

import br.com.fiap.Checkpoint1.model.Episodio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosAtualizarSerie(
        @NotNull
        @Min(1)
        String titulo,

        String descricao,
        @NotNull
        @Min(1)
        Integer anoLancamento,
        @NotNull
        @Min(1)
        String genero,
        List<Episodio> episodios
) {
}
