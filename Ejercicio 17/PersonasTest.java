package ar.edu.unlp.objetos.uno.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonasTest {
	private PersonaFisica fisica1;
	private PersonaFisica fisica2;
	private PersonaJuridica juridica1;
	private PersonaJuridica juridica2;
	private LlamadaLocal local;
	private LlamadaInterurbana urbana;
	private LlamadaInternacional internacional;
	
	@BeforeEach
	public void setUp() {
		this.fisica1 = new PersonaFisica("Ana","Calle 1",5521,11);
		this.fisica2 = new PersonaFisica("Benjamin","Calle 2",2365,22);
		this.juridica1 = new PersonaJuridica("Dario","Calle 4",441,44,"SA");
		this.juridica2 = new PersonaJuridica("Ernestina","Calle 5",5541,55,"Empresa");
		this.local = new LlamadaLocal(LocalDateTime.of(2021, 6, 15, 17, 4), 6, 221869894, 221147898);
		this.urbana = new LlamadaInterurbana(LocalDateTime.of(2021, 4, 20, 14, 25), 15, 30, 50, 99);
		this.internacional = new LlamadaInternacional (LocalDateTime.of(2021, 5, 3, 7, 15), 8, 410, 502,"Australia","Reino Unido");
	}
	
	@Test
	public void testNumeros() {
		assertEquals(2365,this.fisica2.getNumero());
		this.fisica2.setNumero(22365);
		assertEquals(22365,this.fisica2.getNumero());
		this.fisica1.agregarLlamada(this.local);
		assertEquals(1,this.fisica1.getSizeLlamadas());
		assertEquals(0,this.juridica1.getSizeLlamadas());
	}
	
	@Test
	public void testRegistrarLlamdas() {
		assertNotNull(this.fisica2.registrarLocal(LocalDateTime.of(2020, 5, 3, 3, 50), 20, 150, 1230));
		assertNotNull(this.juridica2.registrarInternacional(LocalDateTime.of(2021, 5, 12, 12, 12), 14, 552, 41, "Francia", "Alemania"));
		assertNotNull(this.juridica1.registrarInterurbana(LocalDateTime.of(2013, 7, 10, 10, 20), 10, 410, 220, 3000));
	}
	
	@Test
	public void testFacturar() {
		assertEquals(0,this.fisica2.facturar(LocalDateTime.of(2015, 10, 20, 20, 40), LocalDateTime.of(2015, 10, 21, 20, 40)));
		this.fisica1.agregarLlamada(internacional); // $24
		this.fisica1.agregarLlamada(local); // $6
		this.fisica1.agregarLlamada(urbana); //$35
		assertEquals(58.5,this.fisica1.facturar(LocalDateTime.of(2021, 1, 1, 10, 0), LocalDateTime.of(2021, 12, 15, 10, 0)));
		assertEquals(53.1,this.fisica1.facturar(LocalDateTime.of(2021, 4, 1, 0, 0), LocalDateTime.of(2021, 6, 1, 0, 0))); // este periodo solo incluye a la llamada urbana($35) e internacional($24)
		assertEquals(0,this.fisica1.facturar(LocalDateTime.of(2022, 1, 1, 10, 0), LocalDateTime.of(2022, 12, 15, 10, 0)));
		this.juridica1.agregarLlamada(internacional); //$24
		this.juridica1.agregarLlamada(internacional); //$24
		this.juridica1.agregarLlamada(internacional); //$24
		this.juridica1.agregarLlamada(local); // $6
		assertEquals(78,this.juridica1.facturar(LocalDateTime.of(2021, 1, 1, 10, 0), LocalDateTime.of(2021, 12, 15, 10, 0)));
		assertEquals(72,this.juridica1.facturar(LocalDateTime.of(2021, 1, 1, 10, 0), LocalDateTime.of(2021, 5, 15, 10, 0)));
		assertEquals(0,this.juridica2.facturar(LocalDateTime.of(2013, 1, 1, 10, 0), LocalDateTime.of(2013, 12, 15, 10, 0)));
	}
}
