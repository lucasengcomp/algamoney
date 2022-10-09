package com.algamoneyapi.resource;

import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
