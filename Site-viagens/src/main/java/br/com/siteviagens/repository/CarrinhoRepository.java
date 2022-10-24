package br.com.siteviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteviagens.model.Carrinho;


public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
	
	
}