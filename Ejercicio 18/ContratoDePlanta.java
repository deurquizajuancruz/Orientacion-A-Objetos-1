package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato {
	private Empleado empleado;
	private double sueldoMensual;
	private double montoConyuge;
	private double montoHijos;
	
	public ContratoDePlanta(LocalDate i, Empleado e,double sueldoM, double hijos, double conyuge) {
		super(i);
		this.empleado=e;
		this.sueldoMensual=sueldoM;
		this.montoHijos=hijos;
		this.montoConyuge=conyuge;
	}
	
	public int getDuracionAños() {
		if (this.getFechaInicio().isBefore(LocalDate.now())) { // si el contrato ya empezó
			return (int) ChronoUnit.YEARS.between(getFechaInicio(), LocalDate.now());
		}
		return 0; // si el contrato todavia no empezo, no hay que sumar la antiguedad = devuelve 0
	}
	
	public boolean tieneHijos() {
		return this.empleado.getHijos();
	}
	
	public boolean tieneConyuge() {
		return this.empleado.getConyuge();
	}
	
	public double calcularMonto() {
		if ((this.tieneConyuge()) && (this.tieneHijos())) { // si tiene conyuge e hijos = sueldo + hijos + conyuge
			return this.sueldoMensual + this.montoConyuge + this.montoHijos; 
		}
		else if (this.tieneConyuge()) { // si tiene solo conyuge = sueldo + conyuge
			return this.sueldoMensual + this.montoConyuge;
		}
		else if (this.tieneHijos()) { // si tiene solo hijos = sueldo + hijos
			return this.sueldoMensual + this.montoHijos; 
		}
		return this.sueldoMensual; // si no tiene ni hijos ni conyuge = sueldo
	} //calcular el monto del contrato para recibo
	
	public boolean vencido() {
		return false;
	}
}
