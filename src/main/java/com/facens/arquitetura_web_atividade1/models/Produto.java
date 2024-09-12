package com.facens.arquitetura_web_atividade1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int qtd;
    
    @ManyToOne
    @JoinColumn(name = "produtoCategoria_id")
    @JsonBackReference
    private ProdutoCategoria produtoCategoria;

    public Produto(int id, String nome, int qtd, ProdutoCategoria produtoCategoria) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.produtoCategoria = produtoCategoria;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public ProdutoCategoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(ProdutoCategoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", qtd=" + qtd + ", produtoCategoria=" + produtoCategoria + "]";
    }
}
