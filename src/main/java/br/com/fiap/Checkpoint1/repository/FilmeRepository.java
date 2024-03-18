package br.com.fiap.Checkpoint1.repository;

import br.com.fiap.Checkpoint1.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
