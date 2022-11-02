package ar.edu.unlp.objetos.uno.ejercicio11;

public class InversionEnAcciones implements Inversion {
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones(String unNombre, int unaCantidad, double unValor) {
		this.nombre=unNombre;
		this.cantidad=unaCantidad;
		this.valorUnitario=unValor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public double getValorUnitario() {
		return this.valorUnitario;
	}
	
	public void setNombre(String unNombre) {
		this.nombre=unNombre;
	}
	
	public void setCantidad(int unaCantidad) {
		this.cantidad=unaCantidad;
	}
	
	public void setValorUnitario(double valorU) {
		this.valorUnitario=valorU;
	}
	
	@Override
	public double valorActual() {
		return this.cantidad*this.valorUnitario;
	}

}
