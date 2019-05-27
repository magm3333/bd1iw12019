package proyecto.modelo;

import java.io.Serializable;

public class Persona implements Serializable {
	private int dni;
	private String nombre;

	@Override
	public boolean equals(Object obj) {
		Persona p = (Persona) obj;
		return p.getDni() == getDni();
	}
	public Persona() {
	}

	public Persona(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return String.format("DNI: %s, Nombre: %s", getDni(),getNombre());
	}
}
