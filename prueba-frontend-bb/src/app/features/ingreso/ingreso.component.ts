// src/app/features/ingreso/ingreso.component.ts

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { DOCUMENT_TYPES } from '../../core/constants/tipos-documentos.constant';
import { formatNumeroDocWithSeparadorMillones } from '../../shared/utils/format.util';
import { HeaderComponent } from '../../shared/components/header/header.component';

@Component({
  selector: 'app-ingreso',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule,HeaderComponent],
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.css']
})
export class IngresoComponent {
  documentTypes = DOCUMENT_TYPES;
  tipoDocumento: string = '';
  numeroDocumento: string = '';

  // Límites de caracteres sin contar puntuaciones
  minLength = 5;
  maxLength = 11;

  constructor(private router: Router) {}

  // Formatea el número con puntuaciones
  formatNumeroDocumento() {
    this.numeroDocumento = formatNumeroDocWithSeparadorMillones(this.numeroDocumento);
  }

  // Limpia las puntuaciones para validación
  cleanNumeroDocumento(): string {
    return this.numeroDocumento.replace(/\./g, '').trim();
  }

  esFormularioValido(): boolean {
    const cleanedNumeroDocumento = this.cleanNumeroDocumento();
    return this.tipoDocumento.trim() !== '' &&
           cleanedNumeroDocumento.length >= this.minLength &&
           cleanedNumeroDocumento.length <= this.maxLength;
  }

  buscar() {
    if (this.esFormularioValido()) {
      this.router.navigate(['/resumen'], {
        queryParams: {
          tipo: this.tipoDocumento,
          numero: this.cleanNumeroDocumento()
        }
      });
    }
  }
}
