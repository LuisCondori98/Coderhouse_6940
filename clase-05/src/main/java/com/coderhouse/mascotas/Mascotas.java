package com.coderhouse.mascotas;

public class Mascotas {
	
	private  static final int EDAD_MAXIMA = 15;
	
	String mensajeDeError = "La mascota no vive mas de " + EDAD_MAXIMA + " años de edad.!";

	private String Nombre;
	private String Raza;
	private String Color;
	private String Tamanio;
	private Integer Edad;
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getRaza() {
		return Raza;
	}

	public void setRaza(String raza) {
		Raza = raza;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getTamanio() {
		return Tamanio;
	}

	public void setTamanio(String tamanio) {
		Tamanio = tamanio;
	}

	public Integer getEdad() {
		return Edad;
	}

	public void setEdad(Integer edad) throws Exception {
		
		if(edad > EDAD_MAXIMA) {
			
			throw new Exception(mensajeDeError);
		} else {
			
			this.Edad = edad;
		}
	}

	public void caminar() {
		
		System.out.println("El perro " + getNombre() + " esta caminando");
	}
	
	public void comer() {
		
		System.out.println("El perro " + getNombre() + " esta comiendo");
	}

	@Override
	public String toString() {
		return "Mascotas [Nombre=" + Nombre + ", Raza=" + Raza + ", Color="
				+ Color + ", Tamanio=" + Tamanio + ", Edad=" + Edad + "]";
	}
}
