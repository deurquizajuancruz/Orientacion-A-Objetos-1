package ar.edu.unlp.objetos.uno.ejercicio12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteTest {
	private ReporteDeConstruccion reporte1;
	private ReporteDeConstruccion reporte2;
	
	@BeforeEach
	public void setUp() {
		this.reporte1=new ReporteDeConstruccion();
		this.reporte2=new ReporteDeConstruccion();
	}
	@Test
	public void piezasVacias() {
		assertEquals(0,this.reporte1.getVolumenDeMaterial("Hierro"));
		assertEquals(0,this.reporte2.getVolumenDeMaterial("Plata"));
		assertEquals(0,this.reporte1.getSuperficieDeColor("Verde"));
		assertEquals(0,this.reporte2.getSuperficieDeColor("Rojo"));
	}
	
	@Test
	public void calculadoras() {
		Cilindro cilindro1=new Cilindro("Hierro","Gris",4,2); //area 150,8 volumen 100,53
		assertEquals(150.8,cilindro1.getSuperficie(),2);
		assertEquals(100.53,cilindro1.getVolumen(),2);
		Esfera esfera1=new Esfera("Hierro","Amarillo",5); //area 314,16 volumen 523,6
		assertEquals(314.16,esfera1.getSuperficie(),2);
		assertEquals(523.6,esfera1.getVolumen(),2);
		PrismaRectangular prisma1=new PrismaRectangular("Hierro","Rojo",4,3,7); // area 122 volumen 84
		assertEquals(122,prisma1.getSuperficie());
		assertEquals(84,prisma1.getVolumen());
	}
	
	@Test
	public void agregarPiezas() {
		Cilindro cilindro1=new Cilindro("Hierro","Gris",4,2); //area 150,8 volumen 100,53
		Cilindro cilindro2=new Cilindro("Plomo","Rojo",6,3); //area 339,29 volumen 339,23
		Esfera esfera1=new Esfera("Hierro","Amarillo",5); //area 314,16 volumen 523,6
		Esfera esfera2=new Esfera("Plata","Gris",4); // area 201,06 volumen 268,06
		PrismaRectangular prisma1=new PrismaRectangular("Hierro","Rojo",4,3,7); //area 122 volumen 84
		PrismaRectangular prisma2=new PrismaRectangular("Plata","Gris",5,2,6); // area 104 volumen 60
		this.reporte1.agregarPieza(cilindro1);
		this.reporte1.agregarPieza(cilindro2);
		this.reporte1.agregarPieza(esfera1);
		assertEquals(624.13,this.reporte1.getVolumenDeMaterial("Hierro"),2);
		assertEquals(339.23,this.reporte1.getVolumenDeMaterial("Plomo"),2);
		assertEquals(150.8,this.reporte1.getSuperficieDeColor("Gris"),2);
		assertEquals(339.29,this.reporte1.getSuperficieDeColor("Rojo"),2);
		assertEquals(314.16,this.reporte1.getSuperficieDeColor("Amarillo"),2);
		this.reporte2.agregarPieza(prisma1);
		this.reporte2.agregarPieza(prisma2);
		this.reporte2.agregarPieza(cilindro1);
		this.reporte2.agregarPieza(esfera2);
		assertEquals(455.86,this.reporte2.getSuperficieDeColor("Gris"),2);
		assertEquals(122,this.reporte2.getSuperficieDeColor("Rojo"),2);
		assertEquals(184.53,this.reporte2.getVolumenDeMaterial("Hierro"),2);
		assertEquals(328.06,this.reporte2.getVolumenDeMaterial("Plata"),2);
		
		/*Reporte 1 tiene:
		 * 2 hierro y 1 plomo
		 * 1 gris, 1 rojo y 1 amarillo
		 * Reporte 2 tiene:
		 * 2 hierro y 2 plata
		 * 3 gris y 1 rojo
		 */
		
	}
	
}
