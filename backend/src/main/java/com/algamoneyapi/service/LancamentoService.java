package com.algamoneyapi.service;

import com.algamoneyapi.model.Lancamento;

import java.util.List;
import java.util.Optional;


public interface LancamentoService {

    Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo);

    List<Lancamento> buscaTodosLancamentosSemPaginacao();
}
