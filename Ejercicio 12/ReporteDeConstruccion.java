package ar.edu.unlp.objetos.uno.ejercicio12;

import java.util.*;

public class ReporteDeConstruccion {
	private List<Pieza> piezas=new ArrayList<Pieza>();
	
	public void agregarPieza(Pieza p) {
		this.piezas.add(p);
	}
	
	public double volumenDeMaterial(String material) {
		return 0;
	}
	public double superficieDeColor(String color) {
		return 0;
	}
	
	public double getVolumenDeMaterial(String nombreDeMaterial) {
		return this.piezas.stream().filter((Pieza p)->p.getMaterial()==nombreDeMaterial).mapToDouble((Pieza p)->p.getVolumen()).sum();
		/*
		 * Recorrer toda la lista, todo los que cumplan que su material=nombreDeMaterial, se suma su volumen
		 Recibe como parámetro un nombre de material (un string, por ejemplo 'Hierro'). 
		 Retorna la suma de los volúmenes de todas las piezas hechas en ese material 
		 */
	}
	
	public double getSuperficieDeColor(String unNombreDeColor) {
		return this.piezas.stream().filter((Pieza p)->p.getColor()==unNombreDeColor).mapToDouble((Pieza p)->p.getSuperficie()).sum();
		/*
		 * Recibe como parámetro un color (un string, por ejemplo 'Rojo'). 
		 * Retorna la suma de las superficies externas de todas las piezas pintadas con ese color.
		 */
	}
	
}
