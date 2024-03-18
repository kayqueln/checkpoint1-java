package br.com.fiap.Checkpoint1.model;

import br.com.fiap.Checkpoint1.dto.DadosCadastroFilme;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String diretor;
    private String genero;

    public Filme(DadosCadastroFilme dadosCadastroFilme) {
        this.titulo = dadosCadastroFilme.titulo();
        this.descricao = dadosCadastroFilme.descricao();;
        this.anoLancamento = dadosCadastroFilme.anoLancamento();
        this.diretor = dadosCadastroFilme.diretor();
        this.genero = dadosCadastroFilme.genero();
    }
}
