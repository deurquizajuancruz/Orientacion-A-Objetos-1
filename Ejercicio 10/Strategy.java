package ar.edu.unlp.objetos.uno.ejercicio10;

import java.util.*;
@FunctionalInterface
public interface Strategy {
	
	public abstract JobDescription next(List<JobDescription> jobs);
}
