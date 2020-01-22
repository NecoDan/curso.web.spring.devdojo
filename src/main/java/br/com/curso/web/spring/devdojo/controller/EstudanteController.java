package br.com.curso.web.spring.devdojo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.web.spring.devdojo.infra.CustomErrorType;
import br.com.curso.web.spring.devdojo.model.Estudante;
import br.com.curso.web.spring.devdojo.infra.util.DateUtil;

/*
 * É o ponto final de acesso da API. Que permite e dá acesso a classe modelo Estudante.
 * */

@RestController
@RequestMapping("estudante")
public class EstudanteController {

    @Autowired
    private DateUtil dateUtil;

    /*
     * Retornar um STATUS CODE HTPP com os seus respectivos valores, utilizando
     * ResponseEntity!
     */

    // @RequestMapping(method = RequestMethod.GET) - PADRÃO ANTIGO!
    @GetMapping
    public ResponseEntity<?> listAll() {
        System.out.println("Data da requisição: " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(Estudante.estudantes, HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.GET, path = "/{id}") - PADRÃO ANTIGO!
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEstudantesByIdDefault(@PathVariable("id") Long id) {
        System.out.println("Data da requisição: " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));

        Estudante estudante = new Estudante();
        estudante.setId(id);

        int index = Estudante.estudantes.indexOf(estudante);

        if (index == -1)
            return new ResponseEntity<>(new CustomErrorType("Estudante não foi encontrado"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(Estudante.estudantes.get(index), HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.POST) - PADRÃO ANTIGO!
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Estudante estudante) {
        Estudante.estudantes.add(estudante);
        return new ResponseEntity<>(estudante, HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.PUT) - PADRÃO ANTIGO
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Estudante estudante) {
        Estudante.estudantes.remove(estudante);
        Estudante.estudantes.add(estudante);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @RequestMapping(method = RequestMethod.DELETE) - PADRÃO ANTIGO!
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Estudante estudante) {
        Estudante.estudantes.remove(estudante);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/deletaPorId/{id}")
    public ResponseEntity<?> deleteFromId(@PathVariable("id") Long id) {
        Estudante estudante = new Estudante();
        estudante.setId(id);

        int indice = Estudante.estudantes.indexOf(estudante);

        if (indice == -1)
            return new ResponseEntity<>(new CustomErrorType("Estudante não foi encontrado"), HttpStatus.NOT_FOUND);

        Estudante.estudantes.remove(indice);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
