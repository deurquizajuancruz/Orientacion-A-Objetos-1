package ar.edu.unlp.objetos.uno.ejercicio15;

import java.time.LocalDate;

public class Reserva {
    private DateLapse periodo;
    private Propiedad propiedad;
    private Usuario inquilino;
    
    public Reserva(DateLapse p, Propiedad prop, Usuario u) {
    	this.periodo=p;
    	this.propiedad=prop;
    	this.inquilino=u;
    }
    
    public double calcularPrecio(DateLapse p) {
    	if (p.getTo().isBefore(this.periodo.getFrom())) {
    		return 0;
    	} // si del periodo que quiero saber la fecha final esta antes del inicio de la reserva, no se superponen -> el usuario no tiene ingresos en ese periodo
    	else if (this.periodo.getTo().isBefore(p.getFrom())) {
    		return 0; 
    	} // si del periodo de la reserva el final esta antes que la fecha de inicio del periodo que quiero saber, tampoco de superponen -> el usuario no tiene ingresos en ese periodo
    	else {
    		LocalDate mayor;
    		LocalDate menor;
    		if (p.getFrom().isBefore(this.periodo.getFrom())) {
    			mayor = this.periodo.getFrom();
    		}
    		else {
    			mayor = p.getFrom();
    		}
    		if (p.getTo().isAfter(this.periodo.getTo())) {
    			menor = this.periodo.getTo();
    		}
    		else {
    			menor = p.getTo();
    		}
    		DateLapse superponen = new DateLapse(mayor,menor);
    		return superponen.sizeInDays() * this.propiedad.getPrecioPorNoche();
    	}
    } // calcular precio de una reserva
    
    public Usuario getInquilino() {
    	return this.inquilino;
    }
    
    public boolean realizadaEn(DateLapse another) {
    	return this.periodo.overlaps(another);
    } // hacer una reserva
    
    public void eliminarReserva(Reserva eliminar) {
    	if (this.periodo.getFrom().isAfter(LocalDate.now())) {
    		this.inquilino.eliminarReserva(eliminar);
    		this.propiedad.eliminarReserva(eliminar);
    	}
    } // eliminar reserva
    
    public double cancelarReserva(LocalDate fechaCancelacion) {
    	double monto = this.calcularPrecio(this.periodo);
    	return this.propiedad.cancelarReserva(monto,fechaCancelacion,this.periodo.getFrom());
    } // cancelar reserva
}

