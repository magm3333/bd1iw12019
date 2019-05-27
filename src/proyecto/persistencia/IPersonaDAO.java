package proyecto.persistencia;

import java.util.List;

import proyecto.modelo.Persona;

public interface IPersonaDAO {

	public List<Persona> list() throws PersistenciaExcption;

	public Persona add(Persona p) throws PersistenciaExcption;
}
