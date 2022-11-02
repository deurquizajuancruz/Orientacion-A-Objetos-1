package ar.edu.unlp.objetos.uno.ejercicio7;

public class ProgramaPrincipal {
	public static void main(String[] args) {
		
		Gerente alan = new Gerente(" Alan Turing " );
		double aportesDeAlan = alan.aportes();
		Gerente alan2 = new Gerente("Alan Turing");
		double sueldoBasicoDeAlan = alan2.sueldoBasico();
		System.out.println(aportesDeAlan);
		System.out.println(sueldoBasicoDeAlan);
	}
}
