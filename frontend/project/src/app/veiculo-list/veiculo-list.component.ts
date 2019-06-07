import { Component, OnInit } from '@angular/core';
import { Veiculo } from '../model/veiculo';
import { VeiculoService } from '../service/veiculo-service.service';
 
@Component({
  selector: 'app-veiculo-list',
  templateUrl: './veiculo-list.component.html',
  styleUrls: ['./veiculo-list.component.css']
})
export class VeiculoListComponent implements OnInit {
 
  veiculos: Veiculo[];
 
  constructor(private veiculoService: VeiculoService) {
  }
 
  ngOnInit() {
    this.veiculoService.findAll().subscribe(data => {
      this.veiculos = data;
    });
  }
}