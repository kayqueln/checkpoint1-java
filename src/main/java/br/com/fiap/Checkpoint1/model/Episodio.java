package br.com.fiap.Checkpoint1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private Integer numeroEpisodio;
    private Integer temporada;
    @ManyToOne
    private Serie serie;
}
