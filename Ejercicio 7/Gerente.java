package ar.edu.unlp.objetos.uno.ejercicio7;

public class Gerente extends EmpleadoJerarquico{
	
	public Gerente(String N) {
		super(N);
	}
	
	public double aportes() {
		return this.montoBasico() *0.05;
	}
	
	public double montoBasico() {
		return 4;
	}
	
}
