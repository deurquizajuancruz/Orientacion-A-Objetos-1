package ar.edu.unlp.info.oo1.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

	private Item item;

	@BeforeEach
	public void setUp() {
		item = new Item().detalle("azucar").costoUnitario(60.3).cantidad(2);
		
//		item = new Item();
//		item.detalle("azucar");
//		item.costoUnitario(60);
//		item.cantidad(2);
	}

	@Test
	public void testCosto() {
		assertEquals(120.6, item.costo());
	}

	@Test
	public void testCostoUnitario() {
		assertEquals(60.3, item.getCostoUnitario());
	}
}
