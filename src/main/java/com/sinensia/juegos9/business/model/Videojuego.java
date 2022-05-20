package com.sinensia.juegos9.business.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VIDEOJUEGOS")
public class Videojuego implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer codigo;
	
	private String titulo;
	private Date fechaAlta;
	private Double precio;
	private Boolean descatalogado;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_FABRICANTE")
	private Fabricante fabricante;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_JUEGO")
	private Tipo tipo;
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Boolean getDescatalogado() {
		return descatalogado;
	}
	
	public void setDescatalogado(Boolean descatalogado) {
		this.descatalogado = descatalogado;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	@Override
	public String toString() {
		return "Videojuego [codigo=" + codigo + ", titulo=" + titulo + ", fechaAlta=" + fechaAlta + ", precio=" + precio
				+ ", descatalogado=" + descatalogado + ", fabricante=" + fabricante + ", tipo=" + tipo + "]";
	}
	
}
