package com.delivery.service.entidad;



import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Document(collection = "deliverys")
@Data
public class Delivery {
	
	@Id
	private int id;

	private String nombre;
	private String comida;
	private String direccion;
	private int precio;
	private int usuarioId;
	
	public Delivery() {
		super();
	}
	
	

}
