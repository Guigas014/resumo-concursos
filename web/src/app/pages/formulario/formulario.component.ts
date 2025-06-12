import { Component, inject, Input } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { NgxMaskDirective } from 'ngx-mask';

import { HeaderComponent } from '../../components/header/header.component';
import { Concurso } from '../../types/concurso';

import { lists } from '../../../utils/lists';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [HeaderComponent, ReactiveFormsModule, NgxMaskDirective],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  // Injeção de dependências
  private formBuilder = inject(FormBuilder);

  // Atributtes
  newData: string | null = '';
  concurso: Concurso | null = null;
  bancas: string[] = lists.bancas;
  niveis: string[] = lists.niveis;
  tipos: string[] = lists.tipos;
  carateres: string[] = lists.carateres;
  conteudos: string[] = lists.conteudos;

  // Pega o paramêtro 'data' da URL e decodifica
  @Input()
  set data(data: string) {
    if (data) {
      this.concurso = JSON.parse(decodeURIComponent(data));
      console.log('Data:', this.concurso);
    }
  }

  // Formulário reativo sem FormBuilder
  // mainForm = new FormGroup({
  //   concurso: new FormGroup({
  //     name: new FormControl(''),
  //     ano: new FormControl(''),
  //   }),
  //   cargo: new FormGroup({
  //     title: new FormControl(''),
  //     nivel: new FormControl(''),
  //   }),
  // });

  // Formulário reativo com FormBuilder
  mainForm = this.formBuilder.group({
    concurso: this.formBuilder.group({
      banca: [''],
      inicioInscricao: [''],
    }),
    cargo: this.formBuilder.group({
      nome: [''],
      nivel: [''],
      cadastroReserva: [false],
      salario: [''],
      inscricao: [''],
      vagas: [''],
    }),
    avaliacao: this.formBuilder.group({
      tipo: [''],
      carater: [''],
      data: [''],
      duracao: [''],
      questoes: [''],
      pontuacao: [''],
    }),
    conteudo: this.formBuilder.group({
      portugues: [false],
      matematica: [false],
      informatica: [false],
      raciocinioLogico: [false],
      ingles: [false],
      etica: [false],
      atualidades: [false],
      direitoAdministrativo: [false],
      direitoConstitucional: [false],
      especificas: [false],
      outros: [''],
    }),
  });

  onSubmit() {
    console.log('Formulário enviado:', this.mainForm.value);
  }
}
