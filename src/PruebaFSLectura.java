import java.util.List;

import proyecto.modelo.Persona;
import proyecto.negocio.IPersonaNegocio;
import proyecto.negocio.NegocioExcption;
import proyecto.negocio.PersonaNegocio;

public class PruebaFSLectura {

	public static void main(String[] args) {
		IPersonaNegocio pDAO = new PersonaNegocio();

		try {
			List<Persona> lista = pDAO.list();
			for (Persona p : lista)
				System.out.println(p);
			System.out.println(lista.size() + " personas en la lista");
		} catch (NegocioExcption e) {

			e.printStackTrace();
		}

	}

}
