package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MercadoOnlineTest {
	private MercadoOnline mercado1;
	private MercadoOnline mercado2;
	
	@BeforeEach
	public void setUp() {
		this.mercado1 = new MercadoOnline();
		this.mercado2 = new MercadoOnline();
	}
	
	@Test
	public void testRegistrarVendedor() {
		assertEquals(0,this.mercado2.getSizeVendedores());
		assertEquals("Carla",this.mercado1.registrarVendedor("Carla", "Avenida 1").getNombre());
		assertEquals(1,this.mercado1.getSizeVendedores());
	}
	
	@Test
	public void testBuscarVendedor() {
		assertNull(this.mercado2.buscarVendedor("Sofia"));
		this.mercado1.registrarVendedor("Carla", "Avenida 1");
		assertNotNull(this.mercado1.buscarVendedor("Carla"));
		assertNull(this.mercado1.buscarVendedor("Jose"));
	}
	
	@Test
	public void testRegistrarCliente() {
		assertEquals(0,this.mercado2.getSizeClientes());
		assertEquals("Carlos",this.mercado1.registrarCliente("Carlos", "Avenida 10").getNombre());
		this.mercado1.registrarCliente("Romina", "Calle 4");
		assertEquals(2,this.mercado1.getSizeClientes());
	}
	
	@Test
	public void testBuscarCliente() {
		assertNull(this.mercado2.buscarCliente("Sofia"));
		this.mercado1.registrarCliente("Carlos", "Avenida 17");
		assertNotNull(this.mercado1.buscarCliente("Carlos"));
		assertNull(this.mercado1.buscarCliente("Jose"));
	}
	
	@Test
	public void testBuscarProducto() {
		assertEquals(0,this.mercado1.buscarProducto("Zapas").size());
		this.mercado2.registrarVendedor("Carla", "Avenida 1").ponerProductoVenta("Galletitas", "Chocolate", 40, 52);
		this.mercado2.registrarVendedor("Carlos", "Avenida 10").ponerProductoVenta("Galletitas", "Frutilla", 70, 50);
		this.mercado2.registrarVendedor("Daniel", "Avenida 12").ponerProductoVenta("Galletitas", "Vainilla", 100, 30);
		assertEquals(3,this.mercado2.buscarProducto("Galletitas").size());
		assertEquals(50,this.mercado2.buscarProducto("Galletitas").get(1).getDisponibles());
		assertEquals(0,this.mercado2.buscarProducto("Flores").size());
	}
}
