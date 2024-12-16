// src/app/features/resumen/resumen.component.ts

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../../core/services/cliente.service';
import { Cliente } from '../../core/model/cliente.model';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { DOCUMENT_TYPES } from '../../core/constants/tipos-documentos.constant';

@Component({
  selector: 'app-resumen',
  standalone: true,
  imports: [CommonModule, HeaderComponent],
  templateUrl: './resumen.component.html',
  styleUrls: ['./resumen.component.css']
})
export class ResumenComponent implements OnInit {
  cliente: Cliente | null = null;

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const tipoDocumento = params['tipo'];
      const numeroDocumento = params['numero'];

      this.clienteService.obtenerCliente(tipoDocumento, numeroDocumento).subscribe(data => {
        this.cliente = data;
      });
    });
  }

  // Función para obtener el nombre completo del tipo de documento
  getTipoDocumentoName(code: string): string {
    const tipo = DOCUMENT_TYPES.find(doc => doc.code === code);
    return tipo ? tipo.name : code;
  }

  volver() {
    this.router.navigate(['/']);
  }
}
