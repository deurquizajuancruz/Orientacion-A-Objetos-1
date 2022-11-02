package ar.edu.unlp.objetos.uno.ejercicio10;

import java.util.*;

public class JobScheduler {
	private Strategy strategy;
	private List<JobDescription> jobs;
	
	public JobScheduler() {
		this.jobs=new ArrayList<JobDescription>();
	}
	
	public List<JobDescription> getJobs() {
		return this.jobs;
	}
	
	public void schedule(JobDescription job) {
		this.jobs.add(job);
	}
	
	public void unschedule(JobDescription job) {
		if (job!=null) {
			this.jobs.remove(job);
		}
	}
	
	public JobDescription next() {
		JobDescription nextJob = this.strategy.next(this.jobs);
		this.unschedule(nextJob);
		return nextJob;
	}
	
	public void setStrategy(Strategy s) {
		this.strategy=s;
	}
}
