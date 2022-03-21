package com.daniel.Produtos.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniel.Produtos.model.entities.Produtos;

public interface ProdutosRepository extends CrudRepository<Produtos, Integer>{
	
	public Iterable<Produtos> findByNomeContaining(String parteNome);

}
