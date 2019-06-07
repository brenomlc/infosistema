import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VeiculoService } from '../service/veiculo-service.service';
import { Veiculo } from '../model/veiculo';
 
@Component({
  selector: 'app-veiculo-form',
  templateUrl: './veiculo-form.component.html',
  styleUrls: ['./veiculo-form.component.css']
})
export class VeiculoFormComponent {
 
  veiculo: Veiculo;
 
  constructor(private route: ActivatedRoute, private router: Router, private veiculoService: VeiculoService) {
    this.veiculo = new Veiculo();
  }
 
  onSubmit() {
    this.veiculoService.save(this.veiculo).subscribe(result => this.gotoVeiculoList());
  }
 
  gotoVeiculoList() {
    this.router.navigate(['/buscar']);
  }
}