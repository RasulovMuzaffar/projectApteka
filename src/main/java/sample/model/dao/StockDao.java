package sample.model.dao;

import sample.model.pojo.Stock;

import java.util.List;

public interface StockDao {
    List<Stock> allStacks();

    Stock findById(int id);

    Stock findByIdMedicine(int idMedicine);

    Stock findByIdInvDoc(int idInvDoc);

    Stock findByIdManifacturer(int idManifacturer);

    boolean insertStock(Stock stock);

    boolean updateStock(Stock stock);
}
