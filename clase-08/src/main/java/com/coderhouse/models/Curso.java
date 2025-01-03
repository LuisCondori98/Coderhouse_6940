package com.coderhouse.models;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private String NombreCurso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "Curso_Alumno",
				joinColumns = @JoinColumn(name = "Curso_id"),
				inverseJoinColumns = @JoinColumn(name = "Alumno_id")
			  )
	private List<Alumno> Alumnos = new ArrayList<>();

	public Curso() {
		
		super();
	}
	
	public Curso(String nombreCurso) {
		
		this();
		NombreCurso = nombreCurso;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombreCurso() {
		return NombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		NombreCurso = nombreCurso;
	}

	public List<Alumno> getAlumnos() {
		return Alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.Alumnos = alumnos;
	}
}
