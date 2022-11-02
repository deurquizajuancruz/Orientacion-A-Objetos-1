package ar.edu.unlp.objetos.uno.ejercicio12;

public class PrismaRectangular extends Pieza{
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String m, String c, int mayor, int menor, int h) {
		super(m,c);
		this.ladoMayor=mayor;
		this.ladoMenor=menor;
		this.altura=h;
	}
	
	public double getSuperficie() {
		return 2*((this.ladoMayor*this.ladoMenor)+(this.ladoMayor*this.altura)+(this.ladoMenor*this.altura));
	}
	
	public double getVolumen() {
		return this.ladoMayor*this.ladoMenor*this.altura;
	}
}
