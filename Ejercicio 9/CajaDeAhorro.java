package ar.edu.unlp.objetos.uno.ejercicio9;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	protected boolean puedeExtraer(double monto) {
		if (super.getSaldo()>monto + monto/100*2) {
			return true;
		}
		else {
			return false;
		}
	}
}
