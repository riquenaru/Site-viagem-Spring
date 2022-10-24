package br.com.siteviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteviagens.model.Passagem;


public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}