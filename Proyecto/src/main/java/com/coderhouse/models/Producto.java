package com.coderhouse.models;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdProducto;
	
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
	
	/*public Producto(String nombreProducto, double precioProducto, int stockProducto, String descripcionProducto,
			String categoriaProducto) {
		this();
		this.NombreProducto = nombreProducto;
		this.PrecioProducto = precioProducto;
		this.StockProducto = stockProducto;
		this.DescripcionProducto = descripcionProducto;
		this.CategoriaProducto = categoriaProducto;
	}*/
}
