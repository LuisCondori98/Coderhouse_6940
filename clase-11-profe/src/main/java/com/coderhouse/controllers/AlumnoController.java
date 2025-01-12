package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.models.Alumno;
import com.coderhouse.repositories.AlumnoRepository;
import com.coderhouse.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@GetMapping
	public ResponseEntity<List<Alumno>> getAllAlumnos() {
		
		try {
			
			List<Alumno> alumnos = alumnoService.getAllAlumnos();
			
			return ResponseEntity.ok(alumnos); // 200
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
		
		try {
			
				Alumno alumno = alumnoService.findById(id);
				
				return ResponseEntity.ok(alumno);
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
		
		try {
			
			Alumno alumnoCreado = alumnoService.saveAlumno(alumno);
			
			return ResponseEntity.ok(alumnoCreado);
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alumno> updateAlumnoById(@PathVariable long id, @RequestBody Alumno alumnoModificado){
		
		try {
			
			Alumno updateAlumno = alumnoService.updateAlumno(alumnoModificado, id);
			
			return ResponseEntity.ok(updateAlumno);
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deteAlumnoById(@PathVariable long id) {
		
		try {
			
			alumnoService.deleteAlumno(id);
			
			return ResponseEntity.noContent().build();
		} catch(IllegalArgumentException e) {
				
				return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
