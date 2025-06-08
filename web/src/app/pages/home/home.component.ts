import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { HttpParams } from '@angular/common/http';

import { HeaderComponent } from '../../components/header/header.component';
import {
  animate,
  state,
  style,
  transition,
  trigger,
} from '@angular/animations';

import { Concurso } from '../../types/concurso';
import { feed } from '../../../utils/feed';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, RouterLink, RouterLinkActive],
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

  httpParams = new HttpParams();

  // O feed é importado de utils/feed.ts e é criado uma propriedade com todos os dados serializados (dataEncoded).
  concursos: Concurso[] = feed.map((item) => {
    return {
      nome: item.nome,
      ano: item.ano,
      fimInscricao: item.fimInscricao,
      link: item.link,
      dataEncoded: encodeURIComponent(JSON.stringify(item)),
    };
  });

  concurso: Concurso = {
    nome: 'FUB',
    ano: '2016',
    inicioInscricao: new Date('2016-10-03'),
    link: 'https://www.pciconcursos.com.br/noticias/fub-df-promove-concurso-publico-com-273-vagas',
  };

  // O objeto concurso é serializado para ser enviado como string na URL
  dataEncoded = encodeURIComponent(JSON.stringify(this.concurso));

  data = [
    {
      id: 1,
      url: 'https://www.pciconcursos.com.br/noticias/fub-df-promove-concurso-publico-com-273-vagas',
    },
  ];

  movePage(status: boolean) {
    this.page1 = status;
  }

  // showEmptyMessage() {
  //   if (this.data === null) {
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }
}
