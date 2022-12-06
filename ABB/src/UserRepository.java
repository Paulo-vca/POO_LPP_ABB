import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    // DAO = DATA ACCESS OBJETC => Antigamente
    // DAO => CRUD =>
    // C > CREATE (INSERT INTO)
    // R > READ (SELECT FROM)
    // U > UPDATE (UPDATE SET)
    // D > DELETE (DELETE FROM)

    private Connection conn = null;

    public UserRepository() {
        // nao tratar exeções no construtor
        this.conn = ConnectionFactory.createConnection();
    }

    public void save(User _user) {
        String uSql = "INSERT INTO tb_user (username, password, status, token) VALUES (?, ?, ?, ?)";
        try {
            // pre compilada
            // instrução sql pre-estabelecidas
            PreparedStatement ps = conn.prepareStatement(uSql);
            ps.setString(1, _user.getUsername());
            ps.setString(2, _user.getPassword());
            ps.setInt(3, _user.getStatus());
            ps.setDouble(4, _user.getToken());

            // insert,update e delete
            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: Não foi possivel inserir o usuário");
            e.printStackTrace();
        }
    }

    public List<User> getActiveUsers() {

        List<User> activeUsers = new ArrayList<User>();

        String sql = "SELECT * FROM tb_user WHERE status = 1";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { // buscar
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStatus(rs.getInt("status"));
                u.setToken(rs.getDouble("token"));
                activeUsers.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Erro: Não foi possível encontar um usuario ativo!");
            e.printStackTrace();
        }

        return activeUsers;

    }

    public User getOne(int id) {
        String sql = "SELECT * FROM tb_user WHERE id = ?";
        User u = new User(); // istanciar objeto

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // buscar
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStatus(rs.getInt("status"));
                u.setToken(rs.getDouble("token"));
            }
            return u;

        } catch (SQLException ps) {
            System.out.println("Erro:");
        }

        return null;
    }
    // fazer hojee

    public List<User> selectAll() {
        String sql = "SELECT * FROM tb_user";

        List<User> users = new ArrayList<User>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();// retorna um conjunto resultados - varios

            while (rs.next()) { // buscar
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStatus(rs.getInt("status"));
                u.setToken(rs.getDouble("token"));
                System.out.println(
                        rs.getInt(1) + " - " +
                                rs.getString("username") + " - " +
                                rs.getString("password"));
            }

            System.out.println(rs);

        } catch (SQLException e) {
            System.out.println("Erro: Não foi possivel buscar os usuários");
            e.printStackTrace();
        }

        return users;

    }

    public boolean update(User _user) {
        String sql = "UPDATE tb_user SET username = ?, password = ?, status = ?, token = ? WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, _user.getUsername());
            ps.setString(2, _user.getPassword());
            ps.setInt(3, _user.getStatus());
            ps.setDouble(4, _user.getToken());

            ps.setInt(5, _user.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean delete(int id) {

        String sql = "DELETE FROM tb_user WHERE id = ?";
        // String sql = "UPDAte set tb_user FROM tb_user WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro: Não foi possivel buscar/deletar os usuario!!!");
            e.printStackTrace();
        }

        return false;
    }

}
