import { Routes } from '@angular/router';
import { IngresoComponent } from './features/ingreso/ingreso.component';
import { ResumenComponent } from './features/resumen/resumen.component';

export const appRoutes: Routes = [
  { path: '', component: IngresoComponent },
  { path: 'resumen', component: ResumenComponent },
  { path: '**', redirectTo: '' }
];