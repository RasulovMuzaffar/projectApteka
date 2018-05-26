package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Suppler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplerDaoImpl implements SupplerDao {

    @Override
    public List<Suppler> getAllSupplers() {
        String query = "SELECT id, name, address, phone, email FROM spr_supplier ORDER BY id DESC";
        List<Suppler> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Suppler(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Suppler findSupplerById(int id) {
        String query = "SELECT id, name, address, phone, email FROM spr_supplier where id = ?";
        Suppler suppler = null;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                suppler = new Suppler(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return suppler;
    }

    @Override
    public boolean insertSuppler(Suppler suppler) {
        String query = "INSERT INTO spr_supplier (name, address, phone, email)" +
                " VALUES (?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, suppler.getName());
            ps.setString(2, suppler.getAddress());
            ps.setString(3, suppler.getPhone());
            ps.setString(4, suppler.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSuppler(Suppler suppler) {
        String query = "UPDATE spr_supplier SET name = ?, address = ?, phone = ?, email = ? " +
                "WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, suppler.getName());
            ps.setString(2, suppler.getAddress());
            ps.setString(3, suppler.getPhone());
            ps.setString(4, suppler.getEmail());
            ps.setInt(5, suppler.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
