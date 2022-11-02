package ar.edu.unlp.objetos.uno.ejercicio10;

import java.util.*;

public class LIFO implements Strategy{

	public JobDescription next(List<JobDescription> jobs) {
		return jobs.get(jobs.size()-1);
	}
}
