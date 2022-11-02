package ar.edu.unlp.objetos.uno.ejercicio2;

import java.util.*;

public class BalanzaMejorada {
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public void agregarProducto (Producto unProducto) {
		productos.add(unProducto);
	}
	
	public void ponerEnCero() {
		productos.clear();
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public TicketMejorado emitirTicket() {
		TicketMejorado unTicket = new TicketMejorado(productos);
		return unTicket;
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
}
