package br.com.fiap.Checkpoint1.business;

import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Serie;
import br.com.fiap.Checkpoint1.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SerieBusiness {

    @Autowired
    SerieRepository serieRepository;

    public Serie salvar(DadosCadastroSerie dadosCadastroSerie){
        Serie novaSerie = new Serie(dadosCadastroSerie);

        for(Episodio episodio : dadosCadastroSerie.episodios()){
            Episodio novoEpisodio = new Episodio(episodio);
            Episodio episodioDasSeries = new Episodio(novoEpisodio);
        }



        serieRepository.save(novaSerie);
        return novaSerie;
    }
}
