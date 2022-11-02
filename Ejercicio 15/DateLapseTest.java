package ar.edu.unlp.objetos.uno.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	private DateLapse periodo4;
	private DateLapse periodo5;
	
	@BeforeEach
	public void setUp() {
		this.periodo1 = new DateLapse(LocalDate.of(2020, 6, 15), LocalDate.of(2020, 6, 30)); // del 15 al 30 de junio 2020
		this.periodo2 = new DateLapse(LocalDate.of(2020, 6, 20), LocalDate.of(2020, 6, 29)); // del 20 al 29 de junio 2020
		this.periodo3 = new DateLapse(LocalDate.of(2021, 7, 14), LocalDate.of(2021, 7, 19)); // del 14 al 19 de julio 2021
		this.periodo4 = new DateLapse(LocalDate.of(2021, 7, 1), LocalDate.of(2021, 7, 22)); //  del 1 al 22 de julio 2021
		this.periodo5 = new DateLapse(LocalDate.of(2021, 7, 24), LocalDate.of(2021, 7, 30)); // del 24 al 30 de julio 2021
	}
	
	@Test
	public void testOverlaps() {
		assertTrue(this.periodo3.overlaps(periodo4));
		assertTrue(this.periodo4.overlaps(periodo3));
		assertFalse(this.periodo1.overlaps(periodo4));
		assertFalse(this.periodo5.overlaps(periodo4));
		assertTrue(this.periodo2.overlaps(periodo1));
	}
	
}
