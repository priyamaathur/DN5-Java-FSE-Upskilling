import java.sql.*;

public class Exercise33_TransactionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            PreparedStatement debit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
            debit.setDouble(1, 500);
            debit.setInt(2, 1);
            debit.executeUpdate();

            PreparedStatement credit = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?");
            credit.setDouble(1, 500);
            credit.setInt(2, 2);
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transfer successful!");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}