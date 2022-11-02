package ar.edu.unlp.objetos.uno.ejercicio12;

public class Cilindro extends Pieza{
	private int radio;
	private int altura;
	
	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material,color);
		this.radio=radio;
		this.altura=altura;
	}
	
	public double getSuperficie() {
		double primeraparte=2*Math.PI*this.radio*this.altura;
		double segundaparte=2*Math.PI*Math.pow(this.radio, 2);
		return primeraparte+segundaparte;
		//return 2*Math.PI*this.radio*this.altura+2*Math.PI*Math.pow(this.radio, 2)
	}
	
	public double getVolumen() {
		return Math.PI*Math.pow(this.radio, 2)*this.altura;
	}
}
