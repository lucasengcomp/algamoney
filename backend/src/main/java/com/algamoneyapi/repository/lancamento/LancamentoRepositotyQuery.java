package com.algamoneyapi.repository.lancamento;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositotyQuery {

    List<Lancamento> filtrar(LancamentoFilter filtro);
}
