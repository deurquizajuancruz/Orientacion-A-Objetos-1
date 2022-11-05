package ar.edu.unlp.objetos.uno.ejercicio19;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpcionesDePagoTest {
	private OpcionesDePago contado;
	private OpcionesDePago cuotas;
	
	@BeforeEach
	public void setUp() {
		this.contado = new AlContado();
		this.cuotas = new Cuotas();
	}
	
	@Test
	public void testCalcularMonto() {
		assertEquals(400,this.contado.calcularMonto(400));
		assertEquals(540,this.cuotas.calcularMonto(450));
	}
}
