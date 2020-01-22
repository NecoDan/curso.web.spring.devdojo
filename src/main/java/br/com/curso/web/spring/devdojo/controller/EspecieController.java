package br.com.curso.web.spring.devdojo.controller;

import br.com.curso.web.spring.devdojo.infra.util.ResourceNotFoundException;
import br.com.curso.web.spring.devdojo.model.Especie;
import br.com.curso.web.spring.devdojo.service.IEspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("especie")
@RequiredArgsConstructor
public class EspecieController {

    private final IEspecieService IEspecieService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            return new ResponseEntity<>(IEspecieService.recuperarTodas(), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @GetMapping(path = "/porId/{id}")
    public ResponseEntity<?> recuperarById(@PathVariable("id") Long id) {
        try {
            /* Optional<Especie> especieOptional = especieRepository.findById(id);
            if (especieOptional.isPresent())
                return new ResponseEntity<>(especieOptional.get(), HttpStatus.OK);*/
            return null;
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> recuperarPorId(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(IEspecieService.recuperarPorId(id), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findEspecieByName(@PathVariable String name) {
        /*        return new ResponseEntity<>(especieRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);*/
        return null;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Especie especie) {
        try {
            IEspecieService.inserir(especie);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Especie especie) {
        try {
            verificaEspecieExists(especie.getEspecieId());
            IEspecieService.atualizarPor(especie);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            verificaEspecieExists(id);
            IEspecieService.excluirPorId(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    private void verificaEspecieExists(Long id) {
        if (IEspecieService.recuperarPorId(id) == null)
            throw new ResourceNotFoundException("Erro ao executar a busca de dados: " + "especie inválida e/ou inexistente. Não encontrada!");
    }
}
