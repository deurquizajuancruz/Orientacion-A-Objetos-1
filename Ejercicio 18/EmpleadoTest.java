package ar.edu.unlp.objetos.uno.Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	private Empleado em1;
	private Empleado em2;
	private Empleado em3;
	
	@BeforeEach
	public void setUp() {
		this.em1 = new Empleado("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true,LocalDate.of(1995, 6,6));
		this.em2 = new Empleado("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true,LocalDate.of(1999, 11, 1));
		this.em3 = new Empleado("Cameron","Comino",335,LocalDate.of(1984, 2, 28),false,false,LocalDate.of(2004, 9, 9));
	}
	
	@Test
	public void testCargarContratos() {
		assertEquals(0,this.em1.getSizeContratos());
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		assertEquals(1,this.em1.getSizeContratos());
		this.em1.cargarContratoPorHoras(LocalDate.of(1990, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		assertEquals(1,this.em1.getSizeContratos());
		this.em2.cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		this.em2.cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		assertEquals(2,this.em2.getSizeContratos());
	}
	
	@Test
	public void testContratoUltimo() {
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		assertNotNull(this.em1.contratoUltimo());
		assertNull(this.em3.contratoUltimo());
		this.em2.cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		this.em2.cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		assertEquals(LocalDate.of(2015, 1, 30),this.em2.contratoUltimo().getFechaInicio());
	}
	
	@Test
	public void testContratoVencido() {
		assertTrue(this.em3.contratoVencido());
		this.em3.cargarContratoPorHoras(LocalDate.of(2005, 3, 1),200,100,LocalDate.of(2023, 12, 31));
		assertFalse(this.em3.contratoVencido());
		this.em2.cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		assertFalse(this.em2.contratoVencido());
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		assertTrue(this.em1.contratoVencido());
	}
	
	@Test
	public void testCalcularMonto() {
		assertEquals(0,this.em3.calcularMonto());
		this.em2.cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		assertEquals(0,this.em2.calcularMonto()); // contrato vencido
		this.em2.cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		assertEquals(185450,this.em2.calcularMonto());
		this.em1.cargarContratoPorHoras(LocalDate.of(2025, 1, 1),150,130,LocalDate.of(2031, 2, 1));
		assertEquals(19500,this.em1.calcularMonto());
	}

	@Test
	public void testCalcularAntiguedad() {
		assertEquals(0,this.em3.calcularAntiguedad());
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		this.em1.cargarContratoDePlanta(LocalDate.of(2004, 3, 1),20000,3500,800);
		assertEquals(26,this.em1.calcularAntiguedad());
		this.em2.cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		assertEquals(14,this.em2.calcularAntiguedad());
		this.em2.cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		assertEquals(21,this.em2.calcularAntiguedad());
		this.em3.cargarContratoPorHoras(LocalDate.of(2025, 1, 1),150,130,LocalDate.of(2031, 2, 1));
		assertEquals(0,this.em3.calcularAntiguedad());
	}
	
	@Test
	public void testBonusAntiguedad() {
		assertEquals(0,this.em1.bonusAntiguedad());
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		this.em1.cargarContratoDePlanta(LocalDate.of(2004, 3, 1),20000,3500,800);
		assertEquals(1,this.em1.bonusAntiguedad());
		this.em2.cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		assertEquals(0.5,this.em2.bonusAntiguedad());
		this.em2.cargarContratoPorHoras(LocalDate.of(2015, 2, 1),150,130,LocalDate.of(2016, 8, 1));
		assertEquals(0.7,this.em2.bonusAntiguedad());
		this.em3.cargarContratoDePlanta(LocalDate.of(2016, 1, 1), 100, 40, 30);
		assertEquals(0.3,this.em3.bonusAntiguedad());
	}
	
	@Test
	public void testGenerarRecibo() {
		assertNull(this.em2.generarRecibo());
		this.em1.cargarContratoPorHoras(LocalDate.of(1995, 6, 6),100,160,LocalDate.of(2003, 12, 31));
		assertNull(this.em1.generarRecibo());
		this.em1.cargarContratoDePlanta(LocalDate.of(2004, 3, 1),20000,3500,800);
		assertNotNull(this.em1.generarRecibo());
		assertEquals(48600,this.em1.generarRecibo().getMonto());
		this.em2.cargarContratoPorHoras(LocalDate.of(2020, 2, 1),150,130,LocalDate.of(2030, 8, 1));
		assertEquals(19500,this.em2.generarRecibo().getMonto());
		this.em3.cargarContratoDePlanta(LocalDate.of(2017, 11, 4), 140000, 2500, 6300);
		assertEquals(182000,this.em3.generarRecibo().getMonto());
		assertEquals(5,this.em3.generarRecibo().getAntiguedad());
	}
}
