package br.com.fiap.Checkpoint1.business;

import br.com.fiap.Checkpoint1.dto.episodios.DadosCadastroEpisodios;
import br.com.fiap.Checkpoint1.dto.filme.DadosAtualizarFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosCadastroFilme;
import br.com.fiap.Checkpoint1.exceptions.NotFoundResourceException;
import br.com.fiap.Checkpoint1.model.Episodio;
import br.com.fiap.Checkpoint1.model.Filme;
import br.com.fiap.Checkpoint1.model.Filme;
import br.com.fiap.Checkpoint1.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeBusiness {

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodosFilmes(String titulo, String genero, Integer anoLancamento){
        List<Filme> filmes;

        if(titulo != null){
            filmes = filmeRepository.findByTitulo(titulo);
        }else if(genero != null){
            filmes = filmeRepository.findByGenero(genero);
        }else if(anoLancamento != null){
            filmes = filmeRepository.findByAnoLancamento(anoLancamento);
        }else{
            filmes = filmeRepository.findAll();
        }

        return filmes;
    }

    public Filme cadastrarFilme(DadosCadastroFilme dadosCadastroFilme){
        Filme novoFilme = new Filme(dadosCadastroFilme);
        filmeRepository.save(novoFilme);
        return novoFilme;
    }

    public Filme buscarFilmePorId(Long id){
        Optional<Filme> Filme = filmeRepository.findById(id);

        if (Filme.isPresent()) {
            return Filme.get();
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar essa filme");
        }
    }

    public Filme alterarFilme(Long id, DadosAtualizarFilme dadosAtualizarFilme){
        Optional<Filme> Filme = filmeRepository.findById(id);

        if (Filme.isPresent()) {
            Filme.get().atualizarFilme(dadosAtualizarFilme);
            filmeRepository.save(Filme.get());
            return Filme.get();
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar essa filme");
        }
    }

    public void deletarFilme(Long id){
        Optional<Filme> Filme = filmeRepository.findById(id);

        if(Filme.isPresent()){
            filmeRepository.delete(Filme.get());
        }else{
            throw new NotFoundResourceException("Não foi possível encontrar esse filme");
        }
    }

    public List<Filme> buscarFilmePorTitulo(String titulo){
        List<Filme> Filmes = filmeRepository.findByTitulo(titulo);

        if(Filmes.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar esse filme");
        }else{
            return Filmes;
        }
    }

    public List<Filme> buscarFilmePorGenero(String genero){
        List<Filme> Filmes = filmeRepository.findByGenero(genero);

        if(Filmes.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar esse filme");
        }else{
            return Filmes;
        }
    }

    public List<Filme> buscarFilmePorAnoLancamento(Integer anoLancamento){
        List<Filme> Filmes = filmeRepository.findByAnoLancamento(anoLancamento);

        if(Filmes.isEmpty()){
            throw new NotFoundResourceException("Não foi possível encontrar esse filme");
        }else{
            return Filmes;
        }
    }
}
