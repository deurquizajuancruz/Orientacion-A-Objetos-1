package ar.edu.unlp.objetos.uno.ejercicio12;

public class Esfera extends Pieza{
	private int radio;
	
	public Esfera(String m, String c, int radio) {
		super(m,c);
		this.radio=radio;
	}
	
	public double getSuperficie() {
		return 4*Math.PI*Math.pow(this.radio,2);
	}
	
	public double getVolumen() {
		return (4*Math.PI*Math.pow(this.radio,3))/3;
	}
}
