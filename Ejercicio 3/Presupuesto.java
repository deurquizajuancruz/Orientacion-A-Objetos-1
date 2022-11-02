package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	//constructor
	
	public Presupuesto() {
		setFecha(LocalDate.now());
		items = new ArrayList<Item>();
	}
	
	public Presupuesto cliente(String unCliente) {
		setCliente(unCliente);
		return this;
	}
	
	public void agregarItem(Item unItem) {
		items.add(unItem);
	}
	
	public double calcularTotal() {
		double total=0;
		for (int i=0;i<items.size();i++) {
			total+=items.get(i).costo();
		}
		return total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
