package com.algamoneyapi.resource;

import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        return service.salvar(categoria, response);
    }

    @GetMapping("/{codigo}")
    public Optional<Categoria> buscarPorCodigo(@PathVariable Long codigo) {
        return service.buscaCategoriaPorCodigo(codigo);
    }

    @GetMapping
    public List<Categoria> listarTodasCategorias() {
        return service.buscaTodasAsCategorias();
    }
}
