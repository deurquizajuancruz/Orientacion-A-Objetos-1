package ar.edu.unlp.objetos.uno.ejercicio2;
import java.time.LocalDate;
import java.util.*;

public class TicketMejorado {
	private LocalDate fecha;
	private ArrayList<Producto> productos= new ArrayList<Producto>();
	
	public TicketMejorado (ArrayList<Producto> productos) {
		super();
		fecha=LocalDate.now();
		this.productos.addAll(productos);
	}
	
	public double impuesto() {
		return ((getPrecioTotal()/100)*21);
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public double getPesoTotal() {
		double peso=0;
		for (int i=0;i<productos.size();i++) {
			peso+=productos.get(i).getPeso();
		}
		return peso;
	}
	
	public double getPrecioTotal() {
		double precio=0;
		for (int i=0;i<productos.size();i++) {
			precio+=productos.get(i).getPrecio();
		}
		return precio;
	}
	
	public int getCantidadDeProductos() {
		return productos.size();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
}
