package br.com.fiap.Checkpoint1.repository;

import br.com.fiap.Checkpoint1.model.Filme;
import br.com.fiap.Checkpoint1.model.Serie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findByTitulo(String titulo);

    List<Serie> findByGenero(String titulo);

    List<Serie> findByAnoLancamento(Integer anoLancamento);

    @Query("SELECT DISTINCT s FROM Serie s INNER JOIN s.episodios e WHERE e.temporada = :numeroTemporada")
    List<Serie> findByNumeroTemporadas(Integer numeroTemporada);
}
