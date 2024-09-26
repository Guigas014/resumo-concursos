import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

import { HeaderComponent } from '../../components/header/header.component';
import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  animations: [
    trigger('changeConcursos', [
      state(
        'abertos',
        style({
          // display: 'flex',
          // width: '45%',
          // height: '100%',
          // contentVisibility: 'visible',
          translate: '0%',
        })
      ),
      state(
        'analisados',
        style({
          // display: 'none',
          // width: '0%',
          // height: '0%',
          // contentVisibility: 'hidden',
          translate: '-122%',
        })
      ),
      transition('abertos <=> analisados', [animate('2s ease-in-out')]),
      // transition('analisados => abertos', [animate('2s ease-in-out')]),
    ]),
  ],
})
export class HomeComponent {
  page1 = true;
  imageSelo = 'assets/images/selo.png';

  movePage(status: boolean) {
    this.page1 = status;
  }
}
