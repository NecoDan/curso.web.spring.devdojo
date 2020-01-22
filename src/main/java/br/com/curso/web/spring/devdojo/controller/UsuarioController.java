package br.com.curso.web.spring.devdojo.controller;

import br.com.curso.web.spring.devdojo.model.Usuario;
import br.com.curso.web.spring.devdojo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            return new ResponseEntity<>(usuarioService.recuperarTodos(), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados: " + ex.getMessage());
        }
    }

    @GetMapping(value = "/ativos")
    public ResponseEntity<?> ativos() {
        try {
            return new ResponseEntity<>(usuarioService.recuperarUsuarioAtivos(Boolean.TRUE), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados." + ex.getMessage());
        }
    }

    @GetMapping(value = "/inativos")
    public ResponseEntity<?> inativos() {
        try {
            return new ResponseEntity<>(usuarioService.recuperarUsuarioAtivos(Boolean.FALSE), HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados." + ex.getMessage());
        }
    }

    @GetMapping(path = "/usuarioLogin")
    public ResponseEntity<?> usuarioLoginESenha(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        try {
            return new ResponseEntity<>(usuarioService.recuperarUsuario(login, senha), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("error", e.getMessage())
                    .build();
        }
    }

    @GetMapping(path = "/usuariosPorLogin")
    public ResponseEntity<?> usuariosPorLogin(@RequestParam("login") String login) {
        try {
            return new ResponseEntity<>(usuarioService.recuperarUsuariosPorLogin(login), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("error", e.getMessage())
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados." + ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {
        try {
            usuarioService.atualizar(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados." + ex.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            usuarioService.excluirPorId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao executar a busca de dados." + ex.getMessage());
        }
    }
}
