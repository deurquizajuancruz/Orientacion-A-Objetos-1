package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	private Pedido pedido1;
	private Pedido pedido2;
	private Pedido pedido3;
	private Producto produ1;
	private Producto produ2;
	
	@BeforeEach
	public void setUp() {
		this.produ1 = new Producto("Galletitas","Sabor frutilla",150,600);
		this.produ2 = new Producto("Tostadas","Pan Integral",200,450);
		this.pedido1 = new Pedido(produ1,new Cuotas(),new RetiroComercio(),200);
		this.pedido2 = new Pedido(produ2,new AlContado(),new RetiroSucursal(),500);
		this.pedido3 = new Pedido(produ2,new Cuotas(), new ExpressDomicilio(),140);
	}
	
	@Test
	public void testCalcularCosto() {
		assertEquals(180,this.pedido1.calcularCosto());
		assertEquals(250,this.pedido2.calcularCosto());
		assertEquals(340,this.pedido3.calcularCosto());
	}
	
	@Test
	public void testChequearCantidad() {
		assertTrue(this.pedido1.chequearCantidad());
		assertFalse(this.pedido2.chequearCantidad());
	}
	
	@Test
	public void testActualizarProducto() {
		this.pedido1.actualizarProducto();
		assertEquals(400,this.produ1.getDisponibles());
		this.pedido2.actualizarProducto();
		assertEquals(450,this.produ2.getDisponibles());
	}
}
