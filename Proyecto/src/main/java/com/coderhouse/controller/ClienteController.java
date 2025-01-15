package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.dtos.VentaProductoDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		
		try {
			
			Cliente clientes = clienteService.createCliente(cliente);
			
			return ResponseEntity.ok(clientes);
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/realizar-compra")
	public ResponseEntity<Cliente> realizarCompra(@RequestBody VentaProductoDTO dto) {
		
		try {
			
			Cliente cliente = clienteService.realizarCompra(dto);
			
			return ResponseEntity.ok(cliente);
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		
		try {
			
			List<Cliente> clientes = clienteService.getClientes();
			
			return ResponseEntity.ok(clientes);
		} catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable long id, @RequestBody Cliente clienteModificado) {
		
		try {
			
			Cliente cliente = clienteService.updateCliente(clienteModificado, id);
			
			return ResponseEntity.ok(cliente);
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable long id) {
		
		try {
			
			clienteService.deleteCliente(id);
			
			return ResponseEntity.noContent().build();
			
		} catch(IllegalArgumentException e) {
			
			return ResponseEntity.notFound().build();
		} catch(Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable long id) {
		
		try {
			
			Cliente cliente = clienteService.findById(id);
			
			return ResponseEntity.ok(cliente);
		} catch(Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
