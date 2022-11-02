package ar.edu.unlp.objetos.uno.ejercicio12;

public abstract class Pieza {
	private String material;
	private String color;
	
	public Pieza(String m,String c) {
		this.material=m;
		this.color=c;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public abstract double getSuperficie();
	
	public abstract double getVolumen();
}
