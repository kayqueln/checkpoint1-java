package br.com.fiap.Checkpoint1.dto;

public record DadosCadastroFilme(

         String titulo,
         String descricao,
         Integer anoLancamento,
         String diretor,
         String genero
) {
}
