package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;

public class Factura {
	private Persona cliente;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private LocalDateTime fechaFactura;
	private double monto;
	
	public Factura(Persona c, LocalDateTime i, LocalDateTime fin, LocalDateTime f, double m) {
		this.cliente=c;
		this.inicio=i;
		this.fin=fin;
		this.fechaFactura=f;
		this.monto=m;
	}
	
	public double getMonto() {
		return this.monto;
	}
}
