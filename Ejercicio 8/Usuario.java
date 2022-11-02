package ar.edu.unlp.objetos.uno.ejercicio8;

import java.util.*;
import java.time.*;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumicion;
	
	public Usuario (String unNombre, String unDomicilio ) {
		this.nombre=unNombre;
		this.domicilio=unDomicilio;
		this.facturas=new ArrayList <Factura>();
		this.consumicion=new ArrayList<Consumo>();
	}	
	
	public void agregarMedicion(Consumo medicion) {
		this.consumicion.add(medicion);
	}
	
	public double ultimoConsumoActiva() {
		return this.consumicion.stream()
				.sorted((consumo1,consumo2)->consumo2.getFecha().compareTo(consumo1.getFecha()))
				.findFirst().get().getConsumoEnergiaActiva(); //devuelve el consumo de energia activa del ultimo consumo
	}
	
	public Optional<Consumo> ultimoConsumoOpcional() {
		return this.consumicion.stream()
				.max((Consumo c1, Consumo c2)->c1.getFecha().compareTo(c2.getFecha())); // devuelve el ultimo consumo como un opcional
	}
	
	public Consumo ultimoConsumo() {
		return this.ultimoConsumoOpcional().orElse(null);// devuelve el ultimo consumo si es que hay, sino devuelve null
	}
	
	/*
	Para emitir la factura de un cliente se tiene en cuenta su último consumo y se calcula su factor de potencia para determinar si hay alguna bonificación para aplicar. 
	El costo del consumo se calcula multiplicando el consumo de energía activa por el precio del kwh (Kilowatt/hora) de la empresa.
	La energía reactiva no tiene costo para el usuario. 
	Si el factor de potencia estimado (pfe) del último consumo del usuario es mayor a 0.8, el usuario es bonificado con el 10%.
	*/
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimo=this.ultimoConsumo();
		if (ultimo==null) {
			return new Factura(0,0,this);
		} //si el usuario no tiene un ultimo consumo, entonces devuelve una factura vacia
		else { // si el usuario si tiene un ultimo consumo: 
			if (ultimo.factorDePotencia()>0.8) { 
				return new Factura(ultimo.costoEnBaseA(precioKWh),10,this); //si el FDP > 0,8 entonces devuelvo una factura con 10 de descuento
			}
			return new Factura(ultimo.costoEnBaseA(precioKWh),0,this); //sino, devuelvo una factura sin descuento
		}
	}
	
	public List<Factura> getFacturas() {
		return this.facturas;
	}
}
