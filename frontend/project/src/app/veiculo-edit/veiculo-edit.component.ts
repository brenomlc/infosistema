import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Veiculo } from '../model/veiculo';
import { VeiculoService } from '../service/veiculo-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-veiculo-edit',
  templateUrl: './veiculo-edit.component.html',
  styleUrls: ['./veiculo-edit.component.css']
})

export class VeiculoEditComponent implements OnInit {

  angForm: FormGroup;
  veiculo: Veiculo;

  constructor(private route: ActivatedRoute, private router: Router, private veiculoService: VeiculoService, private fb: FormBuilder) {
    
 }

  createForm() {
    
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
        this.veiculoService.find(params['id']).subscribe(res => {
          this.veiculo = res;
      });
    });
  }

  onSubmit() {
    this.veiculoService.update(this.veiculo).subscribe(result => this.gotoVeiculoList());
  }
 
  gotoVeiculoList() {
    this.router.navigate(['/buscar']);
  }
}