import { Component } from '@angular/core';
import { GrupoFamiliar } from '../model/grupo-familiar';
import { Router, ActivatedRoute } from '@angular/router';
import { GrupoFamiliarService } from '../service/grupo-familiar.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-grupo-familiar',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-grupo-familiar.component.html',
  styleUrl: './form-grupo-familiar.component.css',
  providers: [GrupoFamiliarService, Router]
})
export class FormGrupoFamiliarComponent {
  grupoFamiliar: GrupoFamiliar = new GrupoFamiliar();

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

  salvar() {
    this.grupoFamiliarService.saveGrupoFamiliar(this.grupoFamiliar)
      .subscribe(resultado => {
        this.router.navigate(['']);
      });
  }

}
