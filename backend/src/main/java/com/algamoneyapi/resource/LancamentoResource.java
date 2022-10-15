package com.algamoneyapi.resource;

import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.repository.filter.LancamentoFilter;
import com.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
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

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/{codigo}")
    public Optional<Lancamento> buscarPorCodigo(@PathVariable Long codigo) {
        return service.buscaCategoriaPorCodigo(codigo);
    }

    @GetMapping
    public List<Lancamento> pesquisar(LancamentoFilter filtroLancamento) {
        return service.buscaTodosLancamentosSemPaginacao();
    }

    @PostMapping
    public ResponseEntity<Lancamento> salvarComPessoaStatusAtiva(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo = service.salvarLancamentoComPessoaAtiva(lancamento);
        eventoParaValidarLancamentoCriado(response, lancamentoSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Lancamento> remover(@PathVariable Long codigo) {
        service.deletarLancamento(codigo);
        return ResponseEntity.noContent().build();
    }

    private void eventoParaValidarLancamentoCriado(HttpServletResponse response, Lancamento lancamentoSalvo) {
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
    }
}
