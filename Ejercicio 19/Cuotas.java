package ar.edu.unlp.objetos.uno.ejercicio19;

public class Cuotas implements OpcionesDePago{
	
	public double calcularMonto(double precio) {
		return precio + precio/100*20;
	}
	
}
