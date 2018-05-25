package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.ReceiptHeader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReceiptHeaderDaoImpl implements ReceiptHeaderDao {
    @Override
    public List<ReceiptHeader> allReceiptHeader() {
        List<ReceiptHeader> list = new ArrayList<>();
        String query = "SELECT id, number, date, id_staff, id_user FROM receipt_header";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new ReceiptHeader(rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return list;
    }

    @Override
    public ReceiptHeader findById(int id) {
        ReceiptHeader r = null;
        String query = "SELECT id, number, date, id_staff, id_user FROM receipt_header WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new ReceiptHeader(rs.getInt(1),
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return r;
    }

    @Override
    public boolean insertReceiptHeader(ReceiptHeader receiptHeader) {
        String query = "INSERT INTO receipt_header (number, id_staff)" +
                " VALUES (?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, receiptHeader.getNumber());
            ps.setInt(2, receiptHeader.getIdStaff());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateReceiptHeader(ReceiptHeader receiptHeader) {
        String query = "UPDATE receipt_header SET number = ?, date = ?, id_staff = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, receiptHeader.getNumber());
            ps.setTimestamp(2, receiptHeader.getDate());
            ps.setInt(3, receiptHeader.getIdStaff());
            ps.setInt(4, receiptHeader.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public int maxSize() {
        int number=1;
        String query = "SELECT MAX(number) FROM receipt_header";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                number += rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return number;
    }


}
