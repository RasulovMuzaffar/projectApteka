package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {


    public List<Staff> allStaff() {
        String query = "SELECT id, first_name, last_name, " +
                "login, password, phone, email, role_id FROM spr_staff";
        Staff staff = new Staff();
        List<Staff> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Staff(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Staff getStaffByLoginPassword(String login, String password) {
        Staff staff = null;
        String query = "SELECT id, first_name, last_name, " +
                "login, password, phone, email, role_id FROM spr_staff where login = ? and password = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                staff = new Staff(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> "+e);
        }
        System.out.println("+++++ "+staff);
        return staff;
    }
}
