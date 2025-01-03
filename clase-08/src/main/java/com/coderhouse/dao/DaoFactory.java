package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.*;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void PersistirAlumno(Alumno alumno) {
		
		em.persist(alumno);
	}
	
	@Transactional
	public void PersistirCurso(Curso curso) {
		
		em.persist(curso);
	}
}
