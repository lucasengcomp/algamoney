package com.algamoneyapi.resource;

import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Categoria;
import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoService service;

    @GetMapping("/{codigo}")
    public Optional<Lancamento> buscarPorCodigo(@PathVariable Long codigo) {
        return service.buscaCategoriaPorCodigo(codigo);
    }

    @GetMapping
    public List<Lancamento> buscaTodos() {
        return service.buscaTodosLancamentosSemPaginacao();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        return service.salvar(lancamento, response);
    }
}
