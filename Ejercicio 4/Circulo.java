package ar.edu.unlp.info.oo1.ejercicio4;
public class Circulo implements Figura2D {
	private double radio;
	
	public double getDiametro() {
		return radio*2;
	}

	public void setDiametro(double diametro) {
		radio=diametro/2;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getArea() {
		return radio*radio*Math.PI;
	}
	
	public double getPerimetro() {
		return radio*2*Math.PI;
	}
}
