package com.facens.arquitetura_web_atividade1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.facens.arquitetura_web_atividade1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> obterTodos() {
        return entityManager
                .createQuery("from Produto", Produto.class).getResultList();
    }

    @Transactional
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    public Produto obterPorId(int id) {
        String jpql = "select p from Produto p where p.id = :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
