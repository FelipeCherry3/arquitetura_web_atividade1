package com.facens.arquitetura_web_atividade1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facens.arquitetura_web_atividade1.models.Produto;
import com.facens.arquitetura_web_atividade1.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/obtertodos")
    public List<Produto> getProdutos() {
        return produtoRepository.obterTodos();
    }

    @PostMapping("/cadastrar")
    public String postMethodName(@RequestBody Produto produto) {
        produtoRepository.salvar(produto);
        
        return "Cadastrado";
    }

    @GetMapping("/get")
    public Produto getProdutoPorId(@RequestParam("id") int id) {
        Produto produto = produtoRepository.obterPorId(id);
        return produto;
    }
    
}
