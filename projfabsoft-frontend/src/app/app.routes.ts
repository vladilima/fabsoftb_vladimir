import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { GrupoFamiliarComponent } from './grupo-familiar/grupo-familiar.component';
import { HomeComponent } from './home/home.component';
import { FormGrupoFamiliarComponent } from './form-grupo-familiar/form-grupo-familiar.component';
import { DespesaComponent } from './despesa/despesa.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'grupo-familiar/novo', component: FormGrupoFamiliarComponent },
    { path: 'grupo-familiar/:id', component: GrupoFamiliarComponent },
    { path: 'grupo-familiar/:grupoId/despesa/:despesaId', component: DespesaComponent },
    { path: 'usuarios', component: UsuarioComponent },
    { path: 'usuarios/novo', component: FormUsuarioComponent },
    { path: 'usuarios/alterar/:id', component: FormUsuarioComponent },
];
