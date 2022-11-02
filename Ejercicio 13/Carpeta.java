package ar.edu.unlp.objetos.uno.ejercicio13;

import java.util.*;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String n) {
		this.nombre=n;
		this.emails=new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarEmail(Email e) {
		this.emails.add(e);
	}
	
	public void eliminarEmail(Email e) {
		this.emails.remove(e);
	}
	
	public Email buscar(String txt) {
		return this.emails.stream()
				.filter(e->e.buscar(txt)).findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return this.emails.stream().mapToInt(e->e.tamaño()).sum();
	}
}
