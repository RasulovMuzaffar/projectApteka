package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.ReceiptData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDataDaoImpl implements ReceiptDataDao {
    @Override
    public List<ReceiptData> allReceiptData() {
        List<ReceiptData> list = new ArrayList<>();
        String query = "SELECT id, quantity, price, id_receipt, id_stock FROM receipt_data";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new ReceiptData(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return list;
    }

    @Override
    public ReceiptData findById(int id) {
        ReceiptData rd = null;
        String query = "SELECT id, quantity, price, id_receipt, id_stock FROM receipt_data WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rd = new ReceiptData(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return rd;
    }

    @Override
    public boolean insertReceiptData(ReceiptData receiptData) {
        String query = "INSERT INTO receipt_data (id_receipt, id_stock, quantity, price)" +
                " VALUES (?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, receiptData.getIdReceipt());
            ps.setInt(2, receiptData.getIdStock());
            ps.setInt(3, receiptData.getQuantity());
            ps.setDouble(4, receiptData.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateReceiptData(ReceiptData receiptData) {
        String query = "UPDATE receipt_data SET quantity = ?, price = ?, id_receipt = ?, id_stock = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, receiptData.getQuantity());
            ps.setDouble(2, receiptData.getPrice());
            ps.setInt(3, receiptData.getIdReceipt());
            ps.setInt(4, receiptData.getIdStock());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}