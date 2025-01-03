package com.coderhouse.models;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProducto;
	
	private String NombreProducto;
	private double PrecioProducto;
	private int StockProducto;
	private String DescripcionProducto;
	private String CategoriaProducto;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Cliente_Producto",
			   joinColumns = @JoinColumn(name = "IdProducto"),
			   inverseJoinColumns = @JoinColumn(name = "IdCliente")
			   )
	private List<Cliente> Clientes = new ArrayList<>();

	public Producto() {
		super();
	}
	
	public Producto(String nombreProducto, double precioProducto, int stockProducto, String descripcionProducto,
			String categoriaProducto) {
		this();
		this.NombreProducto = nombreProducto;
		this.PrecioProducto = precioProducto;
		this.StockProducto = stockProducto;
		this.DescripcionProducto = descripcionProducto;
		this.CategoriaProducto = categoriaProducto;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return PrecioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		PrecioProducto = precioProducto;
	}

	public int getStockProducto() {
		return StockProducto;
	}

	public void setStockProducto(int stockProducto) {
		StockProducto = stockProducto;
	}

	public String getDescripcionProducto() {
		return DescripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		DescripcionProducto = descripcionProducto;
	}

	public String getCategoriaProducto() {
		return CategoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		CategoriaProducto = categoriaProducto;
	}

	public List<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

	@Override
	public String toString() {
		return "Producto [IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", PrecioProducto="
				+ PrecioProducto + ", StockProducto=" + StockProducto + ", DescripcionProducto=" + DescripcionProducto
				+ ", CategoriaProducto=" + CategoriaProducto + ", Clientes=" + Clientes + "]";
	}
}
