package br.com.fiap.Checkpoint1.model;

    import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
    import com.fasterxml.jackson.annotation.JsonIdentityInfo;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.ObjectIdGenerators;
    import jakarta.persistence.*;
import lombok.Data;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "episodio_id")
    private Long id;
    private String titulo;
    private Integer numeroEpisodio;
    private Integer temporada;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "serie_id")
    @JsonIgnore
    private Serie serie;

    public Episodio(DadosCadastroEpisodios dadosCadastroEpisodios, Serie serie) {
        this.titulo = dadosCadastroEpisodios.titulo();
        this.numeroEpisodio = dadosCadastroEpisodios.numeroEpisodio();
        this.temporada = dadosCadastroEpisodios.temporada();
        this.serie = dadosCadastroEpisodios.serie();
    }

}
