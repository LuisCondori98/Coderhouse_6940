package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

@SpringBootApplication
public class PreEntrega1Application implements CommandLineRunner{

	@Autowired
	private DaoFactory df;
	
	public static void main(String[] args) {
		SpringApplication.run(PreEntrega1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			Cliente cliente1 = new Cliente("Luis", "Condori", "lcond@gmail.com", 976325405, "Psj. Belen 159");
			Cliente cliente2 = new Cliente("Fiorella", "Contreras", "blancafio@hotmail.com", 987632518, "Jr. Lima 1258");
			Cliente cliente3 = new Cliente("Hugo", "Sanchez", "hsanchez_99@outlook.com", 961873256, "Av. Nicolas Arriola 2678");
			
			Producto producto1 = new Producto("Desodorante", 13, 25, "mal olor antimanchas", "Aseo Personal");
			Producto producto2 = new Producto("Jagermeister", 90, 13, "Bebida alcoholica dulce", "Bebida alcoholica");
			Producto producto3 = new Producto("Pan Bimbo", 13, 25, "pan blanco con nueces", "Panes");
			
			df.PersistirCliente(cliente1);
			df.PersistirCliente(cliente2);
			df.PersistirCliente(cliente3);
			
			df.PersistirProducto(producto1);
			df.PersistirProducto(producto2);
			df.PersistirProducto(producto3);
			
			}catch (Exception e) {
				
				e.printStackTrace(System.err);
			}
	}

	
}
