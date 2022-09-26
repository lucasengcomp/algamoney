package com.algamoneyapi.resource;

import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository repository;


    @GetMapping
    public List<Categoria> listarTodasCategorias() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria entidade, HttpServletResponse response) {
        Categoria categoriaSalva = repository.save(entidade);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Optional<Categoria>> buscaPorCodigo(@PathVariable Long codigo) throws Exception {
        Optional<Categoria> categoriaEncontrada = repository.findById(codigo);
       return categoriaEncontrada == null ? ResponseEntity.ok(categoriaEncontrada) : ResponseEntity.notFound().build();
    }
}
