package ar.edu.unlp.objetos.uno.ejercicio9;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
	private CuentaCorriente corriente1,corriente2;
	private CajaDeAhorro ahorro1,ahorro2;
	
	@BeforeEach
	public void setUp() {
		this.corriente1 = new CuentaCorriente();
		this.corriente2 = new CuentaCorriente();
		this.ahorro1 = new CajaDeAhorro();
		this.ahorro2 = new CajaDeAhorro();
	}
	
	@Test
	public void verificarSaldo0() {
		assertEquals(0,this.corriente1.getSaldo());
		assertEquals(0,this.corriente2.getSaldo());
		assertEquals(0,this.ahorro1.getSaldo());
		assertEquals(0,this.ahorro2.getSaldo());
	}
	
	@Test
	public void cargaSaldo() {
		this.corriente1.depositar(500);
		this.corriente2.depositar(600);
		assertEquals(500,this.corriente1.getSaldo());
		assertEquals(600,this.corriente2.getSaldo());
		this.ahorro1.depositar(1000);
		this.ahorro2.depositar(5000);
		assertEquals(1000,this.ahorro1.getSaldo());
		assertEquals(5000,this.ahorro2.getSaldo());
	}
	
	@Test
	public void extraccionAhorro() {
		this.ahorro1.depositar(20000);
		assertEquals(false,this.ahorro1.puedeExtraer(19900));
		assertEquals(true,this.ahorro1.puedeExtraer(15000));
		assertEquals(true,this.ahorro1.extraer(7000));
		assertEquals(13000,this.ahorro1.getSaldo());
	}
	@Test
	public void extraccionCorriente() {
		this.corriente1.depositar(15000);
		this.corriente1.setDescubierto(-1000);
		assertEquals(true,this.corriente1.puedeExtraer(16000));
		assertEquals(true,this.corriente1.puedeExtraer(15500));
		assertEquals(false,this.corriente1.puedeExtraer(16001));
		assertEquals(true,this.corriente1.extraer(15600));
		assertEquals(-600,this.corriente1.getSaldo());
	}
	@Test
	public void transferencias() {
		this.ahorro2.depositar(30000);
		this.corriente2.setDescubierto(-500);
		assertEquals(false,this.ahorro2.puedeExtraer(29500));
		this.ahorro2.transferirACuenta(25010, corriente2);
		assertEquals(25010,this.corriente2.getSaldo());
		assertEquals(false,this.corriente2.puedeExtraer(25511));
		assertEquals(true,this.corriente2.puedeExtraer(25510));
		this.corriente2.transferirACuenta(478, ahorro2);
		assertEquals(5468,this.ahorro2.getSaldo());
	}
	
}
