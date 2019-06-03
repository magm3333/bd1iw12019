import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {

		Connection c = JDBC1.getConnection("com.mysql.jdbc.Driver");

		try {
			PreparedStatement consulta=c.prepareStatement("SELECT * FROM zonas");
			PreparedStatement subConsulta=c.prepareStatement("SELECT COUNT(*) as cantidad FROM clientes WHERE idZona=?");
			
			long tiempoInicial=System.currentTimeMillis();
			ResultSet rs=consulta.executeQuery();
			long tiempoConsumido=System.currentTimeMillis()-tiempoInicial;
			System.out.println("IdZona\tZona");
			System.out.println("======\t===============");
			int filas=0;
			while(rs.next()) {
				subConsulta.setInt(1,rs.getInt("idZona"));
				ResultSet rsSC=subConsulta.executeQuery();
				rsSC.next();
				System.out.printf("%s \t %s \t (%s)%n",rs.getInt("idZona"),rs.getString("zona"),rsSC.getInt("cantidad"));
				filas++;
			}
			System.out.println("============================");
			System.out.println(filas+" filas.");
			System.out.println(tiempoConsumido+" milisegundos.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
}
