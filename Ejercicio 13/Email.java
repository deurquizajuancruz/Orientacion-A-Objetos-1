package ar.edu.unlp.objetos.uno.ejercicio13;

import java.util.*;

public class Email {
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String t, String c) {
		this.titulo=t;
		this.cuerpo=c;
		this.adjuntos=new ArrayList<Archivo>();
	}
	
	public void agregarArchivo(Archivo a) {
		this.adjuntos.add(a);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return this.adjuntos;
	}
	
	public int tamaño() {
		return this.titulo.length() + this.cuerpo.length() + this.adjuntos.stream().mapToInt(a ->a.tamaño()).sum();
	}
	
	public boolean buscar(String txt) {
		return this.titulo.contains(txt)|| this.cuerpo.contains(txt);
	}
}
