package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Recomendation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecomendationDaoImpl implements RecomendationDao {
    @Override
    public List<Recomendation> allRecom() {
        List<Recomendation> list = new ArrayList<>();
        String query = "SELECT id, recomendation FROM recomendations";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Recomendation(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return list;
    }

    @Override
    public Recomendation findById(int id) {
        Recomendation r = null;
        String query = "SELECT id, recomendation FROM recomendations WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new Recomendation(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return r;
    }

    @Override
    public boolean insertRecom(Recomendation recomendation) {
        String query = "INSERT INTO recomendations (recomendation)" +
                " VALUES (?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, recomendation.getText());
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRecom(Recomendation recomendation) {
        String query = "UPDATE recomendations SET recomendation = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, recomendation.getText());
            ps.setInt(2, recomendation.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
