package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private LocalDate fechaInicio;
	
	public Contrato(LocalDate i) {
		this.fechaInicio=i;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
		
	public abstract int getDuracionAños();
	
	public abstract double calcularMonto();
	
	public abstract boolean vencido();
}
