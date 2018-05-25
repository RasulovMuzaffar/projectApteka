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

public class StaffDaoImpl implements StaffDao {
//        private SessionFactory sessionFactory;
//    private Session session;
//    private Transaction transaction;
//
//    public StaffDaoImpl() {
//        session = new HibernateUtil().sessionFactory.openSession();
//        transaction = session.getTransaction();
//    }
//
//
//    @Override
//    public List<Staff> findAllStaffs() {
//        List<Staff> list = null;
//        try {
//            Query query = session.createQuery("FROM Staff", Staff.class);
//            list = query.list();
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return list;
//    }


    public List<Staff> allStaff() {
        String query = "SELECT id, first_name, last_name, " +
                "login, password, phone, email, role_id FROM spr_staff";
        List<Staff> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(
                        new Staff(rs.getInt(1),
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
    public Staff findStaffByLoginPassword(String login, String password) {
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
            System.out.println("Exception>>>>> " + e);
        }
        return staff;
    }

    @Override
    public Staff getStaffById(int id) {
        Staff staff = null;
        String query = "SELECT id, first_name, last_name, " +
                "login, password, phone, email, role_id FROM spr_staff where id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
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
            System.out.println("Exception>>>>> " + e);
        }
        return staff;
    }

    @Override
    public List<Staff> findStaffByRoleId(int id) {
        List<Staff> list = new ArrayList<>();
        String query = "SELECT id, first_name, last_name, " +
                "login, password, phone, email, role_id FROM spr_staff where role_id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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
            System.out.println("Exception>>>>> " + e);
        }

        return list;
    }

    @Override
    public boolean insertStaff(Staff staff) {
        String query = "INSERT INTO spr_staff (first_name, last_name, login, password, phone, email, role_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, staff.getFirstName());
            ps.setString(2, staff.getLastName());
            ps.setString(3, staff.getLogin());
            ps.setString(4, staff.getPassword());
            ps.setString(5, staff.getPhone());
            ps.setString(6, staff.getEmail());
            ps.setInt(7, staff.getIdRole());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        String query = "UPDATE spr_staff SET first_name = ?, last_name = ?, login = ?, password = ?, " +
                "phone = ?, email = ?, role_id = ? " +
                "WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, staff.getFirstName());
            ps.setString(2, staff.getLastName());
            ps.setString(3, staff.getLogin());
            ps.setString(4, staff.getPassword());
            ps.setString(5, staff.getPhone());
            ps.setString(6, staff.getEmail());
            ps.setInt(7, staff.getIdRole());
            ps.setInt(8, staff.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
