package com.coderhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Producto;
import com.coderhouse.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	//CREATE
	@Transactional
	public Producto createProducto(Producto producto) {
		
		return productoRepository.save(producto);
	}
	
	//READ
	public List<Producto> getAllProductos() {
		
		return productoRepository.findAll();
	}
	
	//UPDATE
	@Transactional
	public Producto updateProducto(long id, Producto productoModificado) {
		
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
		
		if (productoModificado.getNombreProducto() != null && !productoModificado.getNombreProducto().isEmpty()) {
			producto.setNombreProducto(productoModificado.getNombreProducto());
	    }

	    if (productoModificado.getPrecioProducto() != 0) {
	    	producto.setPrecioProducto(productoModificado.getPrecioProducto());
	    }

	    if (productoModificado.getStockProducto() != 0) {
	    	producto.setStockProducto(productoModificado.getStockProducto());
	    }

	    if (productoModificado.getDescripcionProducto() != null && !productoModificado.getDescripcionProducto().isEmpty()) {
	    	producto.setDescripcionProducto(productoModificado.getDescripcionProducto());
	    }

	    if (productoModificado.getCategoriaProducto() != null && !productoModificado.getCategoriaProducto().isEmpty()) {
	    	producto.setCategoriaProducto(productoModificado.getCategoriaProducto());
	    }
		
		return productoRepository.save(producto);
	}
	
	//DELETE
	public void deleteProducto(long id) {
		
		if(!productoRepository.existsById(id)) {
			
			throw new IllegalArgumentException("Producto no encontrado");
		}
		
		productoRepository.deleteById(id);
	}
	
	//FINDBYID
	public Producto findById(long id) {
		
		return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
	}
}
