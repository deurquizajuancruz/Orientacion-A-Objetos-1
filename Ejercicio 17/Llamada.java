package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Llamada {
	private LocalDateTime fecha;
	private double duracion;
	private long nroReceptor;
	private long nroLlamador;
	
	public Llamada(LocalDateTime f, double d, long r, long l) {
		this.fecha=f;
		this.duracion=d;
		this.nroReceptor=r;
		this.nroLlamador=l;
	}
	
	public abstract double calcularMonto(double minutos);
	
	public double getDuracion() {
		return this.duracion;
	}
	
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	
	public void setFecha(LocalDateTime f) {
		this.fecha=f;
	}
	
	public void setDuracion(double d) {
		this.duracion=d;
	}
	
	public boolean includesDate(LocalDateTime i, LocalDateTime f) {
		LocalDateTime finllamada = this.fecha.plusMinutes((long) this.getDuracion());
		return !(f.isBefore(this.fecha) || f.isEqual(this.fecha) || 
				i.isAfter(finllamada) || i.isEqual(finllamada));
	}
	
	public double calcularMinutos(LocalDateTime i, LocalDateTime f) {
		LocalDateTime finllamada = this.fecha.plusMinutes((long) this.getDuracion());
		if (f.isBefore(fecha)) {
			return 0;
		}
		else if (finllamada.isBefore(i)) {
			return 0;
		}
		else {
			LocalDateTime mayor;
			LocalDateTime menor;
			if (i.isBefore(fecha)) {
				mayor = fecha;
			}
			else {
				mayor=i;
			}
			if (f.isAfter(finllamada)) {
				menor=finllamada;
			}
			else {
				menor = f;
			}
			return ChronoUnit.MINUTES.between(mayor, menor);
		}
	}// calcular los minutos de la llamada en el periodo dado
}
