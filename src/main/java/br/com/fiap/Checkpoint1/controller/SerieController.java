package br.com.fiap.Checkpoint1.controller;

import br.com.fiap.Checkpoint1.dto.serie.DadosDetalharSerie;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import br.com.fiap.Checkpoint1.model.Serie;
import br.com.fiap.Checkpoint1.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public ResponseEntity<List<Serie>> listarSeries(){
        List<Serie> series = serieRepository.findAll();
        return ResponseEntity.ok(series);
    }

    @PostMapping
    public ResponseEntity<Serie> cadastrarSerie(@RequestBody DadosCadastroSerie dadosCadastroSerie){
        Serie novaSerie = new Serie(dadosCadastroSerie);
        serieRepository.save(novaSerie);
        return ResponseEntity.status(201).body(novaSerie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalharSerie> buscarSeriePorId(@PathVariable Long id){
        Serie serie = serieRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharSerie(serie));
    }

}
