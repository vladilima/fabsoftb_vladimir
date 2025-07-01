import { Usuario } from "./usuario";

export class Despesa {
    id: number;
    descricao: string;
    valor: number;
    dataVencimento: Date;
    usuariosResponsaveis: Usuario[];
}
