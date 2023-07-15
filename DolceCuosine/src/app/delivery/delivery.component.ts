import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';

interface Delivery {
  id: number;
  nombre: string;
  comida: string;
  direccion: string;
  precio: number;
  usuarioId: number;
}

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css'],
})
export class DeliveryComponent {
  data: any[] = [];
  nuevoDelivery: Delivery = {
    id: 0,
    nombre: '',
    comida: '',
    direccion: '',
    precio: 0,
    usuarioId: 0,
  };

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.llenarData();
  }

  llenarData() {
    this.apiService.getDataDelivery().subscribe((data) => {
      this.data = data;
      console.log(this.data);
    });
  }

  agregarDelivery() {
    this.apiService.guardarDelivery(this.nuevoDelivery).subscribe(
      (deliveryAgregado) => {
        console.log('Delivery agregado:', deliveryAgregado);
        this.llenarData();
        this.nuevoDelivery = {
          id: 0,
          nombre: '',
          comida: '',
          direccion: '',
          precio: 0,
          usuarioId: 0,
        }; // Limpiar los valores del formulario
      },
      (error) => {
        console.error('Error al agregar delivery:', error);
      }
    );
  }

  eliminarDelivery(id: number) {
    this.apiService.eliminarDelivery(id).subscribe(
      () => {
        console.log(`Delivery con ID ${id} eliminado correctamente.`);
        this.llenarData();
      },
      (error) => {
        console.error('Error al eliminar el Delivery:', error);
      }
    );
  }

  borrarDelivery(id: number) {
    this.apiService.eliminarDelivery(id).subscribe(
      () => {
        console.log('Delivery eliminado');
        this.llenarData();
      },
      (error) => {
        console.error('Error al eliminar el Delivery:', error);
      }
    );
  }
}
