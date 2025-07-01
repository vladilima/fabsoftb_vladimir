import { Despesa } from "./despesa";
import { Usuario } from "./usuario";

export class GrupoFamiliar {
    id: number;
    nome: string;
    usuarios: Usuario[];
    despesas: Despesa[];
}
