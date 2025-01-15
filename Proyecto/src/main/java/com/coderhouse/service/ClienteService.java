package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.VentaProductoDTO;
import com.coderhouse.models.*;
import com.coderhouse.repository.ClienteRepository;
import com.coderhouse.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	//CREATE
	@Transactional
	public Cliente createCliente(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}
	
	//READ
	public List<Cliente> getClientes() {
		
		return clienteRepository.findAll();
	}
	
	//UPDATE
	@Transactional
	public Cliente updateCliente(Cliente clienteUpdate, long id) {
		
		Cliente cliente = clienteRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
		
		if (clienteUpdate.getNombreCliente() != null && !clienteUpdate.getNombreCliente().isEmpty()) {
	        cliente.setNombreCliente(clienteUpdate.getNombreCliente());
	    }

	    if (clienteUpdate.getApellidoCliente() != null && !clienteUpdate.getApellidoCliente().isEmpty()) {
	        cliente.setApellidoCliente(clienteUpdate.getApellidoCliente());
	    }

	    if (clienteUpdate.getDireccionCliente() != null && !clienteUpdate.getDireccionCliente().isEmpty()) {
	        cliente.setDireccionCliente(clienteUpdate.getDireccionCliente());
	    }

	    if (clienteUpdate.getCorreoCliente() != null && !clienteUpdate.getCorreoCliente().isEmpty()) {
	        cliente.setCorreoCliente(clienteUpdate.getCorreoCliente());
	    }

	    if (clienteUpdate.getTelefonoCliente() != 0) {
	        cliente.setTelefonoCliente(clienteUpdate.getTelefonoCliente());
	    }
		
		return clienteRepository.save(cliente);
	}
	
	//DELETE
	public void deleteCliente(long id) {
		
		if(!clienteRepository.existsById(id)) {
			
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		
		clienteRepository.deleteById(id);
	}
	
	public Cliente findById(long id) {
		
		return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	
	public Cliente realizarCompra(VentaProductoDTO dto) {
		
		Cliente cliente = clienteRepository.findById(dto.getIdCliente())
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));
		
		for(Long idProductos : dto.getProductoIds()) {
			
			Producto producto = productoRepository.findById(idProductos)
					.orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
			
			cliente.getProductos().add(producto);
			producto.getClientes().add(cliente);
			
			productoRepository.save(producto);
		}
		
		return clienteRepository.save(cliente);
	}
}
