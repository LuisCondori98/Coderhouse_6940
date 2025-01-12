package com.coderhouse.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Alumno;
import com.coderhouse.repositories.AlumnoRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService {

	private AlumnoRepository alumnoRepository;
	
	public List<Alumno> getAllAlumnos(){
		
		return alumnoRepository.findAll();
	}
	
	public Alumno findById(long id) {
		
		return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
	}
	
	@Transactional
	public Alumno saveAlumno(Alumno alumno) {
		
		return alumnoRepository.save(alumno);
	}
	
	@Transactional
	public Alumno updateAlumno(Alumno alumnoDetails, long id) {
		
		Alumno alumno = alumnoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
		
		alumno.setNombre(alumnoDetails.getNombre());
		alumno.setApellido(alumnoDetails.getApellido());
		
		if(alumnoDetails.getDni() != 0) {
			
			alumno.setDni(alumnoDetails.getDni());
		}
		
		if(alumnoDetails.getLegajo() != null && !alumnoDetails.getLegajo().isEmpty()) {
			
			alumno.setLegajo(alumnoDetails.getLegajo());
		}
		
		return alumnoRepository.save(alumno);
	}
	
	public void deleteAlumno(long id) {
		
		if(!alumnoRepository.existsById(id)) {
			
			throw new IllegalArgumentException("Alumno no encontrado");
		}
		
		alumnoRepository.deleteById(id);
	}
}
