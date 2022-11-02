package ar.edu.unlp.objetos.uno.ejercicio14;

import java.time.*;

public interface Lapse {
	
	public abstract LocalDate getFrom();
	
	public abstract LocalDate getTo();
	
	public abstract int sizeInDays();
	
	public abstract boolean includesDate(LocalDate other);
}
