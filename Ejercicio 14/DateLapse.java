package ar.edu.unlp.objetos.uno.ejercicio14;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateLapse implements Lapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate f, LocalDate t) {
		this.from=f;
		this.to=t;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return (int)ChronoUnit.DAYS.between(from, to);
	}
	
	public boolean includesDate(LocalDate other) {
		return ((other.isEqual(from) || other.isAfter(from)) && (other.isEqual(to) || other.isBefore(to)));
	}
}
