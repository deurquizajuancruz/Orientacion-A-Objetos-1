package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateLapse{
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
		// si la nueva fecha es igual o esta despues que la fecha de inicio 
		//y la nueva fecha es igual o esta antes que la fecha de fin -> devuelve true 
	}
	
	public boolean overlaps(DateLapse another) {
		return !(another.to.isBefore(from) || another.to.isEqual(from) || 
				another.from.isAfter(to) || another.from.isEqual(to));
		// !(si el fin de la nueva esta despues del inicio de la vieja O
		// 	si el fin de la nueva es igual al inicio de la vieja O
		// si el inicio de la nueva es despues del final de la vieja O
		// si el inicio de la nueva es igual al final de la vieja)
	}
}
