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
@Table(name="Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdCliente;
	
	private String NombreCliente;
	private String ApellidoCliente;
	
	@Column(unique = true)
	private String CorreoCliente;
	
	@Column(unique = true)
	private int TelefonoCliente;
	
	private String DireccionCliente;
	
	@ManyToMany(mappedBy = "Clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
}