package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String Nombre;
	
	private String Apellido;

	@Column(unique = true, nullable = false)
	private int Dni;
	
	private String Legajo;

	@ManyToMany(mappedBy = "Alumnos", fetch = FetchType.EAGER)
	private List<Curso> Cursos = new ArrayList<>();

	private LocalDateTime CreatedAt;

	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String apellido, int dni, String legajo) {
		this();
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Dni = dni;
		this.Legajo = legajo;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		this.Dni = dni;
	}

	public String getLegajo() {
		return Legajo;
	}

	public void setLegajo(String legajo) {
		this.Legajo = legajo;
	}

	public List<Curso> getCursos() {
		return Cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.Cursos = cursos;
	}

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.CreatedAt = createdAt;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + Id + ", nombre=" + Nombre + ", apellido=" + Apellido + ", dni=" + Dni + ", legajo="
				+ Legajo + ", cursos=" + Cursos + ", createdAt=" + CreatedAt + "]";
	}

}
