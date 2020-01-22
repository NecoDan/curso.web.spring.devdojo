package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.mapper.EspecieMapper;
import br.com.curso.web.spring.devdojo.model.Especie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EspecieService implements IEspecieService {

    private final EspecieMapper especieMapper;

    @Override
    public void inserir(Especie especie) {
        if (Objects.isNull(especie))
            return;

        especieMapper.inserir(especie);
    }

    @Override
    public Especie inserirPor(Especie especie) {
        if (Objects.isNull(especie))
            return null;

        return especieMapper.inserirPor(especie);
    }

    @Override
    public void atualizarPor(Especie especie) {
        if (Objects.isNull(especie))
            return;

        especieMapper.atualizarPor(especie);
    }

    @Override
    public void excluirPorId(Long id) {
        if (Objects.isNull(id))
            return;

        especieMapper.excluirPorId(id);
    }

    @Override
    public Collection<Especie> recuperarTodas() {
        return especieMapper.recuperarTodas();
    }

    @Override
    public Collection<Especie> recuperarPorId(Long id) {
        if (Objects.isNull(id))
            return null;

        return especieMapper.recuperarPorId(id);
    }

    @Override
    public Collection<Especie> recuperarPorDescricao(String descricao) {
        if (Objects.isNull(descricao))
            return null;

        return especieMapper.recuperarPorDescricao(descricao);
    }

    @Override
    public List<Especie> recuperarEspecieAtivas(Boolean ativo) {
        if (Objects.isNull(ativo))
            return null;

        return especieMapper.recuperarEspecieAtivas(ativo);
    }
}
