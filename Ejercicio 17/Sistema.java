package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;
import java.util.*;

public class Sistema {
	private List<Long> numeros;
	private List<Persona> clientes;
	
	public Sistema() {
		this.numeros = new ArrayList<Long>();
		this.clientes = new ArrayList<Persona>();
	}
	
	public double getSizeNumeros() {
		return this.numeros.size();
	}
	
	public double getSizeClientes() {
		return this.clientes.size();
	}
	
	public void agregarNumero(long numero) {
		this.numeros.add(numero);
	}
	
	public void agregarCliente(Persona p) {
		this.clientes.add(p);
	}
	
	public Factura facturarCliente(Persona cliente, LocalDateTime inicio, LocalDateTime fin) {
		return new Factura(cliente,inicio,fin,LocalDateTime.now(),cliente.facturar(inicio, fin));
	}
	
	public PersonaFisica darDeAltaPersonaFisica(String nombre, String direccion, int DNI) {
		if (! this.numeros.isEmpty()) {
			PersonaFisica p = new PersonaFisica(nombre,direccion,this.numeros.remove(0),DNI);
			agregarCliente(p);
			return p;
		}
		else return null;
	}
	
	public PersonaJuridica darDeAltaPersonaJuridica(String nombre, String direccion, int CUIT, String tipo) {
		if (! this.numeros.isEmpty()) {
			PersonaJuridica p = new PersonaJuridica(nombre,direccion,this.numeros.remove(0),CUIT,tipo);
			agregarCliente(p);
			return p;
		}
		else return null;
	}
}
