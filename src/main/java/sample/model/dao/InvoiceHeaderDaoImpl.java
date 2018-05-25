package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.InvoiceHeader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceHeaderDaoImpl implements InvoiceHeaderDao {
    @Override
    public List<InvoiceHeader> findAll() {
        String query = "SELECT id, numb, date, id_supplier, id_staff, input_date FROM invoice_header";
        List<InvoiceHeader> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(
                        new InvoiceHeader(rs.getInt(1),
                                rs.getString(2),
                                rs.getDate(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getTimestamp(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public InvoiceHeader findById(int id) {
        InvoiceHeader ih = null;
        String query = "SELECT id, numb, date, id_supplier, id_staff, input_date FROM invoice_header where id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ih = new InvoiceHeader(rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getTimestamp(6));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return ih;
    }

    @Override
    public boolean insertInvHead(InvoiceHeader invoiceHeader) {
        String query = "INSERT INTO invoice_header (numb, date, id_supplier, id_staff)" +
                " VALUES (?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, invoiceHeader.getNumb());
            ps.setDate(2, new Date(invoiceHeader.getDate().getTime()));
            ps.setInt(3, invoiceHeader.getIdSuppler());
            ps.setInt(4, invoiceHeader.getIdStaff());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateInvHead(InvoiceHeader invoiceHeader) {
        String query = "UPDATE invoice_header SET numb = ?, date = ?, id_supplier = ?, id_staff = ?, " +
                "input_date = ? WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, invoiceHeader.getNumb());
            ps.setDate(2, (Date) invoiceHeader.getDate());
            ps.setInt(3, invoiceHeader.getIdSuppler());
            ps.setInt(4, invoiceHeader.getIdStaff());
            ps.setTimestamp(5, invoiceHeader.getInputDate());
            ps.setInt(6, invoiceHeader.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<InvoiceHeader> findByIdSupplier(int idSupplier) {
        String query = "SELECT id, numb, date, id_supplier, id_staff, input_date FROM invoice_header where id_supplier = ?";
        List<InvoiceHeader> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idSupplier);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                        new InvoiceHeader(rs.getInt(1),
                                rs.getString(2),
                                rs.getDate(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getTimestamp(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<InvoiceHeader> findByIdStaff(int idStaff) {
        String query = "SELECT id, numb, date, id_supplier, id_staff, input_date FROM invoice_header where id_staff = ?";
        List<InvoiceHeader> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idStaff);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                        new InvoiceHeader(rs.getInt(1),
                                rs.getString(2),
                                rs.getDate(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getTimestamp(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<InvoiceHeader> findByDate(Timestamp d1, Timestamp d2) {
        String query = "SELECT id, numb, date, id_supplier, id_staff, input_date FROM invoice_header where input_date BETWEEN ? and ?";
        List<InvoiceHeader> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setTimestamp(1, d1);
            ps.setTimestamp(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                        new InvoiceHeader(rs.getInt(1),
                                rs.getString(2),
                                rs.getDate(3),
                                rs.getInt(4),
                                rs.getInt(5),
                                rs.getTimestamp(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
