package com.algamoneyapi.service;

import com.algamoneyapi.model.Lancamento;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


public interface LancamentoService {

    Optional<Lancamento> buscaCategoriaPorCodigo(Long codigo);

    List<Lancamento> buscaTodosLancamentosSemPaginacao();

    ResponseEntity<Lancamento> salvar(Lancamento lancamento, HttpServletResponse response);
}
