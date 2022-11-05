package ar.edu.unlp.objetos.uno.ejercicio19;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int disponibles;
	
	public Producto(String n,String d,double p,int dis) {
		this.nombre=n;
		this.descripcion=d;
		this.precio=p;
		this.disponibles=dis;
	}
	
	public int getDisponibles() {
		return this.disponibles;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void actualizarCantidad(int pedidas) {
		this.disponibles-=pedidas;
	}
}
