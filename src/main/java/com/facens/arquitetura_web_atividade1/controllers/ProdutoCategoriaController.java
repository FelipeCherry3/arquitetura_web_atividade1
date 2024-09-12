package com.facens.arquitetura_web_atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facens.arquitetura_web_atividade1.models.Produto;
import com.facens.arquitetura_web_atividade1.models.ProdutoCategoria;
import com.facens.arquitetura_web_atividade1.repository.ProdutoCategoriaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/categoriaProduto")
public class ProdutoCategoriaController {
    @Autowired
    private ProdutoCategoriaRepository produtoCategoriaRepository;

    @GetMapping("/getAll")
    public List<ProdutoCategoria> getAllCategoria() {
        return produtoCategoriaRepository.obterTodos();
    }
    
    @PostMapping("/cadastrar")
    public String postCategoria(@RequestBody ProdutoCategoria produtoCategoria) {
        produtoCategoriaRepository.salvar(produtoCategoria);
        
        return "Categoria Salva!";
    }
    
}
