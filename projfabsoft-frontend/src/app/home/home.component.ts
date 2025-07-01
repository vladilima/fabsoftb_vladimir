import { Component } from '@angular/core';
import { GrupoFamiliar } from '../model/grupo-familiar';
import { GrupoFamiliarService } from '../service/grupo-familiar.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-home',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  providers: [GrupoFamiliarService, Router]
})
export class HomeComponent {
  listaGrupos: GrupoFamiliar[] = [];

  
  constructor(
    private grupoFamiliarService: GrupoFamiliarService,
    private router: Router
  ) { }

  ngOnInit() {
    console.log("Carregando Grupos Familiares...");
    this.grupoFamiliarService.getGruposFamiliares().subscribe(
      grupos => {
        this.listaGrupos = grupos
      }
    );
  }
  
  novo() {
    this.router.navigate(['grupo-familiar/novo']);
  }
  
  acessar(grupoFamiliar: GrupoFamiliar) {
    this.router.navigate(['grupo-familiar', grupoFamiliar.id]);
  }

}
