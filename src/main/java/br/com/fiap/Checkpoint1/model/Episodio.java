package br.com.fiap.Checkpoint1.model;

    import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_id")
    private Serie serie;

    public Episodio(DadosCadastroEpisodios dadosCadastroEpisodios) {
        this.id = dadosCadastroEpisodios.id();
        this.titulo = dadosCadastroEpisodios.titulo();
        this.numeroEpisodio = dadosCadastroEpisodios.numeroEpisodio();
        this.temporada = dadosCadastroEpisodios.temporada();
        this.serie = dadosCadastroEpisodios.serie();
    }

}
