import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class JDBC4 {

	public static void main(String[] args) {

		Connection c = JDBC1.getConnection("com.mysql.jdbc.Driver");

		try {
			PreparedStatement consulta=c.prepareStatement(args[0]);
			long tiempoInicial=System.currentTimeMillis();
			ResultSet rs=consulta.executeQuery();
			long tiempoConsumido=System.currentTimeMillis()-tiempoInicial;
			mostrarTitulo(rs);
			int filas=0;
			while(rs.next()) {
				 mostrarFila(rs);
				filas++;
			}
			System.out.println("============================");
			System.out.println(filas+" filas.");
			System.out.println(tiempoConsumido+" milisegundos.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void mostrarTitulo(ResultSet rs) throws SQLException {
		ResultSetMetaData md= rs.getMetaData();
		int t=0;
		for(int c=1; c<=md.getColumnCount();c++) {
			String linea=md.getColumnName(c) + " ";
			System.out.print(linea );
			t+=linea.length();
		}
		System.out.println();
		for(int i=0;i<t; i++) {
			System.out.print("=");
		}
		System.out.println();	}
	private static void mostrarFila(ResultSet rs) throws SQLException {
		ResultSetMetaData md= rs.getMetaData();
		for(int c=1; c<=md.getColumnCount();c++) {
			System.out.print(rs.getString(    md.getColumnName(c)  ) +" "  );
			
		}
		System.out.println();
		
		//System.out.printf("%s \t %s%n",rs.getInt("idZona"),rs.getString("zona"));		
	}
	
}
