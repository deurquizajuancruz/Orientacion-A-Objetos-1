package ar.edu.unlp.info.oo1.ejercicio3;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	
	public Item detalle(String unDetalle) {
		setDetalle(unDetalle);
		return this;
	}
	
	public Item cantidad(int unaCantidad) {
		cantidad=unaCantidad;
		return this;
	}
	
	public Item costoUnitario(double unCostoUnitario) {
		costoUnitario=unCostoUnitario;
		return this;
	}
	
	public double getCostoUnitario() {
		return costoUnitario;
	}
	
	public double costo() {
		return cantidad*costoUnitario;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
