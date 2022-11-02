package ar.edu.unlp.objetos.uno.ejercicio7;

public class EmpleadoJerarquico extends Empleado{
	
	public EmpleadoJerarquico(String N) {
		super(N);
	}
	
	public double sueldoBasico () {
		return super.sueldoBasico() + this.bonoPorCategoria();
	}
	
	public double montoBasico () {
		return 45000;
	}
	
	public double bonoPorCategoria() {
		return 8000;
	}
	
}
