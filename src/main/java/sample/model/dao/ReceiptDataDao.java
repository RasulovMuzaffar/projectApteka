package sample.model.dao;

import sample.model.pojo.ReceiptData;

import java.util.List;

public interface ReceiptDataDao {
    List<ReceiptData> allReceiptData();

    ReceiptData findById(int id);

    boolean insertReceiptData(ReceiptData receiptData);

    boolean updateReceiptData(ReceiptData receiptData);

}
