package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.mapper.UsuarioMapper;
import br.com.curso.web.spring.devdojo.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;

    @Override
    public Usuario salvarPor(Usuario Usuario) {
        if (Objects.isNull(Usuario))
            return null;

        return usuarioMapper.inserirPor(Usuario);
    }

    @Override
    public void salvar(Usuario Usuario) {
        if (Objects.isNull(Usuario))
            return;

        usuarioMapper.inserir(Usuario);
    }

    @Override
    public void excluir(Usuario Usuario) {
        if (Objects.isNull(Usuario))
            return;

        excluirPorId(Usuario.getUsuarioId());
    }

    @Override
    public void atualizar(Usuario Usuario) {
        if (Objects.isNull(Usuario))
            return;

        usuarioMapper.atualizarPor(Usuario);
    }

    @Override
    public void excluirPorId(Long id) {
        if (Objects.isNull(id))
            return;

        usuarioMapper.deleteById(id);
    }

    @Override
    public Usuario recuperarUsuario(String login, String senha) {
        if (Objects.isNull(login) || Objects.isNull(senha))
            return null;

        return usuarioMapper.recuperarUsuario(login, senha);
    }

    @Override
    public List<Usuario> recuperarUsuariosPorLogin(String login) {
        if (Objects.isNull(login))
            return null;

        return (List<Usuario>) usuarioMapper.recuperarUsuariosPorLogin(login);
    }

    @Override
    public List<Usuario> recuperarUsuarioAtivos(Boolean ativo) {
        if (Objects.isNull(ativo))
            return null;

        return (List<Usuario>) usuarioMapper.recuperarUsuarioAtivos(ativo);
    }

    @Override
    public List<Usuario> recuperarTodos() {
        return (List<Usuario>) usuarioMapper.recuperarTodos();
    }
}
