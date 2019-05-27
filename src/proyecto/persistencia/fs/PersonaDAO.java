package proyecto.persistencia.fs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import proyecto.modelo.Persona;
import proyecto.persistencia.IPersonaDAO;
import proyecto.persistencia.PersistenciaExcption;

public class PersonaDAO implements IPersonaDAO {

	@Override
	public List<Persona> list() throws PersistenciaExcption {
		List<Persona> lista=new ArrayList<Persona>();
		Scanner s=null;
		try {
			s=new Scanner(forRead()) ;
			while(s.hasNextLine()) {
				String linea=s.nextLine();
				String columnas[]=linea.split(";");
				Persona p=new Persona(Integer.parseInt(columnas[0]),columnas[1] );
				lista.add(p);
			}
		} catch (IOException e) {
			throw new PersistenciaExcption(e);
		} finally {
			if(s!=null)
				s.close();
		}

		return lista;
	}

	@Override
	public Persona add(Persona p) throws PersistenciaExcption {
		PrintWriter pr=null;
		try {
			 pr=new PrintWriter(forWrite());
			 pr.println(p.getDni()+";"+p.getNombre());
			 pr.flush();
			 return p;
		} catch (IOException e) {
			throw new PersistenciaExcption(e);
		} finally {
			if(pr!=null)
				pr.close();
		}
		

	}
	
	private static String ARCHIVO="datos.txt"; 
	private InputStream forRead() throws IOException {
		File f=aseguraArchivo();
		return new FileInputStream(f);
		
	}
	private OutputStream forWrite() throws IOException {
		File f=aseguraArchivo();
		return new FileOutputStream(f,true);
		
	}
	
	private File aseguraArchivo() throws IOException {
		File f=new File(ARCHIVO);
		if(!f.exists() || !f.isFile()) {
			f.createNewFile();
		}
		return f;
	}
	

}
