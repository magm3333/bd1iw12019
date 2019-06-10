package ar.com.magm.j2se.jdbc;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatosConexionGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JTextField driverTxt = null;
	private JTextField urlTxt = null;
	private JButton btnOk = null;
	private JButton btnCancelar = null;
	private String driver=null;
	private String url=null;
	private JPanel jPanel = null;
	/**
	 * This is the default constructor
	 */
	public DatosConexionGUI(String driver, String url) {
		super();
		this.driver=driver;
		this.url=url;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 187);
		this.setModal(true);
		this.setTitle("Datos de conexión");
		this.setContentPane(getJContentPane());
		getDriverTxt().setText(driver);
		getUrlTxt().setText(url);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.anchor = java.awt.GridBagConstraints.EAST;
			gridBagConstraints11.insets = new java.awt.Insets(20,0,0,0);
			gridBagConstraints11.gridy = 4;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new java.awt.Insets(0,5,0,5);
			gridBagConstraints3.gridwidth = 1;
			gridBagConstraints3.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new java.awt.Insets(0,5,0,5);
			gridBagConstraints2.gridwidth = 1;
			gridBagConstraints2.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints1.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("URL BD:");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Driver:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(jLabel1, gridBagConstraints1);
			jContentPane.add(getDriverTxt(), gridBagConstraints2);
			jContentPane.add(getUrlTxt(), gridBagConstraints3);
			jContentPane.add(getJPanel(), gridBagConstraints11);
		}
		return jContentPane;
	}

	/**
	 * This method initializes driver	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDriverTxt() {
		if (driverTxt == null) {
			driverTxt = new JTextField();
		}
		return driverTxt;
	}

	/**
	 * This method initializes url	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getUrlTxt() {
		if (urlTxt == null) {
			urlTxt = new JTextField();
		}
		return urlTxt;
	}

	/**
	 * This method initializes btnOk	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("Aceptar");
			btnOk.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);				}
			});
		}
		return btnOk;
	}

	/**
	 * This method initializes btnCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					driver="-";
					url="-";
					setVisible(false);
				}
			});
		}
		return btnCancelar;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.add(getBtnOk(), null);
			jPanel.add(getBtnCancelar(), null);
		}
		return jPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
