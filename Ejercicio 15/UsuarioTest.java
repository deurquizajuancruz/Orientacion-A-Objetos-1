package ar.edu.unlp.objetos.uno.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private DateLapse periodo1;
	private Propiedad p1;
	private Reserva r1;
	
	@BeforeEach
	public void setUp() {
		this.usuario1 = new Usuario("Alejandro","Calle 1",11);
		this.usuario2 = new Usuario("Benjamin","Calle 2",22);
		this.usuario3 = new Usuario("Claudia","Calle 3",33);
		this.periodo1 = new DateLapse(LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 30));
		this.p1 = new Propiedad("Propiedad 1","La Plata","La prop 1",500);
		this.r1= new Reserva(periodo1,p1,this.usuario3);
	}
	
	@Test
	public void testRegistrarPropiedad() {
		assertNotNull(this.usuario1.registrarPropiedad("La propiedad 1", "Buenas vistas", "Avenida 1", 600));
		assertEquals(1,this.usuario1.getSizePropiedadesAlquiler());
		assertEquals(0,this.usuario2.getSizePropiedadesAlquiler());
	}
	
	@Test
	public void testAgregarReserva() {
		this.usuario2.agregarReserva(r1);
		assertEquals(1,this.usuario2.getSizeReservadas());
		assertEquals(0,this.usuario3.getSizeReservadas());
	}
	
	@Test
	public void testGetReservadas() {
		this.usuario1.agregarReserva(r1);
		List<Reserva> lista = this.usuario1.getReservadas();
		assertNotEquals(0,lista.size());
		assertEquals(1,lista.size());
	}
	
	@Test
	public void testCalcularIngresos() {
		DateLapse periodo2 = new DateLapse(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 7, 15));
		this.usuario1.registrarPropiedad("Ventanas", "Buena vista", "Calle 11", 600).hacerReserva(periodo2, usuario2);
		assertEquals(8400,this.usuario1.calcularIngresos(new DateLapse(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 12, 1))));
		assertEquals(0,this.usuario1.calcularIngresos(periodo1));
		assertEquals(1,this.usuario2.getSizeReservadas());
		DateLapse periodo3 = new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30));
		this.usuario2.registrarPropiedad("Balcones", "Espaciosa", "Avenida General", 1000).hacerReserva(periodo3, usuario3); //29 dias, $29000
		DateLapse periodoMitad = new DateLapse(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 15));
		assertEquals(14000,this.usuario2.calcularIngresos(periodoMitad));
	}
}
