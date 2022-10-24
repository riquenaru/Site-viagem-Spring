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
public class Passagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassagem;

	@Column(nullable = false)
	private double preco_passagem;

	
	@ManyToOne
	@JoinColumn(name = "idCarrinho")
	private Carrinho carrinho;
	
	@ManyToOne
	@JoinColumn(name = "idDestino")
	private Destino destino;
	

	public Passagem() {
		super();
	}

	public Passagem(Long idPassagem, double preco_passagem, Carrinho carrinho, Destino destino) {
		super();
		this.idPassagem = idPassagem;
		this.preco_passagem = preco_passagem;
		this.carrinho = carrinho;
		this.destino = destino;
	}

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long idPassagem) {
		this.idPassagem = idPassagem;
	}

	public double getPreco_passagem() {
		return preco_passagem;
	}

	public void setPreco_passagem(double preco_passagem) {
		this.preco_passagem = preco_passagem;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrinho, destino, idPassagem, preco_passagem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(carrinho, other.carrinho) && Objects.equals(destino, other.destino)
				&& Objects.equals(idPassagem, other.idPassagem)
				&& Double.doubleToLongBits(preco_passagem) == Double.doubleToLongBits(other.preco_passagem);
	}

	@Override
	public String toString() {
		return "Passagem [idPassagem=" + idPassagem + ", preco_passagem=" + preco_passagem + ", carrinho=" + carrinho
				+ ", destino=" + destino + "]";
	}
	
	
}
