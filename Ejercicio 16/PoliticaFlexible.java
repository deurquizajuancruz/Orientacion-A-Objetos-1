package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.LocalDate;

public class PoliticaFlexible implements Politica{
	
	public double calcularReembolso(double monto, LocalDate fechaCancelacion, LocalDate fechaInicio) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			return monto;
		}
		return 0;
	}
}
