import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() {

        String url = "jdbc:mysql://localhost:3306/auladb";
        String user = "root";
        String password = "";
 
        try {
            // carregar driver do mysql
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conected!");

            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver not found");
        } catch (SQLException e) {
            System.out.println("Erro: Connection failed!");
            e.printStackTrace();
        }

        return null;
    }

}
