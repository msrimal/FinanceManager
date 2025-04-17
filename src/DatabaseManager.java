import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:finance.db";

    public DatabaseManager() {
        createTable();
    }

    private void createTable() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "amount REAL, type TEXT, category TEXT, date TEXT)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTransaction(Transaction t) {
        String sql = "INSERT INTO transactions (amount, type, category, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, t.getAmount());
            pstmt.setString(2, t.getType());
            pstmt.setString(3, t.getCategory());
            pstmt.setString(4, t.getDate());  // Fixed typo here (was getData, should be getDate)
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";  // Fixed typo in the table name
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getDouble("amount"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getString("date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
