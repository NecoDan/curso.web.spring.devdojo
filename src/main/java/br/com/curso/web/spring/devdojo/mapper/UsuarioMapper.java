package br.com.curso.web.spring.devdojo.mapper;

import br.com.curso.web.spring.devdojo.model.Usuario;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface UsuarioMapper {

    public void inserir(Usuario usuario);

    public Usuario inserirPor(Usuario usuario);

    public void atualizarPor(Usuario usuario);

    public void deleteById(Long id);

    public Collection<Usuario> recuperarTodos();

    public Usuario recuperarUsuario(@Param("login") String login, @Param("senha") String senha);

    public Collection<Usuario> recuperarUsuariosPorLogin(@Param("login") String login);

    public List<Usuario> recuperarUsuarioAtivos(@Param("ativo") Boolean ativo);

}
