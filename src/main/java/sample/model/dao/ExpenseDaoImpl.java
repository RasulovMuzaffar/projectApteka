package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Expense;
import sample.model.pojo.ExpenseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {
    @Override
    public List<Expense> allExpenses() {
        String query = "SELECT id, date, amount, description, id_exp_type, id_staff  FROM expense";
        List<Expense> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new Expense(rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Expense findExpenseById(int id) {
        String query = "SELECT id, date, amount, description, id_exp_type, id_staff FROM expense where id = ?";
        Expense exp = null;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                exp = new Expense(rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return exp;
    }

    @Override
    public List<Expense> findExpensesByIdStaff(int id) {
        String query = "SELECT id, date, amount, description, id_exp_type, id_staff FROM expense where id_staff = ?";
        List<Expense> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Expense(rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Expense> findExpensesByIdExpType(int id) {
        String query = "SELECT id, date, amount, description, id_exp_type, id_staff FROM expense where id_exp_type = ?";
        List<Expense> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Expense(rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Expense> findExpensesByBetweenDate(Timestamp oldDate,Timestamp currDate) {
        String query = "SELECT id, date, amount, description, id_exp_type, id_staff FROM expense where date BETWEEN ? and ?";
        List<Expense> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setTimestamp(1, oldDate);
            ps.setTimestamp(2, currDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Expense(rs.getInt(1),
                        rs.getTimestamp(2),
                        rs.getDouble(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    @Override
    public boolean insertExp(Expense exp) {
        String query = "INSERT expense (date, amount, description, id_exp_type, id_staff) " +
                "VALUES (?, ?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setDouble(2, exp.getAmount());
            ps.setString(3, exp.getDescription());
            ps.setInt(4, exp.getIdExpType());
            ps.setInt(5, exp.getIdStaff());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateExp(Expense exp) {
        String query = "UPDATE expense SET date = ?, amount = ?, description = ?, id_exp_type = ?, id_staff = ? " +
                "WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setTimestamp(1, exp.getDate());
            ps.setDouble(2, exp.getAmount());
            ps.setString(3, exp.getDescription());
            ps.setInt(4, exp.getIdExpType());
            ps.setInt(5, exp.getIdStaff());
            ps.setInt(6, exp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
