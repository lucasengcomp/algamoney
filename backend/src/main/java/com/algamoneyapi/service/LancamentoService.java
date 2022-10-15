package com.algamoneyapi.service;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface LancamentoService {

    Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo);

    Page<Lancamento> buscaPaginada(LancamentoFilter lancamentoFilter, Pageable pageable);

    Lancamento salvarLancamentoComPessoaAtiva(Lancamento lancamento);

    void deletarLancamento(Long codigo);
}
