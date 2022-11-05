package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MecanismosDeEnvioTest {
	private MecanismosDeEnvio express;
	private MecanismosDeEnvio sucursal;
	private MecanismosDeEnvio comercio;
	
	@BeforeEach
	public void setUp() {
		this.express = new ExpressDomicilio();
		this.sucursal = new RetiroSucursal();
		this.comercio = new RetiroComercio();
	}
	
	@Test
	public void testCalcularMonto() {
		assertEquals(100,this.express.calcularMonto());
		assertEquals(0,this.comercio.calcularMonto());
		assertEquals(50,this.sucursal.calcularMonto());
	}
}
