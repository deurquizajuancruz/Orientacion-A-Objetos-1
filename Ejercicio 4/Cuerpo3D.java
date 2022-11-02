package ar.edu.unlp.info.oo1.ejercicio4;
public class Cuerpo3D {
	private Figura2D caraBasal;
	private double altura;
	
	public void setCaraBasal(Figura2D unaFigura) {
		caraBasal=unaFigura;
	}
	
	public void setAltura(double unaAltura) {
		altura=unaAltura;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public double getVolumen() {
		return caraBasal.getArea()*altura;
	}
	
	public double getSuperficieExterior() {
		return (2*caraBasal.getArea()) + caraBasal.getPerimetro()*altura;
	}
}
