package com.algamoneyapi.service.impl;

import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.repository.CategoriaRepository;
import com.algamoneyapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public ResponseEntity<Categoria> salvar(Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = repository.save(categoria);
        eventoCategoriaCriada(response, categoriaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @Override
    public Categoria buscarCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public List<Categoria> listarTodasCategorias() {
        return repository.findAll();
    }

    private void eventoCategoriaCriada(HttpServletResponse response, Categoria categoriaSalva) {
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
    }
}
