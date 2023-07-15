import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
interface Review {
  reviewId: string;
  titulo: string;
  resena: string;
  puntuacion: number;
}

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
})
export class ReviewComponent implements OnInit {
  data: any[] = [];
  nuevoReview: Review = {
    reviewId: '',
    titulo: '',
    resena: '',
    puntuacion: 0,
  }; // Agregar la propiedad reviewForm

  constructor(private reviewService: ApiService) {}

  ngOnInit(): void {
    this.llenarData();
  }

  llenarData(): void {
    this.reviewService.getReviews().subscribe((data) => {
      this.data = data;
      console.log(this.data);
    });
  }

  agregarReview() {
    this.reviewService.guardarReview(this.nuevoReview).subscribe(
      (reviewAgregado: any) => {
        console.log('Review agregado:', reviewAgregado);
        this.llenarData();
        this.nuevoReview = {
          reviewId: '',
          titulo: '',
          resena: '',
          puntuacion: 0,
        }; // Limpiar los valores del formulario
      },
      (error: any) => {
        console.error('Error al agregar review:', error);
      }
    );
  }
  deleteReview(reviewId: any) {
    this.reviewService.deleteReview(reviewId).subscribe(
      () => {
        console.log(`Review con ID ${reviewId} eliminada correctamente.`);
        this.llenarData();
      },
      (error: any) => {
        console.error('Error al eliminar la revisión:', error);
      }
    );
  }
}
