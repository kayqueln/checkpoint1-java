package br.com.fiap.Checkpoint1.repository;

import br.com.fiap.Checkpoint1.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByTitulo(String titulo);

    List<Filme> findByGenero(String titulo);

    List<Filme> findByAnoLancamento(Integer anoLancamento);
}
