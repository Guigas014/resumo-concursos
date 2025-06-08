export interface Concurso {
  id?: number;
  nome: string;
  ano: string;
  banca?: string;
  inicioInscricao?: Date;
  fimInscricao?: string;
  link?: string;
  dataEncoded?: string;
}
