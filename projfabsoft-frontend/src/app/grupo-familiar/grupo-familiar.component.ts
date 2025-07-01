import { Component, ElementRef, ViewChild } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GrupoFamiliarService } from '../service/grupo-familiar.service';
import { GrupoFamiliar } from '../model/grupo-familiar';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-grupo-familiar',
  imports: [HttpClientModule, CommonModule, FormsModule, NgIf],
  templateUrl: './grupo-familiar.component.html',
  styleUrl: './grupo-familiar.component.css',
  providers: [GrupoFamiliarService, Router]
})
export class GrupoFamiliarComponent {
  grupoFamiliar: GrupoFamiliar;
  cadastro: GrupoFamiliar = new GrupoFamiliar();

  constructor(
    private grupoFamiliarService: GrupoFamiliarService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {

    const id = this.activeRouter.snapshot.paramMap.get('id');

    if (id) {
      this.grupoFamiliarService.getGrupoFamiliarById(id).subscribe(grupoFamiliar => {
        this.grupoFamiliar = grupoFamiliar;
      });

    }
  }

  ngOnInit() {
    console.log("Carregando Grupo Familiar...");
    this.grupoFamiliarService.getGruposFamiliares().subscribe(grupoFamiliar => {
      let grupo = grupoFamiliar.pop();
      if (grupo) {
        this.grupoFamiliar = grupo;
      }
    });
  }

  salvar() {
    this.cadastro.id = 0;
    this.grupoFamiliar = this.cadastro;

    this.grupoFamiliarService.saveGrupoFamiliar(this.cadastro)
      .subscribe(resultado => {
        this.router.navigate(['grupos-familiares']);
      });
  }



  abrirConfirmacao(grupoFamiliar: GrupoFamiliar) {
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.grupoFamiliarService.excluirGrupoFamiliar(this.grupoFamiliar.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.grupoFamiliar = undefined as unknown as GrupoFamiliar;
      },
      error => {
        console.error('Erro ao excluir grupo familiar:', error);
      }
    );
  }

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;


}