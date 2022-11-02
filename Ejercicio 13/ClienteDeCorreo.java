package ar.edu.unlp.objetos.uno.ejercicio13;

import java.util.*;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox= new Carpeta("Inbox");
		this.carpetas=new ArrayList<Carpeta>();
	}
	
	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		origen.eliminarEmail(email);
		destino.agregarEmail(email);		
	}
	
	public Email buscar(String texto) {
		if (this.inbox.buscar(texto)!=null) {
			return this.inbox.buscar(texto);
		}
		else {
			return this.carpetas.stream().map(c->c.buscar(texto)).filter(c-> c!=null).findFirst().orElse(null);
		}
	}
	
	public int espacioOcupado() {
		return this.inbox.espacioOcupado() + this.carpetas.stream().mapToInt(c->c.espacioOcupado()).sum();
	}
}	
