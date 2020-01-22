package br.com.curso.web.spring.devdojo.mapper;

import br.com.curso.web.spring.devdojo.model.Raca;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface RacaMapper {

    public void inserir(Raca raca);

    public Raca inserirPor(Raca raca);

    public void atualizarPor(Raca raca);

    public void excluirPorId(Long id);

    public Collection<Raca> recuperarTodas();

    public Collection<Raca> recuperarPorId(Long id);

    public Collection<Raca> recuperarPorDescricao(@Param("descricao") String descricao);

    public List<Raca> recuperarRacaAtivas(@Param("ativo") Boolean ativo);

}
