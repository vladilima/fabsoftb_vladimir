import { Component, ElementRef, ViewChild } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { GrupoFamiliarService } from '../service/grupo-familiar.service';
import { GrupoFamiliar } from '../model/grupo-familiar';
import * as bootstrap from 'bootstrap';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { Despesa } from '../model/despesa';

@Component({
  selector: 'app-grupo-familiar',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './grupo-familiar.component.html',
  styleUrl: './grupo-familiar.component.css',
  providers: [GrupoFamiliarService, Router, UsuarioService]
})
export class GrupoFamiliarComponent {
  grupoFamiliar: GrupoFamiliar;

  public listaUsuarios: Usuario[] = [];
  usuarioSelecionado: Usuario | undefined;

  despesaRascunho: Despesa = new Despesa();

  constructor(
    private grupoFamiliarService: GrupoFamiliarService,
    private usuarioService: UsuarioService,
    private router: Router,
    private activeRouter: ActivatedRoute
  ) {

    const id = this.activeRouter.snapshot.paramMap.get('id');

    if (id) {
      this.grupoFamiliarService.getGrupoFamiliarById(id).subscribe(grupoFamiliar => {
        this.grupoFamiliar = grupoFamiliar;
      });
    }

    this.atualizarListaUsuarios();

  }


  comparaUsuarios(obj1: Usuario, obj2: Usuario): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }

  atualizarListaUsuarios() {
    this.usuarioService.getUsuarios().subscribe(usuarios => {
      usuarios = usuarios.filter(u => {
        // Filtra usuários que não estão no grupo familiar
        return !this.grupoFamiliar.usuarios.some(gu => gu.id === u.id);
      });
      this.listaUsuarios = usuarios;
    });
  }


  removerUsuario(usuario: Usuario) {
    const index = this.grupoFamiliar.usuarios.indexOf(usuario);
    if (index > -1) {
      this.grupoFamiliar.usuarios.splice(index, 1);
      this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar).subscribe(() => {
        this.atualizarListaUsuarios();
        console.log('Usuário removido com sucesso');
      });
    }
  }


  @ViewChild('deleteModal') deleteModalElement!: ElementRef;
  private delModal!: bootstrap.Modal;

  abrirConfirmacao() {
    this.delModal = new bootstrap.Modal(this.deleteModalElement.nativeElement);
    this.delModal.show();
  }

  fecharConfirmacao() {
    this.delModal.hide();
  }

  confirmarExclusao() {
    this.grupoFamiliarService.excluirGrupoFamiliar(this.grupoFamiliar.id).subscribe(
      () => {
        this.fecharConfirmacao();
        this.grupoFamiliar = undefined as unknown as GrupoFamiliar;
        this.router.navigate(['']);
      },
      error => {
        console.error('Erro ao excluir grupo familiar:', error);
      }
    );
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

    this.grupoFamiliar.usuarios.push(this.usuarioSelecionado);
    this.usuarioSelecionado = undefined; // Limpa a seleção após adicionar

    this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar)
      .subscribe(resultado => {
        this.atualizarListaUsuarios();
        this.userModal.hide();
      });
  }


  @ViewChild('despesaCriarModal') despesaCriarModalElement!: ElementRef;
  private despesaCriarModal!: bootstrap.Modal;

  abrirCriacao() {
    this.despesaCriarModal = new bootstrap.Modal(this.despesaCriarModalElement.nativeElement);
    this.despesaCriarModal.show();
  }

  cancelarCriacao() {
    this.despesaCriarModal.hide();
  }

  criarDespesa() {
    if (!(this.despesaRascunho.valor > 0)) {
      console.error('Valor da despesa inválido.');
      return;
    }

    this.grupoFamiliar.despesas.push(this.despesaRascunho);
    this.despesaRascunho = new Despesa(); // Limpa a seleção após adicionar

    this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar)
      .subscribe(resultado => {
        this.despesaCriarModal.hide();
      });
  }
  
  removerDespesa(despesa: Despesa) {
    this.grupoFamiliar.despesas = this.grupoFamiliar.despesas.filter(d => d.id !== despesa.id);
    this.grupoFamiliarService.saveGrupoRemoverDespesa(this.grupoFamiliar, despesa).subscribe(() => {
      console.log('Despesa removida com sucesso');
    });
  }


  getTime(date: any) {
    if (!date) return 0;
    let d = date instanceof Date ? date : new Date(date);
    d.setHours(d.getHours() + 12);
    return d.toLocaleDateString();
  }

}