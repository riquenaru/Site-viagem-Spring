package br.com.siteviagens.model;

import java.util.Objects;	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private String cpf_cnpj;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Login login;
	
	public Usuario() {
		super();
	}

	public Usuario(Long idUsuario, String email, String senha, String cpf_cnpj, Login login) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.cpf_cnpj = cpf_cnpj;
		this.login = login;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf_cnpj, email, idUsuario, login, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf_cnpj, other.cpf_cnpj) && Objects.equals(email, other.email)
				&& Objects.equals(idUsuario, other.idUsuario) && Objects.equals(login, other.login)
				&& Objects.equals(senha, other.senha);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", email=" + email + ", senha=" + senha + ", cpf_cnpj=" + cpf_cnpj
				+ ", login=" + login + "]";
	}
	
	
	
	

}
