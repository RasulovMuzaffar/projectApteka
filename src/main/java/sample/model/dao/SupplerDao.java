package sample.model.dao;

import sample.model.pojo.Suppler;

import java.util.List;

public interface SupplerDao {
    List<Suppler> getAllSupplers();

    Suppler findSupplerById(int id);

    boolean insertSuppler(Suppler suppler);

    boolean updateSuppler(Suppler suppler);
}
