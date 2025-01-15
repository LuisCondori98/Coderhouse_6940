package com.coderhouse.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
			   inverseJoinColumns = @JoinColumn(name = "IdCliente"))
	@JsonIgnore
	private List<Cliente> Clientes = new ArrayList<>();
}
