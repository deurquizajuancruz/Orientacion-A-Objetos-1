package ar.edu.unlp.objetos.uno.Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {
	private Empresa empresa1;
	private Empresa empresa2;
	private Empresa empresa3;
	private Empleado em1;
	private Empleado em2;
	private Empleado em3;
	
	@BeforeEach
	public void setUp() {
		this.empresa1 = new Empresa();
		this.empresa2 = new Empresa();
		this.empresa3 = new Empresa();
		this.em1 = new Empleado("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true,LocalDate.of(1995, 6,6));
		this.em2 = new Empleado("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true,LocalDate.of(1999, 11, 1));
		this.em3 = new Empleado("Cameron","Comino",335,LocalDate.of(1984, 2, 28),false,false,LocalDate.of(2004, 9, 9));
	}
	
	@Test
	public void testDarDeAlta() {
		assertEquals(0, this.empresa1.getSizeEmpleados());
		this.empresa2.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		assertEquals(1,this.empresa2.getSizeEmpleados());
		this.empresa3.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		this.empresa3.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa3.darDeAlta("Cameron","Comino",335,LocalDate.of(1984, 2, 28),false,false);
		assertEquals(3,this.empresa3.getSizeEmpleados());
	}
	
	@Test
	public void testBuscarEmpleado() {
		assertNull(this.empresa1.buscarEmpleado(442));
		this.empresa2.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		assertNotNull(this.empresa2.buscarEmpleado(113));
		assertNull(this.empresa2.buscarEmpleado(114));
		this.empresa3.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa3.darDeAlta("Cameron","Comino",335,LocalDate.of(1984, 2, 28),false,false);
		assertNotNull(this.empresa3.buscarEmpleado(335));
		assertFalse(this.empresa3.buscarEmpleado(335).getConyuge());
	}
	
	@Test
	public void testDarDeBaja() {
		assertEquals(0,this.empresa3.getSizeEmpleados());
		this.empresa1.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		assertEquals(1,this.empresa1.getSizeEmpleados());
		this.empresa1.darDeBaja(this.empresa1.buscarEmpleado(113));
		assertEquals(0,this.empresa1.getSizeEmpleados());
		this.empresa1.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa1.darDeBaja(this.empresa1.buscarEmpleado(777));
		assertEquals(1,this.empresa1.getSizeEmpleados());
	}
	
	@Test
	public void testContratosVencidos() {
		assertTrue(this.empresa2.contratosVencidos().isEmpty());
		this.empresa1.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		this.empresa1.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa1.buscarEmpleado(113).setFechaInicio(LocalDate.of(1995, 6,6));
		this.empresa1.buscarEmpleado(224).setFechaInicio(LocalDate.of(1999, 11, 1));
		this.empresa1.buscarEmpleado(113).cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		this.empresa1.buscarEmpleado(224).cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		assertEquals(1,this.empresa1.contratosVencidos().size());
		this.empresa3.darDeAlta("Cameron","Comino",335,LocalDate.of(1984, 2, 28),false,false);
		this.empresa3.buscarEmpleado(335).setFechaInicio(LocalDate.of(2004, 9, 9));
		this.empresa3.buscarEmpleado(335).cargarContratoPorHoras(LocalDate.of(2015, 5, 6),150,130,LocalDate.of(2018, 8, 1));
		assertEquals(1,this.empresa3.contratosVencidos().size());
	}
	
	@Test
	public void testRecibosSueldo() {
		assertTrue(this.empresa3.recibosSueldo().isEmpty());
		this.empresa1.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		this.empresa1.buscarEmpleado(113).setFechaInicio(LocalDate.of(1995, 6,6));
		this.empresa1.buscarEmpleado(113).cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		this.empresa1.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa1.buscarEmpleado(224).setFechaInicio(LocalDate.of(1999, 11, 1));
		this.empresa1.buscarEmpleado(224).cargarContratoDePlanta(LocalDate.of(2004, 3, 1),20000,3500,800);
		assertEquals(2,this.empresa1.recibosSueldo().size());
		assertEquals(244790,this.empresa1.recibosSueldo().get(0).getMonto());
		this.empresa2.darDeAlta("Anibal","Alzemo",113,LocalDate.of(1970, 11, 14),true,true);
		this.empresa2.buscarEmpleado(113).setFechaInicio(LocalDate.of(1995, 6,6));
		this.empresa2.buscarEmpleado(113).cargarContratoDePlanta(LocalDate.of(2015, 1, 30),185000,2850,450);
		this.empresa2.darDeAlta("Bruno","Batistuta",224,LocalDate.of(1976, 6, 30),false,true);
		this.empresa2.buscarEmpleado(224).setFechaInicio(LocalDate.of(1999, 11, 1));
		this.empresa2.buscarEmpleado(224).cargarContratoPorHoras(LocalDate.of(2000, 2, 1),150,130,LocalDate.of(2014, 8, 1));
		assertNull(this.empresa2.recibosSueldo().get(1));
	}
}
