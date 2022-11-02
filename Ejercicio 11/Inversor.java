package ar.edu.unlp.objetos.uno.ejercicio11;

import java.util.*;

public class Inversor {
	private String nombre;
	private List<Inversion> inversiones;
	
	public Inversor(String n) {
		this.nombre=n;
		this.inversiones=new ArrayList<Inversion>();
	}
	
	public void agregarInversion(Inversion i) {
		this.inversiones.add(i);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double valorActual() {
		return this.inversiones.stream().mapToDouble(Inversion-> Inversion.valorActual()).sum();
	}
	
	public double cantidad() {
		return this.inversiones.stream().count();
	}
}
