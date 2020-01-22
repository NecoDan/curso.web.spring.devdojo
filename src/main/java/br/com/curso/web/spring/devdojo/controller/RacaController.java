package br.com.curso.web.spring.devdojo.controller;

import br.com.curso.web.spring.devdojo.infra.exceptions.ValidacaoException;
import br.com.curso.web.spring.devdojo.model.Raca;
import br.com.curso.web.spring.devdojo.service.IRacaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("raca")
@RequiredArgsConstructor
public class RacaController {

    private final IRacaService racaService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            return new ResponseEntity<>(racaService.recuperarTodas(), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Raca raca) {
        try {
            racaService.inserir(raca);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + e.getMessage());
        }
    }
}
