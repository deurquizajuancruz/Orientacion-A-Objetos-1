package ar.edu.unlp.objetos.uno.Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContratosTest {
	private ContratoPorHoras horas1;
	private ContratoPorHoras horas2;
	private ContratoPorHoras horas3;
	private ContratoPorHoras futuro;
	private ContratoDePlanta planta1;
	private ContratoDePlanta planta2;
	private ContratoDePlanta planta3;
	private Empleado em1;
	private Empleado em2;
	private Empleado em3;	
	
	@BeforeEach
	public void setUp() {
		this.em1 = new Empleado("Ana","Anacleto",442,LocalDate.of(1980, 5, 4),true,true,LocalDate.of(2000, 1, 12));
		this.em2 = new Empleado("Bautista","Balleros",330,LocalDate.of(1975, 5, 4),false,true,LocalDate.of(1999, 12, 12));
		this.em3 = new Empleado("Cristobal","Colon",550,LocalDate.of(2003, 5, 4),false,false,LocalDate.of(2020, 5, 7));
		this.horas1 = new ContratoPorHoras(LocalDate.of(2002, 1, 1),120,112,LocalDate.of(2003, 1, 1));
		this.horas2 = new ContratoPorHoras(LocalDate.of(2010, 2, 1),150,130,LocalDate.of(2014, 2, 1));
		this.horas3 = new ContratoPorHoras(LocalDate.of(2021, 3, 1),200,100,LocalDate.of(2021, 2, 28));
		this.futuro = new ContratoPorHoras(LocalDate.of(2030, 2, 1),150,130,LocalDate.of(2031, 2, 1));
		this.planta1 = new ContratoDePlanta(LocalDate.of(2015, 8, 1),this.em1,1000,100,300);
		this.planta2 = new ContratoDePlanta(LocalDate.of(2019, 1, 30),this.em2,1200,70,450);
		this.planta3 = new ContratoDePlanta(LocalDate.of(2022, 7, 1),this.em3,1700,100,750);
	}
	
	@Test
	public void testTiene() {
		assertTrue(this.planta1.tieneConyuge());
		assertTrue(this.planta1.tieneHijos());
		assertFalse(this.planta2.tieneHijos());
		assertTrue(this.planta2.tieneConyuge());
		assertFalse(this.planta3.tieneConyuge());
		assertFalse(this.planta3.tieneHijos());
	}
	
	@Test
	public void testGetDuracionAños() {
		assertEquals(1,this.horas1.getDuracionAños());
		assertEquals(4,this.horas2.getDuracionAños());
		assertEquals(0,this.horas3.getDuracionAños());		
		assertEquals(7,this.planta1.getDuracionAños());
		assertEquals(3,this.planta2.getDuracionAños());
		assertEquals(0,this.planta3.getDuracionAños());
		assertEquals(0,futuro.getDuracionAños());
	}
	
	@Test
	public void testCalcularMonto() {
		assertEquals(13440,this.horas1.calcularMonto());
		assertEquals(19500,this.horas2.calcularMonto());
		assertEquals(20000,this.horas3.calcularMonto());
		assertEquals(1400,this.planta1.calcularMonto());
		assertEquals(1650,this.planta2.calcularMonto());
		assertEquals(1700,this.planta3.calcularMonto());
	}
	
	@Test
	public void testVencido() {
		assertFalse(this.planta1.vencido());
		assertFalse(this.planta2.vencido());
		assertFalse(this.planta3.vencido());
		assertFalse(this.futuro.vencido());
		assertTrue(this.horas1.vencido());
		assertTrue(this.horas2.vencido());
		assertTrue(this.horas3.vencido());
		ContratoPorHoras noVencido = new ContratoPorHoras(LocalDate.of(2021, 3, 1),200,100,LocalDate.of(2023, 2, 28));
		assertFalse(noVencido.vencido());
	}
}
