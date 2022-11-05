package ar.edu.unlp.objetos.uno.ejercicio19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MercadoOnline {
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	
	public MercadoOnline() {
		this.vendedores = new ArrayList<Vendedor>();
		this.clientes = new ArrayList<Cliente>();
	}
	
	public int getSizeVendedores() {
		return this.vendedores.size();
	}
	
	public int getSizeClientes() {
		return this.clientes.size();
	}
	
	public Vendedor registrarVendedor(String nombre, String direccion) {
		Vendedor v = new Vendedor(nombre,direccion);
		this.vendedores.add(v);
		return v;
	}
	
	public Vendedor buscarVendedor(String nombreBuscado) {
		return this.vendedores.stream().filter(x->x.getNombre()==nombreBuscado).findAny().orElse(null);
	}
	
	public Cliente registrarCliente(String n,String d) {
		Cliente c = new Cliente(n,d);
		this.clientes.add(c);
		return c;
	}
	
	public Cliente buscarCliente(String nombreBuscado) {
		return this.clientes.stream().filter(x->x.getNombre()==nombreBuscado).findAny().orElse(null);
	}
	
	public List<Producto> buscarProducto(String n){
		return this.vendedores.stream().map(x->x.buscarProducto(n)).flatMap(x->x.stream()).collect(Collectors.toList());
	}
}
