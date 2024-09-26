import { Routes } from '@angular/router';

import { CargosComponent } from './pages/cargos/cargos.component';
import { HomeComponent } from './pages/home/home.component';
import { FormularioComponent } from './pages/formulario/formulario.component';
import { AvaliacaoComponent } from './pages/avaliacao/avaliacao.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'cargos', component: CargosComponent },
  { path: 'formulario', component: FormularioComponent },
  { path: 'avaliacao', component: AvaliacaoComponent },
];
