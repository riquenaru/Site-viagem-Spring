package br.com.siteviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;	

import br.com.siteviagens.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	 

}