package com.coderhouse.models;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCategoria;
	
	@Column(unique = true, nullable = false)
	private String NombreCategoria;
	
	@OneToMany(mappedBy = "Categoria", fetch = FetchType.EAGER)
	private List<Curso> cursos = new ArrayList<>();

	public Categoria() {
		super();
	}

	public Categoria(String nombreCategoria) {
		this();
		this.NombreCategoria = nombreCategoria;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Categoria [IdCategoria=" + IdCategoria + ", NombreCategoria=" + NombreCategoria + ", cursos=" + cursos
				+ "]";
	}
}
