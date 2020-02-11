package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    void salvar(Usuario Usuario);

    Usuario salvarPor(Usuario Usuario);

    void excluir(Usuario Usuario);

    void atualizar(Usuario Usuario);

    void excluirPorId(Long id);

    Usuario recuperarUsuario(String login, String senha);

    List<Usuario> recuperarUsuariosPorLogin(String login);

    List<Usuario> recuperarUsuarioAtivos(Boolean ativo);

    List<Usuario> recuperarTodos();
}
