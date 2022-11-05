package ar.edu.unlp.objetos.uno.ejercicio19;

public abstract class Persona {
	private String nombre;
	private String direccion;
	
	public Persona(String n, String d) {
		this.nombre=n;
		this.direccion=d;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
