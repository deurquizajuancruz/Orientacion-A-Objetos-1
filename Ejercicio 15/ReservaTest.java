package ar.edu.unlp.objetos.uno.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	private Reserva reserva4;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;

	@BeforeEach
	private void setUp() {
		Propiedad p1 = new Propiedad("Propiedad 1","La Plata","La prop 1",500);
		Propiedad p2 = new Propiedad("Propiedad 2","La Pampa","La prop 2",700);
		Propiedad p3 = new Propiedad("Propiedad 3","Mar del Plata","La prop 3",1000);
		this.periodo1 = new DateLapse(LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 30)); // del 15 al 30 de junio 2020
		this.periodo2 = new DateLapse(LocalDate.of(2020, 6, 20), LocalDate.of(2020, 6, 29)); // del 20 al 29 de junio 2020
		this.periodo3 = new DateLapse(LocalDate.of(2021, 7, 14), LocalDate.of(2021, 7, 19)); // del 14 al 19 de julio 2021
		Usuario u1 = new Usuario ("Roberto","Calle 1",11);
		Usuario u2 = new Usuario ("Gerardo","Calle 2",2);
		Usuario u3 = new Usuario ("Florencio","Calle 3",33);
		this.reserva1 = new Reserva (this.periodo1,p1,u1);
		this.reserva2 = new Reserva (this.periodo2,p2,u2);
		this.reserva3 = new Reserva (this.periodo3,p3,u3);
		Propiedad p4 = new Propiedad("Propiead 4","La Matanza", "No se alquila",0);
		DateLapse d4 = new DateLapse(LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 11));
		Usuario u4 = new Usuario ("Fantasma","No vive",0);
		this.reserva4 = new Reserva(d4,p4,u4);
	}
	
	@Test
	public void testSizeInDays() {
		assertEquals(15,this.periodo1.sizeInDays());
		assertEquals(9,this.periodo2.sizeInDays());
		assertEquals(5,this.periodo3.sizeInDays());
	}
	
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(7500,this.reserva1.calcularPrecio(new DateLapse(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 30))));//15*500
		assertEquals(4500,this.reserva1.calcularPrecio(new DateLapse(LocalDate.of(2020, 6, 16), LocalDate.of(2020, 6, 25))));//9*500
		assertEquals(6300,this.reserva2.calcularPrecio(new DateLapse(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 30))));//9*700
		assertEquals(2800,this.reserva2.calcularPrecio(new DateLapse(LocalDate.of(2020, 6, 25), LocalDate.of(2020, 6, 29))));//4*700		
		assertEquals(5000,this.reserva3.calcularPrecio(new DateLapse(LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 31))));//5*1000
		assertEquals(2000,this.reserva3.calcularPrecio(new DateLapse(LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 16))));//2*1000
		assertEquals(0,this.reserva4.calcularPrecio(new DateLapse(LocalDate.of(2023, 8, 10), LocalDate.of(2020, 8, 12))));
	}
	
	@Test
	public void testRealizadaEn() {
		assertTrue(this.reserva1.realizadaEn(periodo2));
		assertFalse(this.reserva1.realizadaEn(periodo3));
		assertFalse(this.reserva4.realizadaEn(periodo2));
	}
	
	
	@Test 
	public void testEliminarReserva() {
		this.reserva4.getInquilino().agregarReserva(this.reserva2);
		assertEquals(1,this.reserva4.getInquilino().getSizeReservadas());
		this.reserva4.eliminarReserva(this.reserva2);
		assertEquals(0,this.reserva4.getInquilino().getSizeReservadas());
		this.reserva3.getInquilino().agregarReserva(this.reserva1);
		assertEquals(1,this.reserva3.getInquilino().getSizeReservadas());
		this.reserva3.eliminarReserva(this.reserva1);
		assertEquals(1,this.reserva3.getInquilino().getSizeReservadas());
	}
}
