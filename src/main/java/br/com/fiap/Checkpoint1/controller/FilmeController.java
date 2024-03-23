package br.com.fiap.Checkpoint1.controller;

import br.com.fiap.Checkpoint1.business.FilmeBusiness;
import br.com.fiap.Checkpoint1.dto.filme.DadosAtualizarFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosCadastroFilme;
import br.com.fiap.Checkpoint1.dto.filme.DadosDetalharFilme;
import br.com.fiap.Checkpoint1.exceptions.NotFoundResourceException;
import br.com.fiap.Checkpoint1.model.Filme;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeBusiness filmeBusiness;

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes(@PathParam("titulo") String titulo,
                                                    @PathParam("genero") String genero,
                                                    @PathParam("anoLancamento") Integer anoLancamento){
        List<Filme> listaFilmes = filmeBusiness.listarTodosFilmes(titulo, genero, anoLancamento);
        return ResponseEntity.ok(listaFilmes);
    }

    @PostMapping
    public ResponseEntity cadastrarFilme(@RequestBody DadosCadastroFilme dadosCadastroFilme){
        try {
            Filme filmeCadastrado = filmeBusiness.cadastrarFilme(dadosCadastroFilme);
            return ResponseEntity.status(201).body(filmeCadastrado);
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarFilmePorId(@PathVariable Long id){
        try{
            Filme filme = filmeBusiness.buscarFilmePorId(id);
            return ResponseEntity.ok(new DadosDetalharFilme(filme));
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarFilme(@PathVariable Long id, @RequestBody DadosAtualizarFilme dadosAtualizarFilme){
        try{
            Filme filme = filmeBusiness.alterarFilme(id, dadosAtualizarFilme);
            return ResponseEntity.ok(new DadosDetalharFilme(filme));
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFilme (@PathVariable Long id){
        try{
            filmeBusiness.deletarFilme(id);
            return ResponseEntity.noContent().build();
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
