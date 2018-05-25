package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Classification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassificationDaoImpl implements ClassificationDao {
    @Override
    public List<Classification> allClassification() {
        List<Classification> list = new ArrayList<>();
        String query = "SELECT id, name FROM spr_classification";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Classification(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return list;
    }

    @Override
    public Classification findById(int id) {
        Classification c = null;
        String query = "SELECT id, name FROM spr_classification WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Classification(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return c;
    }

    @Override
    public boolean insertClf(Classification classification) {
        String query = "INSERT INTO spr_classification (name)" +
                " VALUES (?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, classification.getName());
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateClf(Classification classification) {
        String query = "UPDATE spr_classification SET name = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, classification.getName());
            ps.setInt(2, classification.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
