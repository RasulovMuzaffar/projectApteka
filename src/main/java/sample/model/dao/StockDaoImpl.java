package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {
    @Override
    public List<Stock> allStacks() {
        String query = "SELECT id, validity, price, quantity, place_storage, " +
                "sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer FROM stock";
        List<Stock> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(
                        new Stock(rs.getInt(1),
                                rs.getDate(2),
                                rs.getDouble(3),
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getDouble(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getInt(10)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Stock findById(int id) {
        Stock s = null;
        String query = "SELECT id, validity, price, quantity, place_storage, " +
                "sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer FROM stock WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Stock(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return s;
    }

    @Override
    public Stock findByIdMedicine(int idMedicine) {
        Stock s = null;
        String query = "SELECT id, validity, price, quantity, place_storage, " +
                "sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer FROM stock WHERE id_medicine = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idMedicine);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Stock(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return s;
    }

    @Override
    public Stock findByIdInvDoc(int idInvDoc) {
        Stock s = null;
        String query = "SELECT id, validity, price, quantity, place_storage, " +
                "sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer FROM stock WHERE id_invoice = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idInvDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Stock(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return s;
    }

    @Override
    public Stock findByIdManifacturer(int idManifacturer) {
        Stock s = null;
        String query = "SELECT id, validity, price, quantity, place_storage, " +
                "sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer FROM stock WHERE id_manifacturer = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idManifacturer);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Stock(rs.getInt(1),
                        rs.getDate(2),
                        rs.getDouble(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return s;
    }

    @Override
    public boolean insertStock(Stock stock) {
        String query = "INSERT INTO stock (validity, price, quantity, place_storage, sale_price, stock_balance, id_invoice, id_medicine, id_manifacturer)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setDate(1, new Date(stock.getValidaty().getTime()));
            ps.setDouble(2, stock.getPrice());
            ps.setInt(3, stock.getQuantity());
            ps.setString(4, stock.getPlaceStorage());
            ps.setDouble(5, stock.getSalePrice());
            ps.setInt(6, stock.getStockBalance());
            ps.setInt(7, stock.getIdInvoice());
            ps.setInt(8, stock.getIdMedicine());
            ps.setInt(9, stock.getIdManifacturer());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateStock(Stock stock) {
        String query = "UPDATE stock SET validity = ?, price = ?, quantity = ?, place_storage = ?, " +
                "sale_price = ?, stock_balance = ?, id_invoice = ?, id_medicine = ?, id_manifacturer = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setDate(1, new Date(stock.getValidaty().getTime()));
            ps.setDouble(2, stock.getPrice());
            ps.setInt(3, stock.getQuantity());
            ps.setString(4, stock.getPlaceStorage());
            ps.setDouble(5, stock.getSalePrice());
            ps.setInt(6, stock.getStockBalance());
            ps.setInt(7, stock.getIdInvoice());
            ps.setInt(8, stock.getIdMedicine());
            ps.setInt(9, stock.getIdManifacturer());
            ps.setInt(10, stock.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
