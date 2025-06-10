import { Concurso } from './concurso';

export interface Cargo {
  id?: number;
  nome: string;
  nivel: string;
  cadastroReserva?: boolean;
  quantidadeVagas?: number;
  taxaInscricao: number;
  salario: number;
  concursoId: Concurso;
}
