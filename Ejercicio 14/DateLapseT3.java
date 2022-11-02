package ar.edu.unlp.objetos.uno.ejercicio14;

import java.time.*;

public class DateLapseT3 implements Lapse{
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapseT3(LocalDate f, int s) {
		this.from=f;
		this.sizeInDays=s;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(sizeInDays);
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}
	
	public boolean includesDate(LocalDate other) {
		return ((other.isEqual(from) || other.isAfter(from)) && (other.isEqual(this.getTo()) || other.isBefore(this.getTo())));
	}
}
