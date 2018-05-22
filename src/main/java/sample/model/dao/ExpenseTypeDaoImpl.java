package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.ExpenseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTypeDaoImpl implements ExpenseTypeDao {
    @Override
    public List<ExpenseType> allExpenseType() {
        String query = "SELECT id, name, description FROM spr_expense_type";
        List<ExpenseType> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(new ExpenseType(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public ExpenseType findExpTypeById(int id) {
        String query = "SELECT id, name, description FROM spr_expense_type where id = ?";
        ExpenseType expType = null;
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                expType = new ExpenseType(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return expType;
    }

    @Override
    public boolean insertExpType(ExpenseType exp) {
        String query = "INSERT spr_expense_type (name, description) VALUES (?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, exp.getName());
            ps.setString(2, exp.getDescription());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateExpType(ExpenseType exp) {
        String query = "UPDATE spr_expense_type SET name = ?, description = ? " +
                "WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, exp.getName());
            ps.setString(2, exp.getDescription());
            ps.setInt(3, exp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
