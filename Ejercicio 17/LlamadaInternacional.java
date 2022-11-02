package ar.edu.unlp.objetos.uno.Ejercicio17;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LlamadaInternacional extends Llamada{
	private String origen;
	private String destino;
	
	public LlamadaInternacional(LocalDateTime f, double d, long r, long l, String o, String des) {
		super(f,d,r,l);
		this.origen=o;
		this.destino=des;
	}
	
	public double calcularMonto(double m) {
		LocalDateTime inicio = this.getFecha();
		LocalDateTime finllamada = this.getFecha().plusMinutes((long)this.getDuracion());
		if ((inicio.getHour()<8) && (finllamada.getHour()>=8)) { //si empieza en el horario nocturno y termina en el diurno
			double minNocturno=0,minDiurno=0;
			while (inicio.getHour()<8) {
				minNocturno++;
				inicio=inicio.plusMinutes(1);
			}
			minDiurno=ChronoUnit.MINUTES.between(inicio, finllamada);
			return minNocturno*3 + minDiurno*4;
		}
		else if ((inicio.getHour()<20) &&  (finllamada.getHour()>=20)) { // si empieza en el horario diurno y termina en el nocturno
			double minAntes=0,minDespues=0;
			while (inicio.getHour()<20) {
				minAntes++;
				inicio=inicio.plusMinutes(1);
			}
			minDespues=ChronoUnit.MINUTES.between(inicio, finllamada);
			return minAntes*4 + minDespues*3;
		}
		else if ((inicio.getHour()>=8) && (finllamada.getHour()<20)) { // si esta entre las 8:00 y 19:59
			return m*4;
		}
		else // si esta entre las 20:00 y 7:59
			return m*3;
	}
}
