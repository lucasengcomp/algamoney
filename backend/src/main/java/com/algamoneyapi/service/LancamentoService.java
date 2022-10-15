package com.algamoneyapi.service;

import com.algamoneyapi.model.Lancamento;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface LancamentoService {

    Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo);

    List<Lancamento> buscaTodosLancamentosSemPaginacao();

    Lancamento salvarLancamentoComPessoaAtiva(Lancamento lancamento);

    void deletarLancamento(Long codigo);
}
