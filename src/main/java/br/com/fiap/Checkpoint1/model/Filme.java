package br.com.fiap.Checkpoint1.model;

import br.com.fiap.Checkpoint1.dto.filme.DadosAtualizarFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosCadastroFilme;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class Filme {
    @Id
    @Column(name = "filme_id")
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

    public void atualizarFilme(DadosAtualizarFilme dadosAtualizarFilme) {
        if(dadosAtualizarFilme.titulo() != null) this.titulo = dadosAtualizarFilme.titulo();
        if(dadosAtualizarFilme.descricao() != null) this.descricao = dadosAtualizarFilme.descricao();
        if(dadosAtualizarFilme.anoLancamento() != null) this.anoLancamento = dadosAtualizarFilme.anoLancamento();
        if(dadosAtualizarFilme.diretor() != null) this.diretor = dadosAtualizarFilme.diretor();
        if(dadosAtualizarFilme.genero() != null) this.genero = dadosAtualizarFilme.genero();
    }
}
