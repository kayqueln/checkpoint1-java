package br.com.fiap.Checkpoint1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoLancamento;
    private String genero;
    @OneToMany
    private List<Episodio> episodios;


}
