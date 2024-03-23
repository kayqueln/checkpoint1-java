package br.com.fiap.Checkpoint1.model;

import br.com.fiap.Checkpoint1.dto.serie.DadosAtualizarSerie;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serie_id")
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String genero;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episodio> episodios;


    public Serie(DadosCadastroSerie dadosCadastroSerie) {
        this.titulo = dadosCadastroSerie.titulo();
        this.descricao = dadosCadastroSerie.descricao();
        this.anoLancamento = dadosCadastroSerie.anoLancamento();
        this.genero = dadosCadastroSerie.genero();
    }

    public void atualizarSerie(DadosAtualizarSerie dadosAlterarSerie) {
        if(dadosAlterarSerie.titulo() != null) this.titulo = dadosAlterarSerie.titulo();
        if(dadosAlterarSerie.descricao() != null) this.descricao = dadosAlterarSerie.descricao();
        if(dadosAlterarSerie.anoLancamento() != null) this.anoLancamento = dadosAlterarSerie.anoLancamento();
        if(dadosAlterarSerie.genero() != null) this.genero = dadosAlterarSerie.genero();
    }
}
