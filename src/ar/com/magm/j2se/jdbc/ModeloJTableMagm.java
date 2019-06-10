package ar.com.magm.j2se.jdbc;

import java.sql.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class ModeloJTableMagm implements TableModel {
    private ResultSet rs=null;
    

	@SuppressWarnings("rawtypes")
	Class [] colClass=null;
    String [] colLabels=null;
    
    public ModeloJTableMagm(ResultSet rs) {
        this.rs=rs;
		calcularDatosCol();
    }
    @SuppressWarnings("rawtypes")
	private void calcularDatosCol() {
        try {
            ResultSetMetaData rsM=rs.getMetaData();
            Class [] colClassT=new Class[rsM.getColumnCount()];
            String [] colLabelsT=new String[rsM.getColumnCount()];
            for (int t=0; t<colClassT.length; t++) {
                colClassT[t]=Class.forName(rsM.getColumnClassName(t+1));
                colLabelsT[t]=rsM.getColumnLabel(t+1);
            }
            colClass=colClassT;
            colLabels=colLabelsT;
        } catch (ClassNotFoundException e){
        } catch (SQLException e) {}
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int index) {   
        return colClass[index];
    }
    public int getColumnCount() {
        return colClass.length;
    }
    public String getColumnName(int index) {
        return colLabels[index];
    }
    public int getRowCount() {
        try{
            rs.last();
            return rs.getRow();
        } catch (SQLException e) {}
        return 0;
    }
    
    public Object getValueAt(int row, int col) {
        try {
            rs.absolute(++row);
            return rs.getObject(++col);
        } catch (SQLException e) {}
        return null;
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    public void removeTableModelListener(TableModelListener l) {
    }
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)  {
    }
    public void addTableModelListener(TableModelListener l) {
    }
	public ResultSet getRs() {
		return rs;
	}
}
