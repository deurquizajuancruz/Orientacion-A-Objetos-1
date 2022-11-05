package ar.edu.unlp.objetos.uno.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vendedor extends Persona{
	private List<Producto> productosVenta;
	
	public Vendedor(String n, String d) {
		super(n,d);
		this.productosVenta = new ArrayList<Producto>();
	}
	
	public int getSizeProductosVenta() {
		return this.productosVenta.size();
	}
	
	public Producto ponerProductoVenta(String n, String d, double precio, int dispo) {
		Producto p = new Producto(n,d,precio,dispo);
		this.productosVenta.add(p);
		return p;
	}
	
	public List<Producto> buscarProducto(String nombreBuscado){
		return this.productosVenta.stream().filter(x->x.getNombre()==nombreBuscado).collect(Collectors.toList());
	}
}
