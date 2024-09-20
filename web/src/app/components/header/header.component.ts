import { Component } from '@angular/core';
import { NgOptimizedImage } from '@angular/common';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  keyframes,
} from '@angular/animations';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgOptimizedImage],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
  animations: [
    trigger('changeArrow', [
      state(
        'page1',
        style({
          right: '6rem',
          transform: 'rotate(360deg)',
        })
      ),
      state(
        'page2',
        style({
          left: '6rem',
          transform: 'rotate(-180deg)',
        })
      ),
      transition('page1 => page2', [animate('2s ease-in-out')]),
      transition('page2 => page1', [animate('2s ease-in-out')]),
    ]),
  ],
})
export class HeaderComponent {
  arrow = 'assets/images/arrow.png';

  isPage1 = true;

  toggleArrow() {
    this.isPage1 = !this.isPage1;
  }
}
