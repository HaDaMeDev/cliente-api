// src/app/shared/utils/format.util.ts
export function formatNumeroDocWithSeparadorMillones(valor: string): string {
    // Elimina todo excepto los dígitos
  const numeroLimpio = valor.replace(/[^\d]/g, '');
  
  // Aplica el formato con puntos como separadores de miles
  return numeroLimpio.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
  }
  