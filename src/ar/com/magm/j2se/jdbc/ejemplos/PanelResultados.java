package ar.com.magm.j2se.jdbc.ejemplos;
import javax.swing.JPanel;
import javax.swing.table.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import ar.com.magm.j2se.jdbc.*;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class PanelResultados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane contTabla = null;
	private JScrollPane contTexto = null;
	private JTable tabla = null;
	private JTextArea texto = null;
	private JPopupMenu popMetaData = null;
	private JMenuItem mnuMasInfo = null;
	private ConexionBD cn=null;

	/**
	 * This is the default constructor
	 */
	public PanelResultados() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(300, 200);
		this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Salida", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, null, null));
		this.add(getJScrollPane(), java.awt.BorderLayout.NORTH);
		this.add(getJScrollPane1(), java.awt.BorderLayout.CENTER);
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (contTabla == null) {
			contTabla = new JScrollPane();
			contTabla.setVisible(false);
			contTabla.setViewportView(getTabla());
		}
		return contTabla;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (contTexto == null) {
			contTexto = new JScrollPane();
			contTexto.setVisible(true);
			contTexto.setViewportView(getTexto());
		}
		return contTexto;
	}

	/**
	 * This method initializes tabla	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabla() {
		if (tabla == null) {
			tabla = new JTable();
			tabla.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mouseReleased(java.awt.event.MouseEvent e) {    
					showPop(e);
				}
				public void mousePressed(java.awt.event.MouseEvent e) {
					showPop(e);
				}
				private void showPop( java.awt.event.MouseEvent me ) {
					if ( me.isPopupTrigger( ) ) {
						getPopMetaData().show( me.getComponent(), me.getX(), me.getY() );
					}
				}
			});
		}
		return tabla;
	}

	/**
	 * This method initializes texto	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTexto() {
		if (texto == null) {
			texto = new JTextArea();
			texto.setEditable(false);
			texto.setWrapStyleWord(true);
			texto.setLineWrap(true);
			texto.setRows(0);
		}
		return texto;
	}
	
	public void mostrar(ConexionBD cn) {
		if (cn.getModeloJTable()==null)
			showTexto(cn.getMensaje());
		else{
			this.cn=cn;
			showResultados(cn.getModeloJTable() );
		}
		
	}
	public void mostrar(TableModel modelo) {
		showResultados(modelo);
	}
	
	private void showTexto(String txt) {
		getTexto().setText(txt);
		contTabla.setVisible(false);
		contTexto.setVisible(true);
		contTexto.updateUI();
		updateUI();
	}
	private void showResultados(TableModel modelo) {
		getTabla().setModel(modelo);
		getTabla().updateUI(); 
		contTabla.setVisible(true);
		contTexto.setVisible(false);
		contTabla.updateUI();
		updateUI();
	}

	/**
	 * This method initializes popMetaData	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getPopMetaData() {
		if (popMetaData == null) {
			popMetaData = new JPopupMenu();
			popMetaData.add(getMnuMasInfo());
		}
		return popMetaData;
	}

	/**
	 * This method initializes mnuMasInfo	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getMnuMasInfo() {
		if (mnuMasInfo == null) {
			mnuMasInfo = new JMenuItem();
			mnuMasInfo.setText("Más información");
			mnuMasInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new ResultSetMetaDatos(new ModeloJTableResultSetMetaData(cn.getModeloJTable().getRs())).setVisible(true);
				}
			});
		}
		return mnuMasInfo;
	}
}
