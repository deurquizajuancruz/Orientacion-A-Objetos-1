package ar.edu.unlp.objetos.uno.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadasTest {
	private LlamadaLocal local1;
	private LlamadaLocal local2;
	private LlamadaInterurbana urbana1;
	private LlamadaInterurbana urbana2;
	private LlamadaInternacional internacional1;
	private LlamadaInternacional internacional2;
	
	@BeforeEach
	public void setUp() {
		this.local1 = new LlamadaLocal(LocalDateTime.of(2021, 6, 15, 17, 4), 6, 221869894, 221147898); // 15/6/2021 17:04
		this.local2 = new LlamadaLocal(LocalDateTime.of(2021, 6, 18, 17, 18), 20, 221599894, 22247898); // 18/6/2021 17:18
		this.urbana1 = new LlamadaInterurbana(LocalDateTime.of(2021, 4, 20, 14, 25), 15, 30, 50, 99); // 20/4/2021 14:25
		this.urbana2 = new LlamadaInterurbana(LocalDateTime.of(2014, 8, 21, 4, 1), 15, 30, 50, 630);// 21/8/2014 0401 
		this.internacional1 = new LlamadaInternacional (LocalDateTime.of(2020, 7, 21, 9, 58), 16, 300, 510,"Camerun","Brasil");// 21/7/2020 0958
		this.internacional2 = new LlamadaInternacional (LocalDateTime.of(2020, 1, 3, 7, 15), 8, 410, 502,"Australia","Reino Unido");// 3/1/2020 0715
	}
	
	@Test
	public void testIncludesDate() {
		assertFalse(this.local1.includesDate(LocalDateTime.of(2021, 7, 1, 4, 52), LocalDateTime.of(2021, 8, 4, 17, 15))); // del 1/7/2021 0452 a 4/8/2021 1715
		assertTrue(this.local1.includesDate(LocalDateTime.of(2021, 6, 15, 17, 4), LocalDateTime.of(2021, 8, 17, 16, 5))); // del 15/6/2021 1704 a 17/8/2021 1605
		assertTrue(this.local2.includesDate(LocalDateTime.of(2021, 6, 18, 17, 15), LocalDateTime.of(2021, 6, 19, 2, 1))); // del 18/6/2021 1715 a 19/6/2021 0201
		assertFalse(this.urbana1.includesDate(LocalDateTime.of(2014, 7, 1, 2, 3), LocalDateTime.of(2014, 8, 20, 15, 15))); // del 1/4/2014 0203 a 20/8/2014 1515
		assertTrue(this.internacional1.includesDate(LocalDateTime.of(2020, 7, 21, 4, 50), LocalDateTime.of(2020, 7, 21, 22, 50)));
		assertFalse(this.internacional1.includesDate(LocalDateTime.of(2020, 7, 21, 4, 50), LocalDateTime.of(2020, 7, 21, 9, 57)));
		assertTrue(this.internacional1.includesDate(LocalDateTime.of(2020, 7, 21, 9, 58), LocalDateTime.of(2020, 7, 21, 10, 14)));
		assertTrue(this.internacional1.includesDate(LocalDateTime.of(2020, 7, 21, 10, 00), LocalDateTime.of(2020, 7, 21, 10, 14)));
	}
	
	@Test
	public void testCalcularMinutos() {
		assertEquals(8,this.internacional2.calcularMinutos(LocalDateTime.of(2020, 1, 3, 7, 15), LocalDateTime.of(2020, 1, 3, 7, 23)));
		assertEquals(14,this.urbana2.calcularMinutos(LocalDateTime.of(2014, 8, 21, 4, 1), LocalDateTime.of(2014, 8, 21, 4, 15)));
		assertEquals(0,this.local2.calcularMinutos(LocalDateTime.of(2013, 4, 4, 8, 14), LocalDateTime.of(2013, 5, 8, 7, 22)));
		assertEquals(5,this.local1.calcularMinutos(LocalDateTime.of(2021, 6, 15, 17, 5), LocalDateTime.of(2021, 6, 15, 17, 30)));
		assertEquals(16,this.internacional1.calcularMinutos(LocalDateTime.of(2020, 7, 21, 9, 58), LocalDateTime.of(2020, 7, 21, 10, 35)));
		assertEquals(1,this.urbana1.calcularMinutos(LocalDateTime.of(2021, 4, 20, 14, 0), LocalDateTime.of(2021, 4, 20, 14, 26)));
		assertEquals(15,this.urbana1.calcularMinutos(LocalDateTime.of(2021, 4, 20, 14, 0), LocalDateTime.of(2021, 4, 20, 15, 0)));
	}
	
	@Test
	public void testCalcularMonto() {
		assertEquals(5,this.local1.calcularMonto(this.local1.calcularMinutos(LocalDateTime.of(2021, 6, 15, 17, 5), LocalDateTime.of(2021, 6, 15, 17, 30)))); //entre las 17:05 y 17:30
		assertEquals(0,this.local2.calcularMonto(0));
		assertEquals(7,this.local2.calcularMonto(this.local2.calcularMinutos(LocalDateTime.of(2021, 6, 18, 17, 0), LocalDateTime.of(2021, 6, 18, 17, 25))));
		assertEquals(95,this.urbana1.calcularMonto(45));
		assertEquals(212,this.urbana2.calcularMonto(69));
		this.urbana1.setDistancia(420);
		assertEquals(217.5,this.urbana1.calcularMonto(85));
		assertEquals(32,this.urbana2.calcularMonto(this.urbana2.calcularMinutos(LocalDateTime.of(2014, 8, 21, 3, 57), LocalDateTime.of(2014, 8, 21, 4, 10))));
		assertEquals(64,this.internacional1.calcularMonto(this.internacional1.calcularMinutos(LocalDateTime.of(2020, 7, 21, 9, 50), LocalDateTime.of(2020, 7, 21, 10, 50)))); //16 mins precio diurno = 16*4 = 64
		assertEquals(24,this.internacional2.calcularMonto(this.internacional2.calcularMinutos(LocalDateTime.of(2020, 1, 2, 0, 0), LocalDateTime.of(2020, 1, 4, 0, 0)))); //8 minutos precio nocturno=8*3=24
		assertEquals(15,this.internacional2.calcularMonto(this.internacional2.calcularMinutos(LocalDateTime.of(2020, 1, 2, 0, 0), LocalDateTime.of(2020, 1, 3, 7, 20)))); //5 minutos precio nocturno=5*3=15
		this.internacional2.setFecha(LocalDateTime.of(2021, 8, 14, 19, 55)); // 5 minutos precio diurno, 10 nocturno
		this.internacional2.setDuracion(15);
		assertEquals(50,this.internacional2.calcularMonto(0)); //5*4 +10*3
		this.internacional1.setFecha(LocalDateTime.of(2021, 8, 20, 7, 58)); // 2 minutos precio nocturno, 10 precio diurno
		this.internacional1.setDuracion(12); 
		assertEquals(46,this.internacional1.calcularMonto(0)); //2*3 + 10*4
	}
}
