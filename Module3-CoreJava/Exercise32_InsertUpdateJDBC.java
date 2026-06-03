import java.sql.*;

public class Exercise32_InsertUpdateJDBC {

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "password");
    }

    static void insertStudent(int id, String name) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO students(id, name) VALUES(?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("Inserted: " + name);
        conn.close();
    }

    static void updateStudent(int id, String newName) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE students SET name=? WHERE id=?");
        ps.setString(1, newName);
        ps.setInt(2, id);
        ps.executeUpdate();
        System.out.println("Updated ID " + id + " to " + newName);
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        insertStudent(1, "Alice");
        updateStudent(1, "Alice Johnson");
    }
}