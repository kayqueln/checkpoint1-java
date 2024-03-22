package br.com.fiap.Checkpoint1.repository;

import br.com.fiap.Checkpoint1.model.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Long> {


}
