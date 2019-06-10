package ar.com.magm.j2se.jdbc.ejemplos;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.com.magm.j2se.jdbc.ModeloJTableResultSetMetaData;

public class ResultSetMetaDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private PanelResultados panelResultados = null;

	/**
	 * This is the default constructor
	 */
	public ResultSetMetaDatos(ModeloJTableResultSetMetaData modelo) {
		super();
		initialize();
		panelResultados.mostrar(modelo);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(623, 200);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("Meta Información");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanelResultados(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelResultados	
	 * 	
	 * @return ar.com.magm.j2se.jdbc.ejemplos.PanelResultados	
	 */
	private PanelResultados getPanelResultados() {
		if (panelResultados == null) {
			panelResultados = new PanelResultados();
			panelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
		}
		return panelResultados;
	}

}  //  @jve:decl-index=0:visual-constraint="10,-5"
