package com.delivery.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.delivery.service.entidad.Delivery;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery,  Integer>{

	List<Delivery> findByUsuarioId(int usuarioId);
	
}
