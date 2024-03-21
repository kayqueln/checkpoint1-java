package br.com.fiap.Checkpoint1.dto.filme;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFilme(
        @NotNull
                @Min(1)
        String titulo,
         String descricao,

         @NotNull
                 @Max(4)
         Integer anoLancamento,

         @NotNull
                 @Min(1)
         String diretor,

         @NotNull
                 @Min(1)
         String genero
) {
}
