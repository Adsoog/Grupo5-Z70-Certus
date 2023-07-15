import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private urlApiMoto = 'http://localhost:8022/carro';
  private urlApiUser = 'http://localhost:8001/usuario';
  private urlApiDelivery = 'http://localhost:8004/delivery';
  private urlApiReview = 'http://localhost:8021/resenas';

  constructor(private http: HttpClient) {}

  public getDataMoto(): Observable<any> {
    return this.http.get<any>(this.urlApiMoto);
  }
  public guardarMoto(moto: any): Observable<any> {
    return this.http.post<any>(this.urlApiMoto, moto);
  }
  public getDataUser(): Observable<any> {
    return this.http.get<any>(this.urlApiUser);
  }
  public eliminarMoto(id: number): Observable<any> {
    const url = `${this.urlApiMoto}/${id}`;
    return this.http.delete<any>(url);
  }

  // Metodos de delivery
  public getDataDelivery(): Observable<any> {
    return this.http.get<any>(this.urlApiDelivery);
  }
  public guardarDelivery(delivery: any): Observable<any> {
    return this.http.post<any>(this.urlApiDelivery, delivery);
  }
  public eliminarDelivery(id: number): Observable<any> {
    const url = `${this.urlApiDelivery}/${id}`;
    return this.http.delete(url);
  }

  // Metodos de Review
  public getReviews(): Observable<any[]> {
    return this.http.get<any[]>(this.urlApiReview);
  }
  public guardarReview(review: any): Observable<any> {
    return this.http.post<any>(this.urlApiReview, review);
  }
  public deleteReview(reviewId: any): Observable<any> {
    const url = `${this.urlApiReview}/${reviewId}`;
    return this.http.delete(url).pipe(
      catchError((error: any) => {
        console.error('Error al eliminar el review:', error);
        throw error; // Relanzar el error para que sea manejado en el componente
      })
    );
  }
}
