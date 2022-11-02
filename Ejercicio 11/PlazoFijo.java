package ar.edu.unlp.objetos.uno.ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaConstitucion, double depositado, double porcentaje) {
		this.fechaDeConstitucion=fechaConstitucion;
		this.montoDepositado=depositado;
		this.porcentajeDeInteresDiario=porcentaje > 1 ? porcentaje/100 : porcentaje;
	}
	
	@Override
	public double valorActual() {
		double diferencia = ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now());
		return this.montoDepositado + (this.porcentajeDeInteresDiario*diferencia*this.montoDepositado);
	}
}
