import { Routes } from '@angular/router';

import { CargosComponent } from './pages/cargos/cargos.component';
import { HomeComponent } from './pages/home/home.component';
import { FormularioComponent } from './pages/formulario/formulario.component';
import { AvaliacaoComponent } from './pages/avaliacao/avaliacao.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, title: 'ConcurseirOS' },
  { path: 'cargos', component: CargosComponent, title: 'Cargos' },
  {
    path: 'formulario/:data',
    component: FormularioComponent,
    title: 'Formulário',
  },
  { path: 'avaliacao', component: AvaliacaoComponent, title: 'Detalhes' },
  { path: '**', component: PageNotFoundComponent }, // Redirect to page not found
];
