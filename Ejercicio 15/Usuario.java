package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Usuario {
    private String nombre;
    private String direccion;
    private int dni;
    private List<Propiedad> propiedadesAlquiler;
    private List<Reserva> reservadas;
    
    public Usuario(String n, String dir, int dni) {
		 this.nombre=n;
		 this.direccion=dir;
		 this.dni=dni;
		 this.propiedadesAlquiler= new ArrayList<Propiedad>();
		 this.reservadas = new ArrayList<Reserva>();
    }
    
    public int getSizePropiedadesAlquiler() {
    	return this.propiedadesAlquiler.size();
    }
    
    public int getSizeReservadas() {
    	return this.reservadas.size();
    }
    
    public Propiedad registrarPropiedad(String nombre,String descripcion, String direccion, double precioXNoche) {
    	Propiedad p = new Propiedad(nombre, descripcion, direccion, precioXNoche);
    	this.propiedadesAlquiler.add(p);
    	return p;
    } //registrar una propiedad en alquiler
    
    public void agregarReserva(Reserva res) {
    	this.reservadas.add(res);
    } //hacer una reserva
    
    public List<Reserva> getReservadas(){
    	return this.reservadas;
    } // obtener las reservas de un usuario
    
    public double calcularIngresos(DateLapse periodo) {
    	return this.propiedadesAlquiler.stream().mapToDouble(p->p.calcularIngresos(periodo)).sum();
    } // calcular los ingresos de un propietario
    
    public void eliminarReserva(Reserva eliminar) {
    	this.reservadas.remove(eliminar);
    } // eliminar reserva
    
    public List<Propiedad> getPropiedadesDisponibles(DateLapse periodo) {
    	return this.propiedadesAlquiler.stream().filter(p->p.disponible(periodo)).collect(Collectors.toList());
    } // el usuario devuelve una lista de todas las propiedades que estan disponibles en el periodo
}
