package ar.edu.unlp.objetos.uno.ejercicio9;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente() {
		super();
		this.descubierto=0;
	}
	
	protected boolean puedeExtraer(double monto) {
	if (super.getSaldo()-monto<this.descubierto) { //si el saldo que tenemos - el monto es menor al limite, no se puede extraer
			return false; //si tenemos $100 y queremos extraer $400, hacemos 100 - 400 = -300. 
		} //suponemos que descubierto=-200. Si -300 es menor a -200, no podemos extraer
		else {
			return true; //si tenemos $100 y queremos extraer $120, hacemos 100 - 120 = -20. 
		} //suponemos que descubierto=-200. Si -120 es mayor a -200, podemos extraer
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) { //limite de descubierto (negativo) que tiene el cliente
		this.descubierto=descubierto;
	}
}
