package br.com.curso.web.spring.devdojo.repository;

import br.com.curso.web.spring.devdojo.model.EspeciePet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EspecieRepository extends CrudRepository<EspeciePet, Long> {

	List<EspeciePet> findByNameIgnoreCaseContaining(String name);
	
	List<EspeciePet> findByDescricao(String descricao);

}
