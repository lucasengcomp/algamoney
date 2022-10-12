package com.algamoneyapi.service.impl;

import com.algamoneyapi.model.Pessoa;
import com.algamoneyapi.repository.PessoaRepository;
import com.algamoneyapi.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoaEncontrada = buscarPessoaPeloCodigo(codigo);
        copiaPropriedadesPessoaEValidaDados(pessoa, pessoaEncontrada);
        return repository.save(pessoaEncontrada);
    }

    @Override
    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaEncontrada = buscarPessoaPeloCodigo(codigo);
        pessoaEncontrada.setAtivo(ativo);
        repository.save(pessoaEncontrada);
    }

    private Pessoa buscarPessoaPeloCodigo(Long codigo) {
        return repository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    private static void copiaPropriedadesPessoaEValidaDados(Pessoa pessoa, Pessoa pessoaSalva) {
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
    }
}
