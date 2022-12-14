package com.algamoneyapi.repository.lancamento;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositotyQuery {
    Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
