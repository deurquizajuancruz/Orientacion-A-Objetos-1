package ar.edu.unlp.objetos.uno.ejercicio19;

public class Pedido {
	private Producto producto;
	private OpcionesDePago opcion;
	private MecanismosDeEnvio envio;
	private int cantidad;
	
	public Pedido(Producto p, OpcionesDePago o,MecanismosDeEnvio e,int c) {
		this.producto=p;
		this.opcion=o;
		this.envio=e;
		this.cantidad=c;
	}
	
	public double calcularCosto() {
		return this.opcion.calcularMonto(this.producto.getPrecio()) + this.envio.calcularMonto();
	}
	
	public boolean chequearCantidad() {
		return this.cantidad<=this.producto.getDisponibles();
	}
	
	public void actualizarProducto() {
		if (this.chequearCantidad()) {
			this.producto.actualizarCantidad(this.cantidad);
		}
	}
	
}
