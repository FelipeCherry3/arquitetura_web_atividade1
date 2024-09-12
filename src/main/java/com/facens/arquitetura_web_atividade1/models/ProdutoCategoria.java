package com.facens.arquitetura_web_atividade1.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class ProdutoCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoriaNome;
    private String categoria;
    
    @OneToMany(mappedBy = "produtoCategoria")
    @JsonManagedReference
    private List<Produto> produtos;

    public ProdutoCategoria(int id, String categoriaNome, String categoria) {
        this.id = id;
        this.categoriaNome = categoriaNome;
        this.categoria = categoria;
    }

    public ProdutoCategoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "ProdutoCategoria [id=" + id + ", categoriaNome=" + categoriaNome + ", categoria=" + categoria;
    }
}
