package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{
	
	public LlamadaLocal(LocalDateTime f, double d, long r, long l) {
		super(f,d,r,l);
	}
	
	public double calcularMonto(double m) {
		return m; // duracion en minutos * $1
	}
}
