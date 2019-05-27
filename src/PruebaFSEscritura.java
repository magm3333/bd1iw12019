import java.util.List;
import java.util.Scanner;

import proyecto.modelo.Persona;
import proyecto.negocio.IPersonaNegocio;
import proyecto.negocio.NegocioExcption;
import proyecto.negocio.PersonaNegocio;

public class PruebaFSEscritura {

	public static void main(String[] args) {
		IPersonaNegocio pDAO = new PersonaNegocio();

		try {
			Scanner s=new Scanner(System.in);
			boolean bandera=true;
			while (bandera) {
				System.out.print("Ingrese DNI (-1 para salir): ");
				int dni=s.nextInt();
				if(dni==-1) {
					bandera=false;
				}else {
					System.out.print("Ingrese Nombre: ");
					s.nextLine();
					String nombre=s.nextLine();
					Persona p=new Persona(dni,nombre);
					pDAO.add(p);
				}
			}
			System.out.println("================================================");
			List<Persona> lista = pDAO.list();
			for (Persona p : lista)
				System.out.println(p);
			System.out.println(lista.size() + " personas en la lista");
		} catch (NegocioExcption e) {

			e.printStackTrace();
		}

	}

}
