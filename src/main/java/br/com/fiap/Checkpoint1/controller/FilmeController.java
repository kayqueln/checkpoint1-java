package br.com.fiap.Checkpoint1.controller;

import br.com.fiap.Checkpoint1.dto.filme.DadosAtualizarFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosCadastroFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosDetalharFilme;
import br.com.fiap.Checkpoint1.model.Filme;
import br.com.fiap.Checkpoint1.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> listaFilmes = filmeRepository.findAll();
        return ResponseEntity.ok(listaFilmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody DadosCadastroFilme dadosCadastroFilme){
        Filme novoFilme = new Filme(dadosCadastroFilme);
        Filme filmeCadastrado = filmeRepository.save(novoFilme);
        return ResponseEntity.status(201).body(filmeCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalharFilme> buscarFilmePorId(@PathVariable Long id){
        Filme filme = filmeRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharFilme(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalharFilme> atualizarFilme(@PathVariable Long id, @RequestBody DadosAtualizarFilme dadosAtualizarFilme){
        Filme filme = filmeRepository.getReferenceById(id);
        filme.atualizarFilme(dadosAtualizarFilme);
        filmeRepository.save(filme);

        return ResponseEntity.ok(new DadosDetalharFilme(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFilme (@PathVariable Long id){
        filmeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
