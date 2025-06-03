import { Component } from '@angular/core';

import { HeaderComponent } from '../../components/header/header.component';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [HeaderComponent],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css',
})
export class FormularioComponent {}
