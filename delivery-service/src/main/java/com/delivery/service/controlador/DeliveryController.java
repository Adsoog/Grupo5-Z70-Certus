package com.delivery.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.service.entidad.Delivery;
import com.delivery.service.servicio.DeliveryService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping
	public ResponseEntity<List<Delivery>> listarUsuarios() {
		List<Delivery> deliverys = deliveryService.getAll();
		if (deliverys.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(deliverys);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Delivery> obtenerDelivery(@PathVariable("id") int id) {
		Delivery delivery= deliveryService.getDeliveryById(id);
		if (delivery == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(delivery);
	}

	@PostMapping
	public ResponseEntity<Delivery> guardarDelivery(@RequestBody Delivery delivery){
		Delivery nuevoDelivery= deliveryService.save(delivery);
		return ResponseEntity.ok(nuevoDelivery);
	}

	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Delivery>> listarDeliverysPorUsuarioId(@PathVariable("usuarioId") int id) {
		List<Delivery>  deliverys = deliveryService.byUsuarioId(id);
		if (deliverys.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(deliverys);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarDelivery(@PathVariable("id") int id) {
	    Delivery delivery = deliveryService.getDeliveryById(id);
	    if (delivery == null) {
	        return ResponseEntity.notFound().build();
	    }
	    deliveryService.delete(delivery);
	    return ResponseEntity.noContent().build();
	}

}
