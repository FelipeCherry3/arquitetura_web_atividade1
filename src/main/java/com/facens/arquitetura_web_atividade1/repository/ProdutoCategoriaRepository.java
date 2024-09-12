package com.facens.arquitetura_web_atividade1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.facens.arquitetura_web_atividade1.models.ProdutoCategoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoCategoriaRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public ProdutoCategoria salvar(ProdutoCategoria produtoCategoria) {
       return entityManager.merge(produtoCategoria);
    }

    public List<ProdutoCategoria> obterTodos() {
        return entityManager
                .createQuery("from ProdutoCategoria", ProdutoCategoria.class).getResultList();
    }

    @Transactional
    public void excluir(ProdutoCategoria produtoCategoria) {
        entityManager.remove(produtoCategoria);
    }

    public List<ProdutoCategoria> obterPorId(int id) {
        String jpql = "select pc from ProdutoCategoria pc where pc.id = :id";
        TypedQuery<ProdutoCategoria> query = entityManager.createQuery(jpql, ProdutoCategoria.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
