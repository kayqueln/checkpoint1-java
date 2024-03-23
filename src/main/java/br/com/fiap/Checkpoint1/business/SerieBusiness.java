package br.com.fiap.Checkpoint1.business;

import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
import br.com.fiap.Checkpoint1.dto.serie.DadosAtualizarSerie;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import br.com.fiap.Checkpoint1.exceptions.NotFoundResourceException;
import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Serie;
import br.com.fiap.Checkpoint1.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SerieBusiness {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> listarTodos(String titulo, String genero, Integer anoLancamento, Integer numeroTemporadas){
        List<Serie> series;

        if(titulo != null){
            series = serieRepository.findByTitulo(titulo);
        }else if(genero != null){
            series = serieRepository.findByGenero(genero);
        }else if(anoLancamento != null) {
            series = serieRepository.findByAnoLancamento(anoLancamento);
        }else if(numeroTemporadas != null){
            series = serieRepository.findByNumeroTemporadas(numeroTemporadas);
        }else{
            series = serieRepository.findAll();
        }

        return series;
    }

    public Serie cadastrarSerie(DadosCadastroSerie dadosCadastroSerie){
        Serie novaSerie = new Serie(dadosCadastroSerie);

        List<Episodio> episodios = new ArrayList<>();
        for (DadosCadastroEpisodios dadosEpisodio : dadosCadastroSerie.episodios()) {
            Episodio episodio = new Episodio();
            episodio.setTitulo(dadosEpisodio.titulo());
            episodio.setNumeroEpisodio(dadosEpisodio.numeroEpisodio());
            episodio.setTemporada(dadosEpisodio.temporada());
            episodio.setSerie(novaSerie);
            episodios.add(episodio);
        }
        novaSerie.setEpisodios(episodios);

        serieRepository.save(novaSerie);

        return novaSerie;
    }

    public Serie buscarSeriePorId(Long id){
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            return serie.get();
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }
    }

    public Serie alterarSerie(Long id, DadosAtualizarSerie dadosAtualizarSerie){
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            serie.get().atualizarSerie(dadosAtualizarSerie);
            serieRepository.save(serie.get());
            return serie.get();
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }
    }

    public void deletarSerie(Long id){
        Optional<Serie> serie = serieRepository.findById(id);

        if(serie.isPresent()){
            serieRepository.delete(serie.get());
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }
    }

    public List<Serie> buscarSeriePorTitulo(String titulo){
        List<Serie> series = serieRepository.findByTitulo(titulo);

        if(series.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }else{
            return series;
        }
    }

    public List<Serie> buscarSeriePorGenero(String genero){
        List<Serie> series = serieRepository.findByGenero(genero);

        if(series.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }else{
            return series;
        }
    }

    public List<Serie> buscarSeriePorAnoLancamento(Integer anoLancamento){
        List<Serie> series = serieRepository.findByAnoLancamento(anoLancamento);

        if(series.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar essa série");
        }else{
            return series;
        }
    }
}
