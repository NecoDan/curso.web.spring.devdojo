package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.model.Especie;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface IEspecieService {

    void inserir(Especie especie);

    Especie inserirPor(Especie especie);

    void atualizarPor(Especie especie);

    void excluirPorId(Long id);

    Collection<Especie> recuperarTodas();

    Collection<Especie> recuperarPorId(Long id);

    Collection<Especie> recuperarPorDescricao(@Param("descricao") String descricao);

    List<Especie> recuperarEspecieAtivas(@Param("ativo") Boolean ativo);

}
