package br.com.siteviagens.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCarrinho;

	@Column(nullable = false)
	private Long qtd_itens;

	@Column(nullable = false, name = "data_compra")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_compra;

	@Column(nullable = false)
	private double valor_total;
	
	@Column(nullable = false)
	private String passagem;
	
	@ManyToOne
	@JoinColumn(name = "idPassagem")
	private Passagem passagens;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	

	public Carrinho() {
		super();
	}

	public Carrinho(Long idCarrinho, Long qtd_itens, LocalDate data_compra, double valor_total, String passagem,
			Passagem passagens, Usuario usuario) {
		super();
		this.idCarrinho = idCarrinho;
		this.qtd_itens = qtd_itens;
		this.data_compra = data_compra;
		this.valor_total = valor_total;
		this.passagem = passagem;
		this.passagens = passagens;
		this.usuario = usuario;
	}

	public Long getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public Long getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(Long qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public LocalDate getData_compra() {
		return data_compra;
	}

	public void setData_compra(LocalDate data_compra) {
		this.data_compra = data_compra;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public String getPassagem() {
		return passagem;
	}

	public void setPassagem(String passagem) {
		this.passagem = passagem;
	}

	public Passagem getPassagens() {
		return passagens;
	}

	public void setPassagens(Passagem passagens) {
		this.passagens = passagens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_compra, idCarrinho, passagem, passagens, qtd_itens, usuario, valor_total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrinho other = (Carrinho) obj;
		return Objects.equals(data_compra, other.data_compra) && Objects.equals(idCarrinho, other.idCarrinho)
				&& Objects.equals(passagem, other.passagem) && Objects.equals(passagens, other.passagens)
				&& Objects.equals(qtd_itens, other.qtd_itens) && Objects.equals(usuario, other.usuario)
				&& Double.doubleToLongBits(valor_total) == Double.doubleToLongBits(other.valor_total);
	}

	@Override
	public String toString() {
		return "Carrinho [idCarrinho=" + idCarrinho + ", qtd_itens=" + qtd_itens + ", data_compra=" + data_compra
				+ ", valor_total=" + valor_total + ", passagem=" + passagem + ", passagens=" + passagens + ", usuario="
				+ usuario + "]";
	}
	
	
}
