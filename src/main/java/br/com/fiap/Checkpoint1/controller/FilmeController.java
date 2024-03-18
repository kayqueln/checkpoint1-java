package br.com.fiap.Checkpoint1.controller;

import br.com.fiap.Checkpoint1.dto.DadosCadastroFilme;
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
}
