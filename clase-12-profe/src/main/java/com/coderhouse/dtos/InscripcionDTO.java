package com.coderhouse.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscripcionDTO {

	private long AlumnoId;
	private List<Long> CursoIds;
	
}
