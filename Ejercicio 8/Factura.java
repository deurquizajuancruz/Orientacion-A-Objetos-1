package ar.edu.unlp.objetos.uno.ejercicio8;

import java.time.*;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario miUsuario;
	
	public Factura(double montoE, double elDescuento, Usuario unUsuario) {
		this.montoEnergiaActiva=montoE;
		this.descuento=elDescuento;
		this.miUsuario=unUsuario;
		this.fecha=LocalDate.now();
	}
	
	public double montoTotal() { //devuelve el monto total que tiene q pagar el usuario x la factura(aplicando el descuento si es que hay)
		return this.montoEnergiaActiva -(this.montoEnergiaActiva/100)*this.descuento;
	}
	
	public Usuario getUsuario() {
		return this.miUsuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getDescuento() {
		return this.descuento;
	}
	
	public double getMontoEnergiaActiva() {
		return this.montoEnergiaActiva;
	}
}
