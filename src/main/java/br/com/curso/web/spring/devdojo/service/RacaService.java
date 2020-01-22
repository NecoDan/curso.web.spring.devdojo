package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.infra.exceptions.ValidacaoException;
import br.com.curso.web.spring.devdojo.mapper.RacaMapper;
import br.com.curso.web.spring.devdojo.model.Raca;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RacaService implements IRacaService {

    private final RacaMapper racaMapper;

    @Override
    public void inserir(Raca raca) throws ValidacaoException {
        if (Objects.isNull(raca))
            throw new ValidacaoException("Raça como parâmetro inválida e/o inexistente.");

        racaMapper.inserir(raca);
    }

    @Override
    public Raca inserirPor(Raca raca) throws ValidacaoException {
        return null;
    }

    @Override
    public void atualizarPor(Raca raca) throws ValidacaoException {

    }

    @Override
    public void excluirPorId(Long id) throws ValidacaoException {

    }

    @Override
    public Collection<Raca> recuperarTodas() {
        return racaMapper.recuperarTodas();
    }

    @Override
    public Collection<Raca> recuperarPorId(Long id) {
        return null;
    }

    @Override
    public Collection<Raca> recuperarPorDescricao(String descricao) {
        return null;
    }

    @Override
    public List<Raca> recuperarRacaAtivas(Boolean ativo) {
        return null;
    }
}
