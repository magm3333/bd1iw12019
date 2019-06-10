package ar.com.magm.j2se.jdbc;

import java.sql.*;

import javax.swing.*;
public class ConexionBD {
	
	private Connection cn=null;
	private ResultSet rs=null;
	private String mensaje=null;
	private ModeloJTableMagm modelo=null; 
	private boolean abierta=true;
	
	public ConexionBD(){
		this(null,null);
	}
	
	
	public ConexionBD(String driver){
		this(driver,null);
	}
	
	public ConexionBD(String driver, String url){
		if (driver==null)
			driver="";
		if (url==null)
				url="";
		DatosConexionGUI dg=new DatosConexionGUI(driver, url);
		dg.setVisible(true);
		driver=dg.getDriver();
		url=dg.getUrl();
		dg.dispose(); 
		if (url.equals("-") || driver.equals("-")) {
			abierta=false;
			return;
		}
		if (url.equals("") || driver.equals("")) {
			JOptionPane.showMessageDialog(null,"Debe especificar todos los datos");
			abierta=false;
			return;
		}
		if (!conectar(driver,url)) {
			abierta=false;
			JOptionPane.showMessageDialog(null,"No se pudo establecer la conexión\nCausa: "+mensaje);
		}
	}
	private boolean conectar(String driver, String url) {
		boolean res=false;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			mensaje=e1.getMessage();
		}
		try {
			cn=DriverManager.getConnection(url);
			res=true;
		} catch (SQLException e) {
			mensaje=e.getMessage(); 
		}
		return res;
	}	
	public boolean ejecutar(String instruccion) {
		boolean res=false;
		try {
			Statement stm=cn.createStatement();
			if (stm.execute(instruccion)){
				rs=stm.getResultSet();
				modelo=new ModeloJTableMagm(rs);
				mensaje=null;
			} else {
				rs=null;
				modelo=null;
				mensaje=stm.getUpdateCount()+ " filas afectadas";
			res=true;
			}
		} catch (SQLException e) {
			mensaje="Error: " + e.getMessage() + " - Code=" + e.getErrorCode() + " - SQLState=" + e.getSQLState();   
		}
		return res;
	} 
	

	public Connection getConexion() {
		return cn;
	}
	public String getMensaje() {
		return mensaje;
	}
	public ModeloJTableMagm getModeloJTable() {
		return modelo;
	}
	public void utilizarTransacciones( boolean utilizar ) {
		try {
			cn.setAutoCommit(!utilizar );
		} catch (SQLException e) {}
	}
	
	public void confirmarTransaccion() {
		try {
			if (!cn.getAutoCommit())
				cn.commit();
		} catch (SQLException e) {}
	}
	public void retrotraerTransaccion() {
		try {
			if (!cn.getAutoCommit())
				cn.rollback();
		} catch (SQLException e) {}
	}

	public boolean isAbierta() {
		return abierta;
	}
	
}
