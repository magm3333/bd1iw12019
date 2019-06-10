package ar.com.magm.j2se.jdbc.ejemplos;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ar.com.magm.j2se.jdbc.ConexionBD;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class EditorSQL extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JCheckBox usarTransacciones = null;
	private JButton btnCommit = null;
	private JButton btnRollback = null;
	private JScrollPane jScrollPane = null;
	private JTextArea sqlText = null;
	private JButton btnEjecutar = null;
	private JButton btnEjecutarNuevo = null;
	private PanelResultados panelResultados = null;
	
	private ConexionBD con=null;
	/**
	 * This is the default constructor
	 */
	public EditorSQL() {
		super();
		initialize();
		if (!con.isAbierta()) 
			dispose();
		else
			setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 374);
		this.setContentPane(getJContentPane());
		this.setTitle("JavaQuery");
		
		
		con = new ConexionBD("com.mysql.jdbc.Driver","jdbc:mysql://localhost/practico?user=root&password=root");
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridwidth = 3;
			gridBagConstraints4.insets = new java.awt.Insets(3,0,3,0);
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.fill = java.awt.GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.insets = new java.awt.Insets(0,0,0,3);
			gridBagConstraints3.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints21.insets = new java.awt.Insets(0,3,0,3);
			gridBagConstraints21.gridy = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints11.weighty = 0.1;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridwidth = 3;
			gridBagConstraints11.insets = new java.awt.Insets(0,0,3,0);
			gridBagConstraints11.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 2;
			gridBagConstraints2.fill = java.awt.GridBagConstraints.VERTICAL;
			gridBagConstraints2.insets = new java.awt.Insets(0,3,0,0);
			gridBagConstraints2.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints2.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.fill = java.awt.GridBagConstraints.VERTICAL;
			gridBagConstraints1.insets = new java.awt.Insets(0,3,0,0);
			gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints1.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints.gridy = 2;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getUsarTransacciones(), gridBagConstraints);
			jContentPane.add(getBtnCommit(), gridBagConstraints1);
			jContentPane.add(getBtnRollback(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints11);
			jContentPane.add(getBtnEjecutar(), gridBagConstraints21);
			jContentPane.add(getBtnEjecutarNuevo(), gridBagConstraints3);
			jContentPane.add(getPanelResultados(), gridBagConstraints4);
		}
		return jContentPane;
	}

	/**
	 * This method initializes usarTransacciones	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getUsarTransacciones() {
		if (usarTransacciones == null) {
			usarTransacciones = new JCheckBox();
			usarTransacciones.setText("Activar Transacciones");
			usarTransacciones.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					getBtnCommit().setEnabled(getUsarTransacciones().isSelected());
					getBtnRollback().setEnabled(getUsarTransacciones().isSelected());
					con.utilizarTransacciones(getUsarTransacciones().isSelected());
				}
			});
		}
		return usarTransacciones;
	}

	/**
	 * This method initializes btnCommit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCommit() {
		if (btnCommit == null) {
			btnCommit = new JButton();
			btnCommit.setText("Confirmar");
			btnCommit.setEnabled(false);
			btnCommit.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					con.confirmarTransaccion();
				}
			});
		}
		return btnCommit;
	}

	/**
	 * This method initializes btnRollback	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRollback() {
		if (btnRollback == null) {
			btnRollback = new JButton();
			btnRollback.setText("Retrotraer");
			btnRollback.setEnabled(false);
			btnRollback.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					con.retrotraerTransaccion();
				}
			});
		}
		return btnRollback;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Instrucci\u00F3n", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
			jScrollPane.setViewportView(getSqlText());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes sqlText	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getSqlText() {
		if (sqlText == null) {
			sqlText = new JTextArea();
			sqlText.setRows(5);
			sqlText.setLineWrap(true);
			sqlText.setWrapStyleWord(true);
			sqlText.setPreferredSize(new java.awt.Dimension(10,80));
			sqlText.addKeyListener(new java.awt.event.KeyAdapter() {   
				public void keyTyped(java.awt.event.KeyEvent e) {
					byte b=(byte)e.getKeyChar();
					if (e.isControlDown() && b==10)
						ejecutar();
				}
			});
		}
		return sqlText;
	}

	/**
	 * This method initializes btnEjecutar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnEjecutar() {
		if (btnEjecutar == null) {
			btnEjecutar = new JButton();
			btnEjecutar.setText("Ejecutar");
			btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ejecutar();
				}
			});
		}
		return btnEjecutar;
	}

	/**
	 * This method initializes brnEjecutarNuevo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnEjecutarNuevo() {
		if (btnEjecutarNuevo == null) {
			btnEjecutarNuevo = new JButton();
			btnEjecutarNuevo.setText("Ejecutar en nuevo panel");
			btnEjecutarNuevo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ejecutar(true);
				}
			});
		}
		return btnEjecutarNuevo;
	}

	/**
	 * This method initializes panelResultados	
	 * 	
	 * @return PanelResultados	
	 */
	private PanelResultados getPanelResultados() {
		if (panelResultados == null) {
			panelResultados = new PanelResultados();
		}
		return panelResultados;
	}
	private void ejecutar(boolean nuevoPanel) {
		/*try {
			if (stm.execute( getSqlText().getText())) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
	private void ejecutar() {
		String texto=getSqlText().getText().trim();
		if (texto.equals("") || texto.length()==0)
			return;
		if (getSqlText() !=null && getSqlText().getSelectedText()!=null && getSqlText().getSelectedText().length()!=0)
			texto=getSqlText().getSelectedText();
		
		con.ejecutar(texto);
		panelResultados.mostrar(con); 		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
