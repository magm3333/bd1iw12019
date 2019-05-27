import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {

		Connection c = getConnection(args[0]);

		try {
			Statement consulta=c.createStatement();
			
			long tiempoInicial=System.currentTimeMillis();
			ResultSet rs=consulta.executeQuery("SELECT * FROM zonas");
			long tiempoConsumido=System.currentTimeMillis()-tiempoInicial;
			System.out.println("IdZona\tZona");
			System.out.println("======\t===============");
			int filas=0;
			while(rs.next()) {
				System.out.printf("%s \t %s%n",rs.getInt("idZona"),rs.getString("zona"));
				filas++;
			}
			System.out.println("============================");
			System.out.println(filas+" filas.");
			System.out.println(tiempoConsumido+" milisegundos.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public static Connection getConnection(String driver) {
		Connection c = null;
		try {
			Class.forName(driver);
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practico", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}
}
