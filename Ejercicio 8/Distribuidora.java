package ar.edu.unlp.objetos.uno.ejercicio8;

import java.util.*;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precio) {
		this.precioKWh=precio;
		this.usuarios=new ArrayList <Usuario>();
	}
	
	public void agregarUsuario(Usuario Usuario) {
		this.usuarios.add(Usuario);
	}
	
	public List<Factura> facturar() {
		List<Factura> total = this.usuarios.stream().
		map((Usuario u)-> u.facturarEnBaseA(getPrecioKW()))
		.collect(Collectors.toList());
		return total;
	}
	
	public double consumoTotalActiva() { //recorrer la lista de todos los usuraios sumando sus ultimos consumos de energia activa
		return this.usuarios.stream().
		mapToDouble((Usuario u) -> u.ultimoConsumoActiva())
		.sum();
	}
	
	public double getPrecioKW() {
		return this.precioKWh;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
}
