package ar.edu.unlp.objetos.uno.ejercicio15;

import java.util.*;
import java.util.stream.Collectors;

public class OOBnB {
    private List<Usuario> usuarios;
    
    public OOBnB() {
    	this.usuarios= new ArrayList<Usuario>();
    }
    
    public Usuario registrarUsuario(String n, String d, int dni) {
    	Usuario u = new Usuario(n,d,dni);
   	 	this.usuarios.add(u);
   	 	return u;
    } //registrar Usuarios
    
    public int getSizeUsuarios() {
    	return this.usuarios.size();
    }
    
    public List<Propiedad> getPropiedadesDisponibles(DateLapse periodo) {
    	return this.usuarios.stream().map(u->u.getPropiedadesDisponibles(periodo)).flatMap(m->m.stream()).collect(Collectors.toList());
    }
    // buscar propiedades disponibles en un periodo
    // unir todas las listas que devuelven los usuarios y devolverlas en una sola
    
    public int getSizePropiedadesDisponibles(DateLapse periodo) {
    	return this.usuarios.stream().map(u->u.getPropiedadesDisponibles(periodo)).flatMap(m->m.stream()).collect(Collectors.toList()).size();
    }
}
