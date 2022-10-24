package br.com.siteviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siteviagens.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}