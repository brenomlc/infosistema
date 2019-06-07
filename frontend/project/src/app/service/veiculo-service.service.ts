import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Veiculo } from '../model/veiculo';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class VeiculoService {

  private veiculoUrl: string;
 
  constructor(private http: HttpClient) {
    this.veiculoUrl = 'http://localhost:8080/veiculo';
  }
 
  public findAll(): Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.veiculoUrl);
  }
 
  public save(veiculo: Veiculo) {
    return this.http.post<Veiculo>(this.veiculoUrl, veiculo);
  }

  public remove(id : string){
    return this.http.delete(this.veiculoUrl,id);
  }
}
