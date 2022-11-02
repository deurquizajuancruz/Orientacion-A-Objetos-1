package ar.edu.unlp.objetos.uno.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	private Sistema sis1;
	private Sistema sis2;
	private Sistema sis3;
	private PersonaFisica fisica;
	private PersonaJuridica juridica;
	
	@BeforeEach
	public void setUp() {
		this.sis1 = new Sistema();
		this.sis2 = new Sistema();
		this.sis3 = new Sistema();
		this.fisica = new PersonaFisica("Benjamin","Calle 2",2365,22);
		this.juridica = new PersonaJuridica("Dario","Calle 4",441,44,"SA");
	}
	
	@Test
	public void testNumeros() {
		this.sis1.agregarNumero(55236);
		assertEquals(1,this.sis1.getSizeNumeros());
		assertEquals(0,this.sis2.getSizeNumeros());
		this.sis3.agregarNumero(1);
		this.sis3.agregarNumero(2);
		this.sis3.agregarNumero(3);
		assertEquals(3,this.sis3.getSizeNumeros());
	}
	
	@Test
	public void testClientes() {
		assertEquals(0, this.sis1.getSizeClientes());
		this.sis2.agregarCliente(fisica);
		assertEquals(1,this.sis2.getSizeClientes());
		this.sis3.agregarCliente(juridica);
		this.sis3.agregarCliente(juridica);
		this.sis3.agregarCliente(fisica);
		assertEquals(3,this.sis3.getSizeClientes());
	}
	
	@Test
	public void testFacturarCliente() {
		assertNotNull(this.sis1.facturarCliente(fisica, LocalDateTime.of(2020, 4, 10, 10, 20), LocalDateTime.of(2020, 5, 10, 10, 30)));
		this.fisica.agregarLlamada(new LlamadaLocal(LocalDateTime.of(2020, 4, 20, 11, 30),20,11,22)); // $18
		this.juridica.agregarLlamada(new LlamadaInterurbana(LocalDateTime.of(2020, 4, 5, 4, 10),15,11,22,400)); // $42,5
		this.sis2.agregarCliente(this.juridica);
		this.sis2.agregarCliente(this.fisica);
		assertEquals(18,this.sis2.facturarCliente(this.fisica, LocalDateTime.of(2020, 4, 10, 10, 10), LocalDateTime.of(2020, 5, 10, 10, 10)).getMonto());
		assertEquals(42.5,this.sis2.facturarCliente(this.juridica, LocalDateTime.of(2020, 3, 10, 10, 10), LocalDateTime.of(2020, 5, 10, 10, 10)).getMonto());
		assertNotNull(this.sis3.facturarCliente(fisica, LocalDateTime.of(2022, 4, 14, 7, 50), LocalDateTime.of(2022, 5, 14, 7, 50)));
	}
	
	@Test
	public void testDarDeAltaPersona() {
		assertNull(this.sis3.darDeAltaPersonaFisica("Empresa", "Calle 1", 11));
		this.sis2.agregarNumero(150);
		assertNotNull(this.sis2.darDeAltaPersonaJuridica("Fabrica", "Avenida 1", 10, "Empresa"));
		this.sis1.agregarNumero(220);
		assertNotNull(this.sis1.darDeAltaPersonaFisica("Andrea", "Calle 1", 30));
	}
}
