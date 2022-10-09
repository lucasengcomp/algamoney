package com.algamoneyapi.service;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    public Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    public List<Lancamento> buscaTodosLancamentosSemPaginacao() {
        return repository.findAll();
    }
}
