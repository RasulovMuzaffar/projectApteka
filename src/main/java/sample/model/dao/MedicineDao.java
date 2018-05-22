package sample.model.dao;

import sample.model.pojo.Medicine;

import java.util.List;

public interface MedicineDao {
    List<Medicine> allMedicine();

    Medicine findById(int id);

    Medicine findByNameOrBarCode(String str);

    Medicine findByIdClass(int idClass);

    Medicine findByIdRecom(int idRecom);

    boolean insertMedicine(Medicine medicine);

    boolean updateMedicine(Medicine medicine);
}
