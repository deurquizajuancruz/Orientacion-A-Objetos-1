package ar.edu.unlp.objetos.uno.ejercicio10;

import java.util.*;

public class FIFO implements Strategy{
	
	public JobDescription next(List<JobDescription> jobs) {
		return jobs.get(0);
	}
}
