package com.coderhouse.dtos;

import java.util.List;

import lombok.*;

@Getter
@Setter
public class VentaProductoDTO {

	private Long idCliente;
	private List<Long> productoIds;
}
