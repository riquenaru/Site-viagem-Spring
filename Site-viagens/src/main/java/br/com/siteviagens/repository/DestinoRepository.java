package br.com.siteviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;	

import br.com.siteviagens.model.Destino;


public interface DestinoRepository extends JpaRepository<Destino, Long> {
	
	

}