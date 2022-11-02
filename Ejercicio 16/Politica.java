package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.LocalDate;

public interface Politica {
	
	public double calcularReembolso(double monto, LocalDate fechaCancelacion, LocalDate fechaInicio );
}
