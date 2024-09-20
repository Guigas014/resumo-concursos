import { Component, ViewChild } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { HeaderComponent } from './components/header/header.component';
import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  animations: [
    trigger('changeConcursos', [
      state(
        'abertos',
        style({
          display: 'flex',
        })
      ),
      state(
        'analisados',
        style({
          display: 'none',
        })
      ),
      transition('abertos <=> analisados', [animate('3s ease-in-out')]),
      // transition('analisados => abertos', [animate('2s ease-in-out')]),
    ]),
  ],
})
export class AppComponent {
  title = 'web';
  page1 = true;

  teste(status: boolean) {
    this.page1 = status;
  }
}
