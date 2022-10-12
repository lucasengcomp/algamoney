package com.algamoneyapi.service;


import com.algamoneyapi.model.Categoria;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CategoriaService {

    ResponseEntity<Categoria> salvar(Categoria categoria, HttpServletResponse response);

    Categoria buscarCategoriaPorCodigo(Long codigo);

    List<Categoria> listarTodasCategorias();
}