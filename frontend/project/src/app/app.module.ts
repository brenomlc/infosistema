import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { VeiculoListComponent } from './veiculo-list/veiculo-list.component';
import { VeiculoFormComponent } from './veiculo-form/veiculo-form.component';
import { VeiculoService } from './service/veiculo-service.service';
import { VeiculoEditComponent } from './veiculo-edit/veiculo-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    VeiculoListComponent,
    VeiculoFormComponent,
    VeiculoEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	HttpClientModule,
	FormsModule
  ],
  providers: [VeiculoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
