package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Role;
import sample.model.pojo.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> allRoles() {
        StaffDao sd = new StaffDaoImpl();

        String query = "SELECT id, role FROM spr_role";
        List<Role> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Role(rs.getInt("id"),
                        rs.getString("role")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


    @Override
    public Role findRoleById(int id) {
        String query = "SELECT id, role FROM spr_role WHERE  id = ?";
        Role role = null;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return role;
    }
}
