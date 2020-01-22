package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public void salvar(Usuario Usuario);

    public Usuario salvarPor(Usuario Usuario);

    public void excluir(Usuario Usuario);

    public void atualizar(Usuario Usuario);

    public void excluirPorId(Long id);

    public Usuario recuperarUsuario(String login, String senha);

    public List<Usuario> recuperarUsuariosPorLogin(String login);

    public List<Usuario> recuperarUsuarioAtivos(Boolean ativo);

    public List<Usuario> recuperarTodos();
}
