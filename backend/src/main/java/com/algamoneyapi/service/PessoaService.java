package com.algamoneyapi.service;

import com.algamoneyapi.model.Pessoa;


public interface PessoaService {

    Pessoa atualizar(Long codigo, Pessoa pessoa);

    void atualizarPropriedadeAtivo(Long codigo, Boolean ativo);
}
