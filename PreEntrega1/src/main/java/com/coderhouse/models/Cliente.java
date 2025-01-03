package com.coderhouse.models;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCliente;
	
	private String NombreCliente;
	private String ApellidoCliente;
	
	@Column(unique = true)
	private String CorreoCliente;
	
	@Column(unique = true)
	private int TelefonoCliente;
	
	private String DireccionCliente;
	
	@ManyToMany(mappedBy = "Clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();

	public Cliente() {
		super();
	}
	
	public Cliente(String nombreCliente, String apellidoCliente, String correoCliente, int telefonoCliente,
			String direccionCliente) {
		this();
		this.NombreCliente = nombreCliente;
		this.ApellidoCliente = apellidoCliente;
		this.CorreoCliente = correoCliente;
		this.TelefonoCliente = telefonoCliente;
		this.DireccionCliente = direccionCliente;
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return ApellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		ApellidoCliente = apellidoCliente;
	}

	public String getCorreoCliente() {
		return CorreoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		CorreoCliente = correoCliente;
	}

	public int getTelefonoCliente() {
		return TelefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		TelefonoCliente = telefonoCliente;
	}

	public String getDireccionCliente() {
		return DireccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		DireccionCliente = direccionCliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Cliente [IdCliente=" + IdCliente + ", NombreCliente=" + NombreCliente + ", ApellidoCliente="
				+ ApellidoCliente + ", CorreoCliente=" + CorreoCliente + ", TelefonoCliente=" + TelefonoCliente
				+ ", DireccionCliente=" + DireccionCliente + ", productos=" + productos + "]";
	}
}