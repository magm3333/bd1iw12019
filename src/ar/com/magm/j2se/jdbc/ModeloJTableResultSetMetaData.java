package ar.com.magm.j2se.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModeloJTableResultSetMetaData implements TableModel {

	private ResultSetMetaData md=null;
	private String titulos[]=new String[]
	        {"Nro","Nombre","Label","Clase",
			 "Tipo SQL","Tabla","Identidad",
			 "Anulable","Solo Lectura","Escribible"};
	private String datos[][]=null;
	
	public ModeloJTableResultSetMetaData(ResultSet rs) {
		try {
			md=rs.getMetaData();
			datos=new String[md.getColumnCount()][10];
			
			//Calcular Datos
			
			for (int t=0; t<md.getColumnCount(); t++) {
				datos[t][0]=String.valueOf(t);
				datos[t][1]=md.getColumnName(t+1);
				datos[t][2]=md.getColumnLabel(t+1);
				datos[t][3]=md.getColumnClassName(t+1);
				datos[t][4]=md.getColumnTypeName(t+1);
				datos[t][5]=md.getTableName(t+1);
				datos[t][6]=md.isAutoIncrement(t+1)?"Si":"No";
				datos[t][7]=md.isNullable(t+1)==0 ? "Si" : (md.isNullable(t+1)==1?"No":"Desconocido") ;
				datos[t][8]=md.isReadOnly(t+1)?"Si":"No";
				datos[t][9]=md.isWritable(t+1)?"Si":"No";
				
			}
			
		} catch (SQLException e) {}
	}
	public int getRowCount() {
		int rows=0;
		try {
			rows= md.getColumnCount();
		} catch (SQLException e) {
		} catch (Exception e) {}
		return rows;
	}

	public int getColumnCount() {
		return 10;
	}

	public String getColumnName(int col) {
		return titulos[col];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int arg0) {
		return String.class;
	}

	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public Object getValueAt(int f, int c) {
		return datos[f][c];
	}

	public void setValueAt(Object arg0, int arg1, int arg2) {

	}

	public void addTableModelListener(TableModelListener arg0) {
	}

	public void removeTableModelListener(TableModelListener arg0) {
	}

}
