package br.com.curso.web.spring.devdojo.repository;

import br.com.curso.web.spring.devdojo.model.UsuarioPet;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioPet, Long> {

}
