package ar.edu.unlp.objetos.uno.ejercicio6;

import java.util.*;

public class Farola {
	private boolean estado;
	private List<Farola> vecinos;
	
	public Farola() {
		estado=false;
		vecinos= new ArrayList<Farola>();
	}
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	
	public void pairWithNeighbor(Farola otraFarola) {
		this.vecinos.add(otraFarola); // el receptor accede a su lista y agrega a la vecina
		otraFarola.getNeighbors().add(this); //la vecina accede a su lista y agrega la receptora del mensaje
	}
	/*
	* Crea la relación de vecinos entre las farolas. 
	* La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/

	public List<Farola> getNeighbors() {
		return vecinos;
	}
	/*
	* Retorna sus farolas vecinas
	*/

	public void turnOn() {
		if (!this.estado) { 
			this.estado=!this.estado;
			this.vecinos.forEach(vecino -> vecino.turnOn());
		}
	}
	/*
	* Si la farola no está encendida (está apagada), la enciende y propaga la acción.
	*/
	
	public void turnOff() {
		if (this.estado) {
			this.estado=!this.estado;
			this.vecinos.forEach(vecino -> vecino.turnOff());
		}
	}
	/*
	* Si la farola no está apagada(está encendida), la apaga y propaga la acción.
	*/
	
	public boolean isOn() {
		return this.estado;
	}
	/*
	* Retorna true si la farola está encendida.
	*/
}
