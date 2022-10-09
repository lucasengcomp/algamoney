package com.algamoneyapi.service;


import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public ResponseEntity<Categoria> salvar(Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = repository.save(categoria);
        eventoCategoriaCriada(response, categoriaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    public List<Categoria> buscaTodasAsCategorias() {
        return repository.findAll();
    }

    private Categoria buscarCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Optional<Categoria> buscaCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    private void eventoCategoriaCriada(HttpServletResponse response, Categoria categoriaSalva) {
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
    }
}