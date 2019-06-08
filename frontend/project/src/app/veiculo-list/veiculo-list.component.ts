import { Component, OnInit } from '@angular/core';
import { Veiculo } from '../model/veiculo';
import { VeiculoService } from '../service/veiculo-service.service';
import { ActivatedRoute, Router } from '@angular/router';
 
@Component({
  selector: 'app-veiculo-list',
  templateUrl: './veiculo-list.component.html',
  styleUrls: ['./veiculo-list.component.css']
})
export class VeiculoListComponent implements OnInit {
 
  veiculos: Veiculo[];
 
  constructor(private veiculoService: VeiculoService, private router: Router) {
  }
 
  ngOnInit() {
    this.veiculoService.findAll().subscribe(data => {
      this.veiculos = data;
    });
  }

  removerVeiculo(veiculo: Veiculo) {
    this.veiculoService.remove(veiculo).subscribe(result => this.ngOnInit());
  }

  editarVeiculo(veiculo: Veiculo){
    const editarUrl = `/editar/${veiculo.id}`;

    this.router.navigate([editarUrl]);
  }
}