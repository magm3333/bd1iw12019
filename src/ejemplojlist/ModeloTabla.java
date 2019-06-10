package ejemplojlist;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class ModeloTabla implements TableModel {

	@Override
	public int getRowCount() {
		return 1000;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {

		return "c"+columnIndex;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return  String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		return "c"+columnIndex+",f"+rowIndex;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		System.out.printf("Valor=%s, f=%s,c=%s%n",aValue,rowIndex,columnIndex);

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
