package br.com.curso.web.spring.devdojo.mapper;

import br.com.curso.web.spring.devdojo.model.Especie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface EspecieMapper {

    public void inserir(Especie especie);

    public Especie inserirPor(Especie especie);

    public void atualizarPor(Especie especie);

    public void excluirPorId(Long id);

    public Collection<Especie> recuperarTodas();

    public Collection<Especie> recuperarPorId(Long id);

    public Collection<Especie> recuperarPorDescricao(@Param("descricao") String descricao);

    public List<Especie> recuperarEspecieAtivas(@Param("ativo") Boolean ativo);

}
