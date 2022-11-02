package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;

public class PersonaFisica extends Persona {
	private long dni;
	
	public PersonaFisica(String n, String d, long num, long DNI) {
		super(n,d,num);
		this.dni=DNI;
	}
	
	public double facturar(LocalDateTime i, LocalDateTime f) {
		double total = super.facturar(i, f);
		double devolver =total - (total/100)*10; 
		return devolver;
	} //recorrer todas las llamadas, fijarme cuales se realizaron en el periodo y sumar todos los montos
}
