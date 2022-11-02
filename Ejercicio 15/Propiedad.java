package ar.edu.unlp.objetos.uno.ejercicio15;

import java.util.*;
import java.time.LocalDate;

public class Propiedad {
    private String nombre;
    private String direccion;
    private String descripcion;
    private double precioPorNoche;
    private List<Reserva> reservas;
    
    public Propiedad(String n, String dir, String des, double pxn) {
	   	 this.nombre=n;
	   	 this.direccion=dir;
	   	 this.descripcion=des;
	   	 this.precioPorNoche=pxn;
	   	 this.reservas= new ArrayList<Reserva>();
    }
    
    public double getPrecioPorNoche() {
    	return this.precioPorNoche;
    } //calcular precio de una reserva
    
    public int getSizeReservas() {
    	return this.reservas.size();
    }
    
    public void agregarReserva(Reserva r) {
    	this.reservas.add(r);
    } //hacer una reserva
    
    public Reserva hacerReserva(DateLapse periodo, Usuario inquilino) {
    	if (this.disponible(periodo)) {
    		Reserva r = new Reserva(periodo,this,inquilino);
    		this.agregarReserva(r);
    		inquilino.agregarReserva(r);
    		return r;
    	}
    	else return null;
    } //hacer una reserva
    
    public boolean disponible(DateLapse periodo) {
    	return this.reservas.stream().noneMatch(r -> r.realizadaEn(periodo));
    } // hacer una reserva
    
    public double calcularIngresos(DateLapse periodo) {
    	return this.reservas.stream().filter(r->r.realizadaEn(periodo)).mapToDouble(r->r.calcularPrecio(periodo)).sum();
    } //calcular los ingresos de un propietario
    
    public void eliminarReserva(Reserva eliminar) {
    	this.reservas.remove(eliminar);
    } // eliminar reserva
}
