package ar.edu.unlp.objetos.uno.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	private Propiedad propiedad1;
	private Propiedad propiedad2;
	private Propiedad propiedad3;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@BeforeEach
	public void setUp() {
		Politica pol1 = new PoliticaEstricta();
		Politica pol2 = new PoliticaFlexible();
		Politica pol3 = new PoliticaModerada();
		this.propiedad1 = new Propiedad("La propiedad 1","Calle 1","Buena ubicacion",1000,pol1);
		this.propiedad2 = new Propiedad("La propiedad 2","Calle 2","Ventanal grande",250,pol2);
		this.propiedad3 = new Propiedad("La propiedad 3","Calle 3","Lujoso",3000,pol3);
		this.periodo1 = new DateLapse(LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 30));
		this.periodo2 = new DateLapse(LocalDate.of(2022, 8, 3), LocalDate.of(2022, 8, 27));
		this.usuario1 = new Usuario ("Roberto","Calle 1",11);
		this.usuario2 = new Usuario ("Gerardo","Calle 2",2);
	}
	
	@Test
	public void testAgregarReserva() {
		assertEquals(0,this.propiedad1.getSizeReservas());
		this.propiedad1.agregarReserva(new Reserva(periodo1,this.propiedad1,usuario1));
		assertEquals(1,this.propiedad1.getSizeReservas());
	}
	
	@Test
	public void testHacerReserva() {
		assertNotNull(this.propiedad1.hacerReserva(periodo1, usuario1));
		assertNull(this.propiedad1.hacerReserva(periodo1, usuario2));
		DateLapse periodoSuperpone = new DateLapse(LocalDate.of(2020, 5, 29), LocalDate.of(2020, 7, 1));
		DateLapse periodoNoSuperpone = new DateLapse(LocalDate.of(2023, 5, 29), LocalDate.of(2023, 7, 1));		
		assertNull(this.propiedad1.hacerReserva(periodoSuperpone, usuario1));
		assertNotNull(this.propiedad1.hacerReserva(periodoNoSuperpone, usuario1));
		assertEquals(2,this.propiedad1.getSizeReservas());
		assertEquals(0,this.propiedad3.getSizeReservas());
	}
	
	@Test
	public void testDisponible() {
		assertTrue(this.propiedad1.disponible(periodo1));
		this.propiedad1.hacerReserva(periodo1, usuario2);
		assertFalse(this.propiedad1.disponible(periodo1));
	}
	
	@Test
	public void testCalcularIngresos() {
		assertEquals(1000,this.propiedad1.getPrecioPorNoche());
		assertEquals(0,this.propiedad1.calcularIngresos(periodo1));
		this.propiedad1.hacerReserva(periodo1, usuario2);
		assertEquals(15000,this.propiedad1.calcularIngresos(periodo1));
		assertEquals(0,this.propiedad1.calcularIngresos(periodo2));
		DateLapse mitad = new DateLapse(LocalDate.of(2020, 6, 1), LocalDate.of(2020, 6, 18));
		assertEquals(3000,this.propiedad1.calcularIngresos(mitad));
	}
	
	@Test
	public void testEliminarReserva() {
		this.propiedad2.hacerReserva(periodo1, usuario1);
		this.propiedad2.hacerReserva(periodo2, usuario2);
		assertEquals(2,this.propiedad2.getSizeReservas());
		Reserva r1 = new Reserva(this.periodo2,this.propiedad3,this.usuario2);
		this.propiedad2.agregarReserva(r1);
		assertEquals(3,this.propiedad2.getSizeReservas());
		this.propiedad2.eliminarReserva(r1);
		assertEquals(2,this.propiedad2.getSizeReservas());
	}
	
	@Test
	public void testCancelarReserva() {
		assertEquals(0,this.propiedad1.cancelarReserva(10000, LocalDate.of(2020, 4, 6), LocalDate.of(2020, 6, 25)));
		assertEquals(2000, this.propiedad2.cancelarReserva(2000, LocalDate.of(2021, 4, 1), LocalDate.of(2021, 5, 2)));
		assertEquals(0, this.propiedad2.cancelarReserva(2000, LocalDate.of(2021, 7, 1), LocalDate.of(2021, 5, 2)));
		assertEquals(4000,this.propiedad3.cancelarReserva(4000, LocalDate.of(2020, 4, 3), LocalDate.of(2021, 1, 1)));
		assertEquals(2000,this.propiedad3.cancelarReserva(4000, LocalDate.of(2020, 4, 3), LocalDate.of(2020, 4, 5)));
		assertEquals(0,this.propiedad3.cancelarReserva(4000, LocalDate.of(2021, 1, 2), LocalDate.of(2021, 1, 1)));
	}
}
