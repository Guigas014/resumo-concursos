import { Component, Input } from '@angular/core';

import { HeaderComponent } from '../../components/header/header.component';
import { Concurso } from '../../types/concurso';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {
  newData: string | null = '';
  concurso: Concurso | null = null;

  @Input()
  set data(data: string) {
    if (data) {
      this.concurso = JSON.parse(decodeURIComponent(data));
      console.log('Data:', this.concurso?.nome);
    }
  }
}
