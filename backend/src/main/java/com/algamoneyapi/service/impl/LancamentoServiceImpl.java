package com.algamoneyapi.service.impl;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.LancamentoRepository;
import com.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Override
    public Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    @Override
    public List<Lancamento> buscaTodosLancamentosSemPaginacao() {
        return repository.findAll();
    }
}
