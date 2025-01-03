package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.*;

@SpringBootApplication
public class Clase08Application implements CommandLineRunner {

	@Autowired
	private DaoFactory df;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Clase08Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
		
		Curso curso1 = new Curso("Php");
		Curso curso2 = new Curso("Python");
		Curso curso3 = new Curso("Go");
		Curso curso4 = new Curso("Javascript");
		
		Alumno alumno1 = new Alumno("Luis", "Condori", 70121474, "K987450");
		Alumno alumno2 = new Alumno("Hugo", "Sanchez", 68724983, "T425196");
		Alumno alumno3 = new Alumno("Blanca", "Gil", 72189675, "G964837");
		Alumno alumno4 = new Alumno("Lindsay", "Bustios", 70357961, "L942078");
		
		df.PersistirAlumno(alumno1);
		df.PersistirAlumno(alumno2);
		df.PersistirAlumno(alumno3);
		df.PersistirAlumno(alumno4);
		
		df.PersistirCurso(curso1);
		df.PersistirCurso(curso2);
		df.PersistirCurso(curso3);
		df.PersistirCurso(curso4);
		
		}catch (Exception e) {
			
			e.printStackTrace(System.err);
		}
	}
}
