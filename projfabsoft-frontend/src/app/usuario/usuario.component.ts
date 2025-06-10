import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { UsuarioService } from '../service/usuario.service';
import { Usuario } from '../model/usuario';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-usuario',
  imports: [HttpClientModule, CommonModule, RouterLink],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService]
})
export class UsuarioComponent {
  listaUsuarios: Usuario[] = [];

  constructor(private usuarioService : UsuarioService) {}

  ngOnInit(){
    console.log("Carregando Usuários...");
    this.usuarioService.getUsuarios().subscribe(
      usuarios => {
        this.listaUsuarios = usuarios
      }
    );
  }
}
