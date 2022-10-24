package br.com.siteviagens.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestino;

	@Column(nullable = false)
	private String destino;
	
	@Column(nullable = false, name = "data_viagem")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_viagem;
	

	public Destino() {
		super();
	}

	public Destino(Long idDestino, String destino, LocalDate data_viagem) {
		super();
		this.idDestino = idDestino;
		this.destino = destino;
		this.data_viagem = data_viagem;
			
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getData_viagem() {
		return data_viagem;
	}

	public void setData_viagem(LocalDate data_viagem) {
		this.data_viagem = data_viagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_viagem, destino, idDestino);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(data_viagem, other.data_viagem) && Objects.equals(destino, other.destino)
				&& Objects.equals(idDestino, other.idDestino);
	}

	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", destino=" + destino + ", data_viagem=" + data_viagem + "]";
	}
	
	
	
	}
