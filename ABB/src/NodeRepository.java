import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NodeRepository {

    private Connection conn = null;

    public NodeRepository() {
        // nao tratar exeções no construtor
        this.conn = ConnectionFactory.createConnection();
    }

    public void save(Node _node) {

        String nSql = "INSERT INTO node (info) VALUES (?)";
        try {
            // pre compilada
            // instrução sql pre-estabelecidas
            PreparedStatement ps = conn.prepareStatement(nSql);
            ps.setInt(1, _node.getInfo());

            // insert,update e delete
            ps.executeUpdate();

            System.out.println("No inserido");

        } catch (SQLException e) {
            System.out.println("Error: Não foi possivel inserir o usuário");
            e.printStackTrace();
        }
    }

}
