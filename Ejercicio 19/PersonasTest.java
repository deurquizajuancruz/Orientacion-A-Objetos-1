package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonasTest {
	private Vendedor v1;
	private Vendedor v2;
	private Cliente c1;
	private Cliente c2;
	
	@BeforeEach
	public void setUp() {
		this.v1 = new Vendedor("Camilo","Vende zapatillas");
		this.v2 = new Vendedor("Jose","Vende flores");
		this.c1 = new Cliente("Roxana","Compra antiguedades");
		this.c2 = new Cliente("Maria","Compra reliquias");
	}
	
	@Test
	public void testPonerProductoEnVenta() {
		assertEquals(0,this.v2.getSizeProductosVenta());
		assertEquals(1,this.v1.ponerProductoVenta("Nike", "Usadas", 1000, 1).getDisponibles());
		assertEquals(1,this.v1.getSizeProductosVenta());
	}
	
	@Test
	public void testBuscarProducto() {
		assertEquals(0,this.v2.buscarProducto("Adidas").size());
		this.v1.ponerProductoVenta("Under Armour", "Talle 10", 20000, 4);
		this.v1.ponerProductoVenta("Under Armour", "Talle 11", 20100, 5);
		assertEquals(2,this.v1.buscarProducto("Under Armour").size());
	}
	
	@Test
	public void testCrearPedido() {
		Producto pr1 = new Producto("Vasija","vieja",40000,10);
		this.c1.crearPedido(pr1, new Cuotas(), new ExpressDomicilio(), 6);
		assertEquals(1,this.c1.getSizePedidos());
		Producto pr2 = new Producto("Collar","chino",250000,2);
		this.c2.crearPedido(pr2, new AlContado(), new RetiroSucursal(), 5);
		assertEquals(0,this.c2.getSizePedidos());
	}
}
