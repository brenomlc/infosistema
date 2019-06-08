import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VeiculoListComponent } from './veiculo-list/veiculo-list.component';
import { VeiculoFormComponent } from './veiculo-form/veiculo-form.component';
import { VeiculoEditComponent } from './veiculo-edit/veiculo-edit.component';

const routes: Routes = [
	{ path: 'buscar', component: VeiculoListComponent },
	{ path: 'veiculo', component: VeiculoFormComponent },
	{ path: 'editar/:id', component: VeiculoEditComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
