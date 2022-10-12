package com.algamoneyapi.service.impl;

import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.LancamentoRepository;
import com.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    @Override
    public List<Lancamento> buscaTodosLancamentosSemPaginacao() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Lancamento> salvar(Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo = repository.save(lancamento);
        eventoLancamentoCriado(response, lancamentoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    private void eventoLancamentoCriado(HttpServletResponse response, Lancamento lancamento) {
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamento.getCodigo()));
    }
}
