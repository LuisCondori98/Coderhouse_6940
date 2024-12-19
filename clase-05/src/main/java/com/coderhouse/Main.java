package com.coderhouse;

import com.coderhouse.mascotas.Perro;

public class Main {

	public static void main(String[] args) {
		
		Perro unPerro = new Perro();
		
		unPerro.setNombre("Colita");
		unPerro.setColor("negro");
		
		unPerro.caminar();
		
		System.out.println(unPerro);
	}

}
