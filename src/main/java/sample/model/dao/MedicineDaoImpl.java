package sample.model.dao;

import sample.database.DatabaseHandler;
import sample.model.pojo.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {
    @Override
    public List<Medicine> allMedicine() {
        String query = "SELECT id, name_ru, name_en, bar_code, " +
                "id_class, id_recomend FROM spr_medicine";
        List<Medicine> list = new ArrayList<>();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                list.add(
                        new Medicine(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
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
    public Medicine findById(int id) {
        Medicine m = null;
        String query = "SELECT id, name_ru, name_en, bar_code, " +
                "id_class, id_recomend FROM spr_medicine WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Medicine(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return m;
    }

    @Override
    public Medicine findByNameOrBarCode(String str) {
        String q = "%" + str + "%";
        Medicine m = null;
        String query = "SELECT id, name_ru, name_en, bar_code, " +
                "id_class, id_recomend" +
                " FROM spr_medicine WHERE concat_ws(' ', name_ru, name_en, bar_code) LIKE ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Medicine(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return m;
    }

    @Override
    public Medicine findByIdClass(int idClass) {
        Medicine m = null;
        String query = "SELECT id, name_ru, name_en, bar_code, " +
                "id_class, id_recomend FROM spr_medicine WHERE id_class = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idClass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Medicine(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return m;
    }

    @Override
    public Medicine findByIdRecom(int idRecom) {
        Medicine m = null;
        String query = "SELECT id, name_ru, name_en, bar_code, " +
                "id_class, id_recomend FROM spr_medicine WHERE id_recomend = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, idRecom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                m = new Medicine(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Exception>>>>> " + e);
        }
        return m;
    }

    @Override
    public boolean insertMedicine(Medicine medicine) {
        String query = "INSERT INTO spr_medicine (name_ru, name_en, bar_code, id_class, id_recomend)" +
                " VALUES (?, ?, ?, ?, ?)";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, medicine.getNameRu());
            ps.setString(2, medicine.getNameEn());
            ps.setString(3, medicine.getBarCode());
            ps.setInt(4, medicine.getIdClass());
            ps.setInt(5, medicine.getIdRecommend());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateMedicine(Medicine medicine) {
        String query = "UPDATE spr_medicine SET name_ru = ?, name_en = ?, bar_code = ?," +
                " id_class = ?, id_recomend = ?" +
                " WHERE id = ?";
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try (Connection connection = databaseHandler.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setString(1, medicine.getNameRu());
            ps.setString(2, medicine.getNameEn());
            ps.setString(3, medicine.getBarCode());
            ps.setInt(4, medicine.getIdClass());
            ps.setInt(5, medicine.getIdRecommend());
            ps.setInt(5, medicine.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
