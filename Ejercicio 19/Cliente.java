package ar.edu.unlp.objetos.uno.ejercicio19;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
	private List<Pedido> pedidos;
	
	public Cliente(String n, String d) {
		super(n,d);
		this.pedidos= new ArrayList<Pedido>();
	}
	
	public int getSizePedidos() {
		return this.pedidos.size();
	}
	
	public void crearPedido(Producto p, OpcionesDePago pago, MecanismosDeEnvio envio, int cant) {
		Pedido pedido = new Pedido(p,pago,envio,cant);
		if (pedido.chequearCantidad()) {
			this.pedidos.add(pedido);
		}
	}
}
