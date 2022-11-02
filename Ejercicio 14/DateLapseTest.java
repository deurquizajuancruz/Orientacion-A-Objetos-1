package ar.edu.unlp.objetos.uno.ejercicio14;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

public class DateLapseTest {
	private DateLapseT3 lapso1;
	private DateLapseT3 lapso2;
	private DateLapse lapso3;
	private DateLapse lapso4;
	
	@BeforeEach
	public void setUp() {
		this.lapso3 = new DateLapse(LocalDate.of(2007, 10, 3), LocalDate.of(2020, 12, 23));
		this.lapso4 = new DateLapse(LocalDate.of(2010, 9, 4), LocalDate.of(2022, 11, 14));
		this.lapso1 = new DateLapseT3(LocalDate.of(2007, 10, 3),4830);
		this.lapso2 = new DateLapseT3(LocalDate.of(2010, 9, 4),4454);
	}
	
	@Test
	public void pruebaGets() {
		assertEquals(LocalDate.of(2007, 10, 3),this.lapso1.getFrom());
		assertEquals(LocalDate.of(2020, 12, 23),this.lapso1.getTo());
		assertEquals(LocalDate.of(2007, 10, 3),this.lapso3.getFrom());
		assertEquals(LocalDate.of(2020, 12, 23),this.lapso3.getTo());
		assertEquals(LocalDate.of(2010, 9, 4),this.lapso2.getFrom());
		assertEquals(LocalDate.of(2022, 11, 14),this.lapso2.getTo());
		assertEquals(LocalDate.of(2010, 9, 4),this.lapso4.getFrom());
		assertEquals(LocalDate.of(2022, 11, 14),this.lapso4.getTo());
	}
	
	@Test
	public void pruebaDias() {
		assertEquals(4830,this.lapso1.sizeInDays());
		assertEquals(4454,this.lapso2.sizeInDays());		
		assertEquals(4830,this.lapso3.sizeInDays());
		assertEquals(4454,this.lapso4.sizeInDays());		
	}
	
	@Test
	public void pruebaIncludes() {
		assertTrue(this.lapso1.includesDate(LocalDate.of(2011, 6, 25)));
		assertTrue(this.lapso1.includesDate(LocalDate.of(2007, 10, 3)));
		assertTrue(this.lapso1.includesDate(LocalDate.of(2020, 12, 23)));
		assertFalse(this.lapso1.includesDate(LocalDate.of(2007, 10, 2)));
		assertFalse(this.lapso1.includesDate(LocalDate.of(2020, 12, 24)));
		assertFalse(this.lapso1.includesDate(LocalDate.of(2021, 4, 12)));		
		assertTrue(this.lapso3.includesDate(LocalDate.of(2011, 6, 25)));
		assertTrue(this.lapso3.includesDate(LocalDate.of(2007, 10, 3)));
		assertTrue(this.lapso3.includesDate(LocalDate.of(2020, 12, 23)));
		assertFalse(this.lapso3.includesDate(LocalDate.of(2007, 10, 2)));
		assertFalse(this.lapso3.includesDate(LocalDate.of(2020, 12, 24)));
		assertFalse(this.lapso3.includesDate(LocalDate.of(2021, 4, 12)));		
		assertTrue(this.lapso2.includesDate(LocalDate.of(2011, 6, 25)));
		assertTrue(this.lapso2.includesDate(LocalDate.of(2010, 9, 4)));
		assertTrue(this.lapso2.includesDate(LocalDate.of(2022, 11, 14)));
		assertFalse(this.lapso2.includesDate(LocalDate.of(2007, 10, 2)));
		assertFalse(this.lapso2.includesDate(LocalDate.of(2010, 9, 3)));
		assertFalse(this.lapso2.includesDate(LocalDate.of(2022, 11, 15)));		
		assertTrue(this.lapso4.includesDate(LocalDate.of(2011, 6, 25)));
		assertTrue(this.lapso4.includesDate(LocalDate.of(2010, 9, 4)));
		assertTrue(this.lapso4.includesDate(LocalDate.of(2022, 11, 14)));
		assertFalse(this.lapso4.includesDate(LocalDate.of(2007, 10, 2)));
		assertFalse(this.lapso4.includesDate(LocalDate.of(2010, 9, 3)));
		assertFalse(this.lapso4.includesDate(LocalDate.of(2022, 11, 15)));		
	}
}
