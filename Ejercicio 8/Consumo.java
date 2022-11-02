package ar.edu.unlp.objetos.uno.ejercicio8;

import java.time.*;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate unaF, double CA, double CR) {
		this.fecha=unaF;
		this.consumoEnergiaActiva=CA;
		this.consumoEnergiaReactiva=CR;
	}
	
	public double costoEnBaseA(double precioKWh) { //El costo del consumo se calcula multiplicando el consumo de energía activa por el precio del kwh (Kilowatt/hora) de la empresa.
		return this.consumoEnergiaActiva*precioKWh; 
	}
	
	public double factorDePotencia() {
		return (this.consumoEnergiaActiva/(Math.sqrt((this.consumoEnergiaActiva*this.consumoEnergiaActiva)+(this.consumoEnergiaReactiva*this.consumoEnergiaReactiva))));
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
}
