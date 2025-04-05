package Dao;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Payment;
import dbconn.DatabaseConnection;

public class PaymentDAO {
    public boolean processPayment(Payment payment) {
        String sql = "INSERT INTO payments1 (card_number, card_holder_name, amount) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, payment.getCardNumber());
            pstmt.setString(2, payment.getCardHolderName());
            pstmt.setDouble(3, payment.getAmount());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}