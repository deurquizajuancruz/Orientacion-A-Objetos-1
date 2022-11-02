package ar.edu.unlp.objetos.uno.ejercicio2;

public class Producto {
	private double peso;
	private double precioPorKilo;
	private String descripcion;
	
	public Producto() {
		
	}
	
	public Producto(double unPeso, double unPrecio) {
		peso=unPeso;
		precioPorKilo=unPrecio;
	}
	
	public double getPrecio() {
		return (peso*precioPorKilo);
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double unPeso) {
		peso=unPeso;
	}
	public void setPrecioPorKilo (double unPesoPorKilo) {
		precioPorKilo=unPesoPorKilo;
	}
	public void setDescripcion(String unaDescripcion) {
		descripcion = unaDescripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecioPorKilo() {
		return precioPorKilo;
	}
}
