package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato{
	private double valorHora;
	private double horasMes;
	private LocalDate fin;
	
	public ContratoPorHoras(LocalDate i,double vH,double hM,LocalDate f) {
		super(i);
		this.valorHora=vH;
		this.horasMes=hM;
		this.fin=f;
	}
	
	public int getDuracionAños() {
		if (this.fin.isBefore(LocalDate.now())) { // si el contrato ya se venció
			return (int)ChronoUnit.YEARS.between(getFechaInicio(), this.fin);
		}
		if (this.getFechaInicio().isBefore(LocalDate.now()) && this.fin.isAfter(LocalDate.now())) { // si el contrato ya empezó y no termino
			return (int)ChronoUnit.YEARS.between(getFechaInicio(), LocalDate.now());
		}
		
		return 0; // si el contrato todavia no empezo, no hay que sumar la antiguedad = devuelve 0
	}
	
	public double calcularMonto() {
		return this.valorHora * this.horasMes;
	} //calcular el monto del contrato por horas para el recibo
	
	public boolean vencido() {
		return this.fin.isBefore(LocalDate.now()) || this.fin.isEqual(LocalDate.now());
	}//fijarse si el contrato esta vencido
	
}
