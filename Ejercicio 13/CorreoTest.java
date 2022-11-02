package ar.edu.unlp.objetos.uno.ejercicio13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CorreoTest {
	private ClienteDeCorreo cliente1,cliente2;
	private Email e1,e2,e3;
	private Archivo a1,a2,a3;
	private Carpeta c1,c2;
	
	@BeforeEach
	public void setUp() {
		this.cliente1=new ClienteDeCorreo();
		this.cliente2=new ClienteDeCorreo();
		this.e1 = new Email("Comunicado","Informacion sobre la reunion"); //38
		this.e2 = new Email("Importante","Conferencia suspendida"); //32
		this.e3 = new Email("Aprovecha esta promo","Descuentos con la nueva tarjeta"); //51
		this.a1 = new Archivo("Cuentas"); //7
		this.a2 = new Archivo("Fotos"); //5
		this.a3 = new Archivo("Unidad 1");//8
		this.c1 = new Carpeta("Informacion Personal");
		this.c2 = new Carpeta("Facultad");
	}
	
	@Test
	public void testArchivo() {
		assertEquals(7,a1.tamaño());
		assertEquals("Cuentas",a1.getNombre());
		a1.setNombre("CuentaNueva");
		assertEquals("CuentaNueva",a1.getNombre());
		assertEquals(5,a2.tamaño());
	}
	
	@Test
	public void testEmail() {
		e1.agregarArchivo(a1);
		e1.agregarArchivo(a2);
		assertEquals(50,e1.tamaño());
		assertEquals(32,e2.tamaño());
		assertEquals(51,e3.tamaño());
		assertEquals(true,e1.buscar("Comunicado"));
		assertEquals(false,e1.buscar("z"));
	}
	
	@Test
	public void testCarpeta() {
		this.e1.agregarArchivo(a1); //+7
		this.e1.agregarArchivo(a1); //+7
		this.e2.agregarArchivo(a2); //+5
		this.e3.agregarArchivo(a3); //+8
		this.c1.agregarEmail(e1); //38+7+7
		this.c1.agregarEmail(e2); //32+5
		this.c1.agregarEmail(e3); //51+8
		this.c1.agregarEmail(e1); //38+7+7
		assertEquals(200,c1.espacioOcupado());
		this.c1.eliminarEmail(e1);
		this.c1.eliminarEmail(e1);
		assertEquals(96,c1.espacioOcupado());
		assertEquals(0,c2.espacioOcupado());
		assertNull(c2.buscar("A"));
		assertEquals(e2,c1.buscar("C"));
		assertNull(c1.buscar("z"));
	}
	
	@Test
	public void testCliente() {
		this.c2.agregarEmail(e1);
		this.cliente1.mover(e1, c2, c1);
		assertEquals(38,c1.espacioOcupado());
		this.c1.eliminarEmail(e1);
		this.e1.agregarArchivo(a1); //e1 = 38 + 7 = 45
		this.e2.agregarArchivo(a2); //e2 = 32 + 5 = 37
		this.e3.agregarArchivo(a3); //e3 = 51 + 8 = 59
		this.c1.agregarEmail(e1);//c1=45
		this.c2.agregarEmail(e2); //c2=37
		this.c1.agregarEmail(e3);//c1=45+59=104
		this.cliente1.agregarCarpeta(c1);
		this.cliente2.agregarCarpeta(c2);
		this.cliente2.recibir(e3); //cliente2=37+59=96
		assertEquals(e1,this.cliente1.buscar("C"));
		assertNull(this.cliente1.buscar("ZZZ"));
		assertEquals(e3,this.cliente2.buscar("D"));
		assertNull(this.cliente2.buscar("ZA"));
		assertEquals(104,this.cliente1.espacioOcupado());
		assertEquals(96,this.cliente2.espacioOcupado());
		// cliente 1 tiene carpeta 1 (e1,e1,e3)
		// cliente 2 tiene carpeta 2 (e2) y e3 en el inbox
	}
}
