package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInterurbana extends Llamada{
	private double distancia;
	
	public LlamadaInterurbana(LocalDateTime f, double d, long r, long l, double dis) {
		super(f,d,r,l);
		this.distancia=dis;
	}
	
	public void setDistancia(double dis) {
		this.distancia=dis;
	}
	
	public double calcularMonto(double m) {
		if (this.distancia<100) {
			return m *2 +5;
		}
		else if (this.distancia<500) {
			return m*2.5 +5;
		}
		else {
			return m*3 +5;
		}
	}
}
