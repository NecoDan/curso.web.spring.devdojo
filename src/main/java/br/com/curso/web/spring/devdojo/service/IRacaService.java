package br.com.curso.web.spring.devdojo.service;

import br.com.curso.web.spring.devdojo.util.exceptions.ValidacaoException;
import br.com.curso.web.spring.devdojo.model.Raca;

import java.util.Collection;
import java.util.List;

public interface IRacaService {

    void inserir(Raca raca) throws ValidacaoException;

    Raca inserirPor(Raca raca) throws ValidacaoException;

    void atualizarPor(Raca raca) throws ValidacaoException;

    void excluirPorId(Long id) throws ValidacaoException;

    Collection<Raca> recuperarTodas();

    Collection<Raca> recuperarPorId(Long id);

    Collection<Raca> recuperarPorDescricao(String descricao);

    List<Raca> recuperarRacaAtivas(Boolean ativo);
}
