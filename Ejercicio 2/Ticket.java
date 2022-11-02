package ar.edu.unlp.objetos.uno.ejercicio2;
import java.time.LocalDate;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket (int cantProductos, double peso, double precio) {
		fecha=LocalDate.now();
		cantidadDeProductos=cantProductos;
		pesoTotal=peso;
		precioTotal=precio;
	}
	
	public double impuesto() {
		return ((precioTotal/100)*21);
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
}
