package ar.edu.unlp.objetos.uno.ejercicio2;

public class Balanza {
	private int cantidadProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void ponerEnCero() {
		cantidadProductos =0;
		precioTotal=0;
		pesoTotal =0;
	}
	
	public void agregarProducto (Producto unProducto) {
		cantidadProductos++;
		precioTotal += unProducto.getPrecio();
		pesoTotal+=unProducto.getPeso();
	}
	
	public Ticket emitirTicket() {
		Ticket unTicket = new Ticket (cantidadProductos, pesoTotal, precioTotal);
		return unTicket;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public int getCantidadDeProductos() {
		return cantidadProductos;
	}
}
