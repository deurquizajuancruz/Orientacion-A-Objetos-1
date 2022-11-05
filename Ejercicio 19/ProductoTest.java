package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {
	private Producto produ1;
	private Producto produ2;
	
	@BeforeEach
	public void setUp() {
		this.produ1 = new Producto("Galletitas","Sabor frutilla",150,600);
		this.produ2 = new Producto("Tostadas","Pan Integral",200,450);		
	}
	
	@Test
	public void testGetters() {
		assertEquals(600,this.produ1.getDisponibles());
		assertEquals("Tostadas",this.produ2.getNombre());
		assertEquals(150,this.produ1.getPrecio());
	}
	
	@Test
	public void testActualizarCantidad() {
		this.produ1.actualizarCantidad(200);
		assertEquals(400,this.produ1.getDisponibles());
		this.produ2.actualizarCantidad(451);
		assertEquals(-1,this.produ2.getDisponibles());
	}
}
