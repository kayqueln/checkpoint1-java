package br.com.fiap.Checkpoint1.controller;

import br.com.fiap.Checkpoint1.business.SerieBusiness;
import br.com.fiap.Checkpoint1.dto.serie.DadosAtualizarSerie;
import br.com.fiap.Checkpoint1.dto.serie.DadosDetalharSerie;
import br.com.fiap.Checkpoint1.dto.serie.DadosCadastroSerie;
import br.com.fiap.Checkpoint1.exceptions.NotFoundResourceException;
import br.com.fiap.Checkpoint1.model.Serie;
import br.com.fiap.Checkpoint1.repository.SerieRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/serie")
@Tag(name = "Series")
@Slf4j
public class SerieController {

    @Autowired
    private SerieBusiness serieBusiness;
    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public ResponseEntity<List<Serie>> listarSeries(@PathParam("titulo") String titulo,
                                                    @PathParam("genero") String genero,
                                                    @PathParam("anoLancamento") Integer anoLancamento,
                                                    @PathParam("numeroTemporadas") Integer numeroTemporadas){
        List<Serie> series = serieBusiness.listarTodos(titulo, genero, anoLancamento, numeroTemporadas);

        return ResponseEntity.ok(series);
    }

    @PostMapping
    public ResponseEntity cadastrarSerie(@RequestBody DadosCadastroSerie dadosCadastroSerie) {
        try {
            Serie novaSerie = serieBusiness.cadastrarSerie(dadosCadastroSerie);
            return ResponseEntity.status(201).body(new DadosDetalharSerie(novaSerie));
        }catch (Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarSeriePorId(@PathVariable Long id){
        try{
            Serie serie = serieBusiness.buscarSeriePorId(id);
            return ResponseEntity.ok(new DadosDetalharSerie(serie));
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/temporadas/{numeroTemporada}")
    public ResponseEntity buscarSeriePorId(@PathVariable Integer numeroTemporada){
        List<Serie> series = serieRepository.findByNumeroTemporadas(numeroTemporada);
        return ResponseEntity.ok(series);
    }

    @PutMapping("/{id}")
    public ResponseEntity alterarSerie(@PathVariable Long id, @RequestBody DadosAtualizarSerie dadosAlterarSerie){
        try{
            Serie serie = serieBusiness.alterarSerie(id, dadosAlterarSerie);
            return ResponseEntity.ok(new DadosDetalharSerie(serie));
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSerie(@PathVariable Long id){
        try{
            serieBusiness.deletarSerie(id);
            return ResponseEntity.noContent().build();
        }catch (NotFoundResourceException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}