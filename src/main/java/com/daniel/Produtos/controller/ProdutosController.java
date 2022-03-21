package com.daniel.Produtos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Produtos.model.entities.Produtos;
import com.daniel.Produtos.model.repositories.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
	
	@Autowired
	ProdutosRepository produtosCrud;

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produtos incluirProduto(@RequestParam String nome, @RequestParam double preco, @RequestParam double desconto) {
		Produtos produto = new Produtos(nome, preco, desconto);
		produtosCrud.save(produto);
		return produto;
	}
	
	@GetMapping("/todos")
	public Iterable<Produtos> consultarTodosProdutos(){
		return produtosCrud.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produtos> consultarPorId(@PathVariable int id) {
		return produtosCrud.findById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public void deletarPorId(@PathVariable int id) {
		produtosCrud.deleteById(id);		
	}
	
	@GetMapping(path="/nome/{partenome}")
	public Iterable<Produtos> consultarLikeNome(@PathVariable String partenome) {
		return produtosCrud.findByNomeContaining(partenome);		
	}
	
}
