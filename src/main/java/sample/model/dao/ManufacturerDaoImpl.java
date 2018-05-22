package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ManufacturerDaoImpl  implements ManufacturerDao{
    @Override
    public List<Manufacturer> allManufacturer() {
        List<Manufacturer> list = null;
        String query = "SELECT id, state, name FROM spr_manufacturer";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Manufacturer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return list;
    }

    @Override
    public Manufacturer findById(int id) {
        Manufacturer m = null;
        String query = "SELECT id, state, name FROM spr_manufacturer WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Manufacturer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return m;
    }

    @Override
    public boolean insertManufacturer(Manufacturer manufacturer) {
        String query = "INSERT INTO spr_manufacturer (state, name)" +
                " VALUES (?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, manufacturer.getState());
            ps.setString(2, manufacturer.getName());
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateManufacturer(Manufacturer manufacturer) {
        String query = "UPDATE spr_manufacturer SET state = ?, name = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, manufacturer.getState());
            ps.setString(2, manufacturer.getName());
            ps.setInt(3, manufacturer.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
