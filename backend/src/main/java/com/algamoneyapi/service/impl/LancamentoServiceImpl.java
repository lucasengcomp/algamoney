package com.algamoneyapi.service.impl;

import com.algamoneyapi.event.RecursoCriadoEvent;
import com.algamoneyapi.model.Lancamento;
import com.algamoneyapi.model.Pessoa;
import com.algamoneyapi.repository.LancamentoRepository;
import com.algamoneyapi.repository.PessoaRepository;
import com.algamoneyapi.repository.filter.LancamentoFilter;
import com.algamoneyapi.service.LancamentoService;
import com.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }

    @Override
    public Page<Lancamento> buscaPaginada(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return repository.filtrar(lancamentoFilter, pageable);
    }

    @Override
    public Lancamento salvarLancamentoComPessoaAtiva(Lancamento lancamento) {
        verificaSePessoaENulaOuInativa(pessoaRepository.findById(lancamento.getPessoa().getCodigo()));
        return repository.save(lancamento);
    }

    @Override
    public void deletarLancamento(Long codigo) {
        repository.deleteById(codigo);
    }

    private static void verificaSePessoaENulaOuInativa(Optional<Pessoa> pessoa) {
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
    }

    private void eventoLancamentoCriado(HttpServletResponse response, Lancamento lancamento) {
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamento.getCodigo()));
    }
}
