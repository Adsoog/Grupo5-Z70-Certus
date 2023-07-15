import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';

interface Moto {
  id: number;
  marca: string;
  modelo: string;
  usuarioId: number;
}

@Component({
  selector: 'app-plato',
  templateUrl: './plato.component.html',
  styleUrls: ['./plato.component.css'],
})
export class PlatoComponent {
  data: any[] = [];
  nuevaMoto: Moto = { id: 0, marca: '', modelo: '', usuarioId: 0 };

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.llenarData();
  }

  llenarData() {
    this.apiService.getDataMoto().subscribe((data) => {
      this.data = data;
      console.log(this.data);
    });
  }

  agregarMoto() {
    this.apiService.guardarMoto(this.nuevaMoto).subscribe(
      (motoAgregada) => {
        console.log('Moto agregada:', motoAgregada);
        this.llenarData();
        this.nuevaMoto = { id: 0, marca: '', modelo: '', usuarioId: 0 }; // Limpiar los valores del formulario
      },
      (error) => {
        console.error('Error al agregar la moto:', error);
      }
    );
  }

  eliminarMoto(id: number) {
    this.apiService.eliminarMoto(id).subscribe(
      () => {
        console.log('Moto eliminada:', id);
        this.llenarData();
      },
      (error) => {
        console.error('Error al eliminar la moto:', error);
      }
    );
  }
}
