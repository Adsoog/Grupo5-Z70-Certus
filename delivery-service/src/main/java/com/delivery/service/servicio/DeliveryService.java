package com.delivery.service.servicio;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.service.entidad.Delivery;
import com.delivery.service.repositorio.DeliveryRepository;


@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public List<Delivery> getAll(){
		return deliveryRepository.findAll();
	}
	
	public Delivery getDeliveryById(int id) {
		return deliveryRepository.findById(id).orElse(null);
	}
	
	
	public Delivery save(Delivery delivery) {
        UUID uuid = UUID.randomUUID();
        int numericId = uuid.hashCode();
        delivery.setId(numericId);
        Delivery nuevoDelivery = deliveryRepository.save(delivery);
        return nuevoDelivery;
    }
	
	public List<Delivery> byUsuarioId(int usuarioId){
		return deliveryRepository.findByUsuarioId(usuarioId);
	}
	
	public void delete(Delivery delivery) {
		deliveryRepository.delete(delivery);
	}

}
