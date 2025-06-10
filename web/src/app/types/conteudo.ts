export interface Conteudo {
  id?: number;
  portugues: boolean;
  matematica: boolean;
  informatica: boolean;
  raciocinioLogico: boolean;
  ingles: boolean;
  etica: boolean;
  atualidades: boolean;
  direitoAdministrativo: boolean;
  direitoConstitucional: boolean;
  especifico: boolean;
  outros?: string;
  avaliacaoId: number;
}
