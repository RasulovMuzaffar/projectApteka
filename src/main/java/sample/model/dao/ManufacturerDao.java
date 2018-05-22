package sample.model.dao;

import sample.model.pojo.Manufacturer;

import java.util.List;

public interface ManufacturerDao {
    List<Manufacturer> allManufacturer();

    Manufacturer findById(int id);

    boolean insertManufacturer(Manufacturer manufacturer);

    boolean updateManufacturer(Manufacturer manufacturer);
}
