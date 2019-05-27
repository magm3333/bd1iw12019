package proyecto.negocio;

import java.util.List;

import proyecto.modelo.Persona;
import proyecto.persistencia.PersistenciaExcption;

public interface IPersonaNegocio {
	public List<Persona> list() throws NegocioExcption;

	public Persona add(Persona p) throws NegocioExcption;
}
