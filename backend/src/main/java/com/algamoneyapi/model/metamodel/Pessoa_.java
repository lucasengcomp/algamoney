package com.algamoneyapi.model.metamodel;

import com.algamoneyapi.model.Endereco;
import com.algamoneyapi.model.Pessoa;

import javax.persistence.metamodel.SingularAttribute;

public class Pessoa_ {
    public static volatile SingularAttribute<Pessoa, Long> codigo;
    public static volatile SingularAttribute<Pessoa, Boolean> ativo;
    public static volatile SingularAttribute<Pessoa, Endereco> endereco;
    public static volatile SingularAttribute<Pessoa, String> nome;

    public static final String CODIGO = "codigo";
    public static final String ATIVO = "ativo";
    public static final String ENDERECO = "endereco";
    public static final String NOME = "nome";
}
