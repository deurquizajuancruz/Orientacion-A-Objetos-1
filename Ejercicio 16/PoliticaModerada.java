package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.LocalDate;

public class PoliticaModerada implements Politica{
	
	public double calcularReembolso(double monto, LocalDate fechaCancelacion, LocalDate fechaInicio) {
		if (fechaCancelacion.isBefore(fechaInicio)) {
			DateLapse diferencia = new DateLapse(fechaCancelacion, fechaInicio);
			double diferenciaDias = diferencia.sizeInDays();
			if (diferenciaDias>2) {
				return monto;
			}
			else {
				return monto/2;
			}
		}
		else
			return 0;
	}
}
