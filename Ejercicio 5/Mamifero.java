package ar.edu.unlp.objetos.uno.ejercicioo5;

public class Mamifero {
	private String identificador;
	private String especie;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero () {
		
	}
	
	public Mamifero (String ID) {
		setIdentificador(ID);
	}
	
	public void setPadre(Mamifero unPadre) {
		padre = unPadre;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setMadre(Mamifero unaMadre) {
		madre = unaMadre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (madre!=null) {
			return madre.getMadre();
		}
		else return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (madre!=null) {
			return madre.getPadre();
		}
		else return null;
	}

	public Mamifero getAbuelaPaterna() {
		if (padre!=null) {
			return padre.getMadre();
		}
		else return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (padre!=null) {
			return padre.getPadre();
		}
		else return null;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	/*public Boolean tieneComoAncestroA(Mamifero M) {
		if (this.padre!=null) {
			if (this.padre==M) {
				return true;
			}
			if (padre.tieneComoAncestroA(M)) return true;
		}
		if (this.madre!=null) {
			if (this.madre==M) {
				return true;
			}
			return this.madre.tieneComoAncestroA(M);
		}
		return false;
	}*/
	
	public Boolean tieneComoAncestroA(Mamifero M) {
		return  (this.padre!=null && this.padre==M) 
		|| (this.madre!=null && this.madre==M)
		|| (this.madre!=null && this.madre.tieneComoAncestroA(M))
		|| (this.padre!=null && this.padre.tieneComoAncestroA(M));
	}
}
