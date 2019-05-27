package proyecto.negocio;

import java.util.List;

import proyecto.modelo.Persona;
import proyecto.persistencia.IPersonaDAO;
import proyecto.persistencia.PersistenciaExcption;
import proyecto.persistencia.fs.PersonaDAO;

public class PersonaNegocio implements IPersonaNegocio {

	private IPersonaDAO pDAO = new PersonaDAO();
	
	@Override
	public List<Persona> list() throws NegocioExcption {
		try {
			return pDAO.list();
		} catch (PersistenciaExcption e) {
			throw new NegocioExcption(e);
		}
	}

	@Override
	public Persona add(Persona p) throws NegocioExcption {
		try {
			return pDAO.add(p);
		} catch (PersistenciaExcption e) {
			throw new NegocioExcption(e);
		}
	}

}
