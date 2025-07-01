import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GrupoFamiliar } from '../model/grupo-familiar';
import { Despesa } from '../model/despesa';

@Injectable({
  providedIn: 'root'
})
export class GrupoFamiliarService {
  apiURL = "http://localhost:8080/api/v1/grupos-familiares";

  constructor(private http: HttpClient) { }

  getGruposFamiliares() {
    return this.http.get<GrupoFamiliar[]>(this.apiURL);
  }

  saveGrupoFamiliar(grupoFamiliar: GrupoFamiliar) {
    if (grupoFamiliar.id) {
      return this.http.put(this.apiURL + '/' + grupoFamiliar.id, grupoFamiliar);
    }
    return this.http.post(this.apiURL, grupoFamiliar); 
  }

  saveGrupoRemoverDespesa(grupoFamiliar: GrupoFamiliar, despesa: Despesa) {
    return this.http.put(this.apiURL + '/' + grupoFamiliar.id, grupoFamiliar);
  }

  getGrupoFamiliarById(id: any) {
    return this.http.get<GrupoFamiliar>(this.apiURL + '/' + id);
  }

  excluirGrupoFamiliar(id: any){
    return this.http.delete<GrupoFamiliar>(this.apiURL + '/' + id);
  }


}