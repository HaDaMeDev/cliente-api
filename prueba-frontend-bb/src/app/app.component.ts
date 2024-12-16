import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // Importa RouterModule

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule], // Añade RouterModule
  template: `<router-outlet></router-outlet>`
})
export class AppComponent {}
