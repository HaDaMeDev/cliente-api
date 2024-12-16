// src/app/core/services/cliente.service.ts

import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cliente } from '../model/cliente.model';
import clientesData from '../../../assets/data/cliente.json';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() {}

  obtenerCliente(tipoDocumento: string, numeroDocumento: string): Observable<Cliente | null> {
    console.log('Datos cargados:', clientesData,numeroDocumento);

    const cliente = clientesData.find(
      (c: Cliente) => c.tipoDocumento === tipoDocumento && c.numeroDocumento === numeroDocumento
    );

    console.log('Cliente encontrado:', cliente);
    return of(cliente || null);
  }
}
