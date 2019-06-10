package ejemplojlist;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EjemploJTable extends JFrame {
	private JTable tabla;
private JScrollPane scroll=new JScrollPane();
	
	public EjemploJTable() {
		setSize(400, 400);
		
		tabla=new JTable();
		scroll.setViewportView(tabla);
		tabla.setModel(new ModeloTabla());
		add(scroll);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new EjemploJTable();

	}

}
