package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private Empleado empleado;
	private int antiguedad;
	private LocalDate fecha;
	private double monto;
	
	public Recibo(Empleado e, int a, double m) {
		this.empleado=e;
		this.antiguedad=a;
		this.fecha=LocalDate.now();
		this.monto=m;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
}
