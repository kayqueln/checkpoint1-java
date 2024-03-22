package br.com.fiap.Checkpoint1.model;

import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import jakarta.persistence.*;
import lombok.Data;
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
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;


    public Serie(DadosCadastroSerie dadosCadastroSerie) {
        this.titulo = dadosCadastroSerie.titulo();
        this.descricao = dadosCadastroSerie.descricao();
        this.anoLancamento = dadosCadastroSerie.anoLancamento();
        this.genero = dadosCadastroSerie.genero();
        this.episodios = dadosCadastroSerie.episodios();
    }
}
