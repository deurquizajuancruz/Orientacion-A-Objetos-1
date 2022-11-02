package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private long numero;
	private List<Llamada> llamadas;
	
	public Persona(String n, String d, long num) {
		this.nombre=n;
		this.direccion=d;
		this.numero=num;
		this.llamadas= new ArrayList<Llamada>();
	}
	
	public double getSizeLlamadas() {
		return this.llamadas.size();
	}
	
	public long getNumero() {
		return this.numero;
	}
	
	public void setNumero(long num) {
		this.numero=num;
	}
	
	public void agregarLlamada(Llamada l) {
		this.llamadas.add(l);
	}
	
	public LlamadaLocal registrarLocal(LocalDateTime f, double duracion, long llamador, long recibe) {
		LlamadaLocal l = new LlamadaLocal(f,duracion,recibe,llamador);
		agregarLlamada(l);
		return l;
	}
	
	public LlamadaInternacional registrarInternacional(LocalDateTime f, double duracion, long llamador, long recibe, String origen, String destino) {
		LlamadaInternacional l = new LlamadaInternacional(f,duracion,recibe,llamador,origen,destino);
		agregarLlamada(l);
		return l;
	}
	
	public LlamadaInterurbana registrarInterurbana(LocalDateTime f, double duracion, long llama, long recibe, double distancia) {
		LlamadaInterurbana l = new LlamadaInterurbana(f,duracion,recibe,llama,distancia);
		agregarLlamada(l);
		return l;
	}
	
	public double facturar(LocalDateTime inicio, LocalDateTime fin) {
		return this.llamadas.stream().filter(x->x.includesDate(inicio, fin)).mapToDouble(x->x.calcularMonto(x.calcularMinutos(inicio, fin))).sum();
	};
}
