package ar.edu.unlp.objetos.uno.ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	private Inversor inversor1;
	private Inversor inversor2;
	
	@BeforeEach
	public void setUp() {
		this.inversor1=new Inversor("Juan");
		this.inversor2=new Inversor("Felipe");
	}
	
	@Test
	public void nombres() {
		assertEquals("Juan",this.inversor1.getNombre());
		assertEquals("Felipe",this.inversor2.getNombre());
	}
	
	@Test
	public void cantidadInversiones() {
		PlazoFijo plazoUno = new PlazoFijo (LocalDate.of(2021, 7, 25),500,2);
		PlazoFijo plazoDos = new PlazoFijo (LocalDate.of(2020, 9, 13),1500,2.1);
		InversionEnAcciones accion1 = new InversionEnAcciones("Accion uno",6,5.23);
		InversionEnAcciones accion2 = new InversionEnAcciones("Accion dos",6,5.23);
		this.inversor1.agregarInversion(plazoUno);
		this.inversor1.agregarInversion(accion1);
		this.inversor2.agregarInversion(plazoUno);
		this.inversor2.agregarInversion(plazoDos);
		this.inversor2.agregarInversion(accion1);
		this.inversor2.agregarInversion(accion2);
		assertEquals(2,this.inversor1.cantidad());
		assertEquals(4,this.inversor2.cantidad());
	}
	
	@Test
	public void valorInversiones() {
		PlazoFijo plazo1 = new PlazoFijo(LocalDate.of(2022, 9, 17),500,10);
		InversionEnAcciones accion1 = new InversionEnAcciones("Accion 1",80,50);
		InversionEnAcciones accion2 = new InversionEnAcciones("Accion 2",0,100);
		assertEquals(1000,plazo1.valorActual());
		assertEquals(4000,accion1.valorActual());
		assertEquals(0,accion2.valorActual());
	}
/*	@Test
	public void Acciones() {
		InversionEnAcciones accion1 = new InversionEnAcciones("Accion 1",800,510);
		assertEquals("Accion 1",accion1.getNombre());
		assertEquals(800,accion1.getCantidad());
		assertEquals(510,accion1.getValorUnitario());
		assertEquals(408000,accion1.valorActual());
	}
*/	
	@Test
	public void multiplesInversiones() {
		PlazoFijo plazo1= new PlazoFijo(LocalDate.of(2021, 9, 27),12000,0.001); // 365*12000*0.001 + 12000 = 16.380
		PlazoFijo plazo2= new PlazoFijo(LocalDate.of(2022, 2, 13),3700,0.005); // 226*3700*0.005 + 3700 = 7.881
		InversionEnAcciones accion1 = new InversionEnAcciones("Accion 1",104,35.72); // 3714,88
		InversionEnAcciones accion2 = new InversionEnAcciones("Accion 2",2,10506); // 21.012
		this.inversor1.agregarInversion(plazo1);
		this.inversor1.agregarInversion(plazo2);
		this.inversor1.agregarInversion(accion1);
		this.inversor1.agregarInversion(accion2);
		assertEquals(48987.88,this.inversor1.valorActual(),2);
	}
}
