package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private String apellido;
	private int CUIL;
	private LocalDate nacimiento;
	private boolean hijos;
	private boolean conyuge;
	private LocalDate inicio;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int CUIL, LocalDate nacimiento, boolean hijos, boolean conyuge, LocalDate inicio) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.CUIL=CUIL;
		this.nacimiento=nacimiento;
		this.hijos=hijos;
		this.conyuge=conyuge;
		this.inicio=inicio;
		this.contratos=new ArrayList<Contrato>();
	}
	
	public int getCUIL(){
		return this.CUIL;
	}
	
	public boolean getHijos() {
		return this.hijos;
	}
	
	public boolean getConyuge() {
		return this.conyuge;
	}
	
	public int getSizeContratos() {
		return this.contratos.size();
	}
	
	public void setFechaInicio(LocalDate i) {
		this.inicio=i;
	}
	
	public void cargarContratoPorHoras(LocalDate i, double valorHora, double horasMes, LocalDate f) {
		if (this.inicio.isBefore(i) || this.inicio.isEqual(i)) {
			this.contratos.add(new ContratoPorHoras(i,valorHora,horasMes,f));
		}
	} // crear un contrato por horas y agregarlo a la coleccion
	
	public void cargarContratoDePlanta(LocalDate i, double sueldo, double montoConyuge, double montoHijos) {
		if (this.inicio.isBefore(i) || this.inicio.isEqual(i)) {
			this.contratos.add(new ContratoDePlanta(i,this,sueldo,montoConyuge,montoHijos));
		}
	} //crear un contrato de planta y agregarlo a la coleccion. Solo puede haber un contrato de planta
	
	public Contrato contratoUltimo() {
		if (this.contratos.size()==1) {
			return this.contratos.get(0);
		}
		return this.contratos.stream().max((c1,c2)->c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null);
	} // devuelve el contrato con la mayor fecha de inicio = ultimo contrato
	//	 si no hay contratos cargados devuelve null
	
	public boolean contratoVencido() {
		Contrato ultimo = this.contratoUltimo();
		if (ultimo==null) {
			return true;
		}
		return ultimo.vencido(); 
	}//fijarse si el empleado tiene un contrato vencido
	// Si ultimo=null (no hay contratos) devuelve true ya que no hay ningun contrato activo
	// si no es null, se fija si ese contrato si esta vencido llamando a vencido()
	// si tiene un contrato de planta: activo
	// si tiene contratos por horas: activo el que es posterior a la fecha actual
	
	public double calcularMonto() {
		if ( ! this.contratoVencido()) {
			return this.contratoUltimo().calcularMonto();
		}
		else return 0;
	}//calcular el monto a cobrar del contrato vigente para el recibo sin el bonus x antiguedad. Si no hay un contrato vigente/ si hay uno vencido devuelve 0
		
	public int calcularAntiguedad() {
		return this.contratos.stream().mapToInt(x->x.getDuracionAños()).sum();
	} //calcular todos los anios en que el empleado tuvo contratos y sumarlos para obtener la antiguedad
	
	public double bonusAntiguedad() {
		double antiguedad = this.calcularAntiguedad();
		if ((antiguedad>=5) && (antiguedad<10)) { // si tiene una antiguedad entre 5 y 9 se le suma 30%
			return 0.3;
		}
		else if ((antiguedad>=10) && (antiguedad<15)) { // si tiene una antiguedad entre 10 y 14 se le suma un 50%
			return 0.5;
		}
		else if ((antiguedad>=15) && (antiguedad<20)) { // si tiene una antiguedad entre 15 y 19 se le suma 70%
			return 0.7;
		}
		else if (antiguedad>=20) // si tiene una antiguedad mayor a 20 se le suma un 100%
			return 1;
		return 0;
	}
	
	public Recibo generarRecibo() {
		if ( ! this.contratoVencido()) { //si no tiene contrato vencido = tiene contrato activo
			return new Recibo(this,this.calcularAntiguedad(),this.calcularMonto() + this.calcularMonto()*this.bonusAntiguedad());
		}
		return null;
	}
}
