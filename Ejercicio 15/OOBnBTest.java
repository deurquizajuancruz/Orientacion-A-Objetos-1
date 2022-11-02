package ar.edu.unlp.objetos.uno.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OOBnBTest {
	private OOBnB sistema1;
	private OOBnB sistema2;
	private DateLapse periodo1;
	private DateLapse periodo2;
	
	@BeforeEach
	public void setUp() {
		this.sistema1 = new OOBnB();
		this.sistema2 = new OOBnB();
		this.periodo1 = new DateLapse(LocalDate.of(2022, 1, 14), LocalDate.of(2022, 1, 20));
		this.periodo2 = new DateLapse(LocalDate.of(2020, 5, 10), LocalDate.of(2020, 6, 29));
	}
	
	@Test
	public void testRegistrarUsuarios() {
		assertEquals(0, this.sistema1.getSizeUsuarios());
		assertNotNull(this.sistema1.registrarUsuario("German", "Calle 9", 110));
		assertEquals(1,this.sistema1.getSizeUsuarios());
		assertNotNull(this.sistema2.registrarUsuario("Ana", "Avenida 2", 400));
		assertNotNull(this.sistema2.registrarUsuario("Maria", "Avenida 4", 500));
		assertNotNull(this.sistema2.registrarUsuario("Fernando", "Avenida 10", 700));
		assertEquals(3,this.sistema2.getSizeUsuarios());
	}
	
	@Test
	public void testGetPropiedadesDisponibles() {
		assertEquals(0,this.sistema1.getSizePropiedadesDisponibles(periodo1));
		this.sistema1.registrarUsuario("Camilo", "Calle 20", 400).registrarPropiedad("Propiedad de Camilo", "Buena fachada", "Avenida del Mar", 500);
		assertEquals(1,this.sistema1.getSizePropiedadesDisponibles(periodo1));
		this.sistema1.registrarUsuario("Alma", "Calle 25", 7100).registrarPropiedad("Propiedad de Alma", "Espaciosa", "Avenida del Mar", 750).hacerReserva(periodo1, new Usuario("Maria","Calle San Martin",120));
		assertEquals(1,this.sistema1.getSizePropiedadesDisponibles(new DateLapse(LocalDate.of(2022, 1, 10), LocalDate.of(2022, 1, 15))));		
		this.sistema2.registrarUsuario("Camilo", "Calle 20", 400).registrarPropiedad("Propiedad de Camilo", "Buena fachada", "Avenida del Mar", 500).hacerReserva(periodo1, new Usuario("German","Avenida del Cielo",114));
		assertEquals(0,this.sistema2.getSizePropiedadesDisponibles(periodo1));
		this.sistema2.registrarUsuario("Dario", "Calle 22", 550).registrarPropiedad("Propiedad de Dario", "Buena iluminacion", "Calle Belgrano", 600);
		assertEquals(2,this.sistema2.getSizePropiedadesDisponibles(periodo2));
	}
}
