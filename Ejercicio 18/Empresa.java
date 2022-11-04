package ar.edu.unlp.objetos.uno.Ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Empleado> empleados;
	
	public Empresa() {
		this.empleados= new ArrayList<Empleado>();
	}
	
	public int getSizeEmpleados() {
		return this.empleados.size();
	}
		
	public void darDeAlta(String n, String a, int c, LocalDate nac, boolean hijos, boolean conyuge) {
		this.empleados.add(new Empleado(n,a,c,nac,hijos,conyuge,LocalDate.now()));
	} //crear empleado y sumarlo a la lista
	
	public Empleado buscarEmpleado(int CUIL) {
		if (! this.empleados.isEmpty()) { //si hay empleados
			return this.empleados.stream().filter(x->x.getCUIL()==CUIL).findAny().orElse(null); //si algun empleado tiene ese CUIL lo devuelve, si ninguno lo tiene devuelve null
		}
		else return null; //si no hay empleados
	} //buscar empleado en la lista y devolverlo
	
	public void darDeBaja(Empleado despedido) {
		if (! this.empleados.isEmpty()) {
			this.empleados.remove(despedido);
		}
	} //eliminar empleado de la empresa
	
	public List<Empleado> contratosVencidos(){
		return this.empleados.stream().filter(x->x.contratoVencido()).collect(Collectors.toList());
	} //devolver en una lista todos los empleados con contratos actuales (fecha de inicio mas reciente) con contrato vencido(cuando la fecha de fin es <=fecha actual)
	
	public List<Recibo> recibosSueldo(){
		return this.empleados.stream().map(x->x.generarRecibo()).filter(r->r!=null).collect(Collectors.toList());
	}//devolver una lista de recibos de todos los empleados activos
	//recorrer toda la lista de empleados, fijarse cual esta activo, generar recibo para cada empleado activo y devolver una lista con todos esos recibos
}
