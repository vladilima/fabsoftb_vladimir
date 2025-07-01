import { Component, ElementRef, ViewChild } from '@angular/core';
import { Despesa } from '../model/despesa';
import { GrupoFamiliar } from '../model/grupo-familiar';
import { ActivatedRoute, Router } from '@angular/router';
import { GrupoFamiliarService } from '../service/grupo-familiar.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../model/usuario';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-despesa',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './despesa.component.html',
  styleUrl: './despesa.component.css',
  providers: [GrupoFamiliarService, Router]
})
export class DespesaComponent {
  grupoFamiliar: GrupoFamiliar;
  despesa: Despesa | undefined;
  parteAPagar: number = 0;

  usuarioSelecionado: Usuario | undefined;

  constructor(
    private grupoFamiliarService: GrupoFamiliarService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {

    const id = this.activeRouter.snapshot.paramMap.get('grupoId');

    if (id) {
      this.grupoFamiliarService.getGrupoFamiliarById(id).subscribe(grupoFamiliar => {
        this.grupoFamiliar = grupoFamiliar;
        this.despesa = this.grupoFamiliar.despesas.find(d => d.id === parseInt(this.activeRouter.snapshot.paramMap.get('despesaId') || '0')) || undefined;
      });
    }
  }

  getTime(date: any) {
    if (!date) return 0;
    let d = date instanceof Date ? date : new Date(date);
    d.setHours(d.getHours() + 12);
    return d.toLocaleDateString();
  }

  voltar() {
    this.router.navigate(['grupo-familiar', this.grupoFamiliar.id]);
  }


  


  comparaUsuarios(obj1: Usuario, obj2: Usuario): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }
  
  @ViewChild('userModal') userModalElement!: ElementRef;
  private userModal!: bootstrap.Modal;

  selecionarUsuario() {
    this.userModal = new bootstrap.Modal(this.userModalElement.nativeElement);
    this.userModal.show();
  }

  fecharSelecao() {
    this.userModal.hide();
  }

  confirmarSelecao() {
    if (!this.usuarioSelecionado) {
      console.error('Nenhum usuário selecionado');
      return;
    }

    this.despesa?.usuariosResponsaveis.push(this.usuarioSelecionado);
    this.usuarioSelecionado = undefined; // Limpa a seleção após adicionar

    if (this.despesa && this.despesa.usuariosResponsaveis) {
      this.parteAPagar = this.despesa.valor / this.despesa.usuariosResponsaveis.length || 0;
    } else {
      this.parteAPagar = 0;
    }

    this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar)
      .subscribe(resultado => {
        //this.atualizarListaUsuarios();
        this.userModal.hide();
      });
  }

  removerUsuario(usuario: Usuario) {
    const index = this.despesa?.usuariosResponsaveis.indexOf(usuario);
    if (index !== undefined && index > -1) {
      this.despesa?.usuariosResponsaveis.splice(index, 1);
      this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar).subscribe(() => {
        //this.atualizarListaUsuarios();
        console.log('Usuário removido com sucesso');
      });
    }
  }

}
