package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;

public class PersonaJuridica extends Persona {
	private long CUIT;
	private String tipo;
	
	public PersonaJuridica(String nombre, String direccion, long num, long c, String t) {
		super(nombre,direccion,num);
		this.CUIT=c;
		this.tipo=t;
	}
	
	public double facturar(LocalDateTime i, LocalDateTime f) {
		return super.facturar(i, f);
	}
}
