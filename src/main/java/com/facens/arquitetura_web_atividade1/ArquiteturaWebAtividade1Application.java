package com.facens.arquitetura_web_atividade1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.facens.arquitetura_web_atividade1.models.Produto;
import com.facens.arquitetura_web_atividade1.models.ProdutoCategoria;
import com.facens.arquitetura_web_atividade1.repository.ProdutoCategoriaRepository;
import com.facens.arquitetura_web_atividade1.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ArquiteturaWebAtividade1Application {
	@Bean
	@Transactional
	public CommandLineRunner init(
			@Autowired ProdutoCategoriaRepository produtoCategoriaRepository,
			@Autowired ProdutoRepository produtoRepository) {
		return args -> {
			System.out.println("*** CRIANDO AS CATEGORIAS ***");
			ProdutoCategoria c1 = produtoCategoriaRepository.salvar(
					new ProdutoCategoria(0, "Cadeiras", "Móveis de madeira"));
			ProdutoCategoria c2 = produtoCategoriaRepository.salvar(
					new ProdutoCategoria(0, "Mesas","Mesas em madeira maciça"));
			List<ProdutoCategoria> listaCategorias = produtoCategoriaRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("*** CRIANDO PRODUTOS ***");
			produtoRepository.salvar(
					new Produto(0, "Cadeira Diamante", 2000, c1));
					produtoRepository.salvar(
					new Produto(0, "Mesa Redonda", 2050, c2));
			List<Produto> listaCursos = produtoRepository.obterTodos();
			listaCursos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaWebAtividade1Application.class, args);

		
	}

}
